import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Team {
    private Member[] members;
    /**
     * Constructor for Team object.
     * @param members Array of member objects
     * @throws IllegalArgumentException if members is null or elements in members are null
     */
    public Team(Member[] members) throws IllegalArgumentException {
        if (members == null) {
            throw new IllegalArgumentException("Members Array cannot be null");
        }
        this.members = new Member[members.length];
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                throw new IllegalArgumentException("Members Array cannot contain null elements");
            } else {
                this.members[i] = members[i];
            }
        }
    }
    /**
     * Method that mergeSorts the elements in members.
     */
    public void mergeSortMembers() {
        this.members = mergeHelp(members);
    }
    /**
     * Recursive helper method for mergeSortMembers that merge sorts the inputted array.
     * @param arr members array that needs to be merge sorted
     * @return the merged array from the HWUtils.merge method
     */
    private Member[] mergeHelp(Member[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Member[] arr1 = HWUtils.copyOfRange(arr, 0, mid);
        Member[] arr2 = HWUtils.copyOfRange(arr, mid, arr.length);
        arr1 = mergeHelp(arr1);
        arr2 = mergeHelp(arr2);
        return HWUtils.merge(arr1, arr2);
    }
    /**
     * Method that merges a 2-d array of members into the 1-d members array.
     * @param arrarr 2-d array of members objects
     */
    public void mergeAllMembers(Member[][] arrarr) {
        int length = getLength(arrarr, 0);
        Member[] arr1 = new Member[length];
        arr1 = mergePar(arr1, arrarr, 0);
        this.members = HWUtils.merge(arr1, members);
        mergeSortMembers();
    }
    /**
     * Recursive helper method that calculates the length needed for the 1-d array.
     * @param arrarr 2-d array of members objects
     * @param x counter to keep track of length
     * @return the length of the new 1-d array
     */
    private int getLength(Member[][] arrarr, int x) {
        if (x == arrarr.length - 1) {
            return arrarr[arrarr.length - 1].length;
        } else {
            return arrarr[x].length + getLength(arrarr, ++x);
        }
    }
    /**
     * recursive helper method that turns the imputted 2-d array as a 1-d array
     * @param arr1 the 1-d array that the method is putting elements into
     * @param arrarr 2-d array of members objects
     * @param count counter to keep track of index
     * @return the final 1-d array created form the 2-d array
     */
    private Member[] mergePar(Member[] arr1, Member[][] arrarr, int count) {
        if (count == arrarr.length - 1) {
            return arrarr[count];
        }
        arr1 = HWUtils.merge(arrarr[count], mergePar(arr1, arrarr, ++count));
        return arr1;
    }
    /**
     * Method that searches for the passed in Member object.
     * @param member member object to search for
     * @return the member object in the members array
     * @throws NoSuchElementException if the member object isn't found
     * @throws IllegalArgumentException if the passed in member is null
     */
    public Member searchMember(Member member) throws NoSuchElementException, IllegalArgumentException {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null!");
        }
        mergeSortMembers();
        return binary(member, members);
    }
    /**
     * Recursive helper method that binary searches the members array for the member object.
     * @param member the member object to search for
     * @param arr the array to search for the member object in
     * @return the member object found in the members array if the array contains the object.
     * @throws NoSuchElementException if the member object is not found
     */
    private Member binary(Member member, Member[] arr) throws NoSuchElementException {
        if (arr.length <= 1 && arr[0].equals(member)) {
            return arr[0];
        } else if (arr.length <= 1) {
            throw new NoSuchElementException("Member not found!");
        }
        int mid = arr.length / 2;
        if (arr[mid].compareTo(member) < 0) {
            return binary(member, HWUtils.copyOfRange(arr, mid + 1, arr.length));
        } else if (arr[mid].compareTo(member) > 0) {
            return binary(member, HWUtils.copyOfRange(arr, 0, mid - 1));
        } else {
            return arr[mid];
        }
    }
    /**
     * Method that reverses the members array.
     * @return a deep copy of the members array backwards
     */
    public Member[] reverseMembers() {
        int x = members.length;
        Member[] reversed = new Member[x];
        reversed = reverseHelp(0, members.length - 1, reversed);
        return reversed;
    }
    /**
     * Recursive helper method for reverseMembers().
     * @param r index of the reversed array
     * @param m index of the members array
     * @param reversed the array that contains the members elements reversed
     * @return the array that contains the members elements reversed
     */
    private Member[] reverseHelp(int r, int m, Member[] reversed) {
        if (m < 0) {
            return reversed;
        }
        reversed[r++] = members[m--];
        return reverseHelp(r, m, reversed);
    }
    /**
     * Method that randomly selected a leader from the fronted subgroup and a leader from the backend subgroup.
     * @return an ArrayList where the first element is the leader of the fronted subgroup and the second is the
     * leader from the backend subgroup.
     */
    public ArrayList<Member> selectLeaderboard() {
        ArrayList<Member> front = new ArrayList<>();
        ArrayList<Member> back = new ArrayList<>();
        ArrayList<Member>[] arr = leadHelp(0, front, back);
        if (front.size() == 0 && back.size() == 0) {
            throw new NoSuchElementException("Failed to select leaders for both subgroups");
        } else if (front.size() == 0) {
            throw new NoSuchElementException("Failed to select leaders for the %s subgroups");
        } else if (back.size() == 0) {
            throw new NoSuchElementException("Failed to select leaders for the %s subgroups");
        }
        front = arr[0];
        back = arr[1];
        Random rand = new Random();
        ArrayList<Member> leaders = new ArrayList<>();
        int ifront = rand.nextInt(front.size());
        leaders.add(front.get(ifront));
        int iback = rand.nextInt(back.size());
        leaders.add(back.get(iback));
        return leaders;
    }
    /**
     * Recursive helper method for selectLeaderboard() that sorts the member objects
     * into two ArrayLists based on subgroup.
     * @param count index in members
     * @param front ArrayList with frontend members
     * @param back ArrayList with backend members
     * @return an Array of ArrayLists with the front and back ArrayLists
     */
    private ArrayList<Member>[] leadHelp(int count, ArrayList<Member> front, ArrayList<Member> back) {
        if (count == members.length - 1) {
            ArrayList<Member>[] arr = new ArrayList[2];
            arr[0] = front;
            arr[1] = back;
            return arr;
        }
        if (members[count].getSubgroup() == Group.FRONTEND) {
            front.add(members[count]);
        } else if (members[count].getSubgroup() == Group.BACKEND) {
            back.add(members[count]);
        }
        return leadHelp(++count, front, back);
    }
}