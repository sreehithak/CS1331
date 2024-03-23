import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 * @param <T> Generic class
 */
public class GenericLineup<T extends Comparable<T>> {
    private ArrayList<T> lineup;
    private boolean isAscending;
    /**
     * Constructor for GenericLineup object.
     * @param first object in the lineup
     * @param second object in the lineup
     * @param third object in the lineup
     * @param fourth object in the lineup
     */
    public GenericLineup(T first, T second, T third, T fourth) {
        this.isAscending = true;
        this.lineup = new ArrayList<T>(4);
        if (first != null && second != null && third != null && fourth != null) {
            lineup.add(first);
            lineup.add(second);
            lineup.add(third);
            lineup.add(fourth);
        }
    }
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < 4; i++) {
            if (i >= size() && i == 3) {
                str += String.format("null");
            } else if (i >= size() && i < 3) {
                str += String.format("null -> ");
            } else if (i == 3 && i == size() - 1) {
                str += String.format("%s", lineup.get(i));
            } else if (i < size()) {
                str += String.format("%s -> ", lineup.get(i));
            }
        }
        return str;
    }
    /**
     * Method that adds the passed in element to the lineup.
     * @param element that is being added to the lineup
     * @return whether or not the element has been added
     */
    public boolean add(T element) {
        if (lineup.size() == 4 || element == null) {
            return false;
        } else if (isAscending) {
            int x = 0;
            while (x < lineup.size()) {
                if (lineup.get(x).compareTo(element) > 0) {
                    lineup.add(x, element);
                    return true;
                } else {
                    x++;
                }
            }
            lineup.add(element);
            return true;
        } else {
            for (int i = 0; i < lineup.size(); i++) {
                if (lineup.get(i).compareTo(element) < 0) {
                    lineup.add(i, element);
                    return true;
                }
            }
            lineup.add(element);
            return true;
        }
    }
    /**
     * Removes passed in element from the lineup.
     * @param element to be removed
     * @return whether or not the element was removed
     */
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        return lineup.remove(element);
    }
    /**
     * Method that tells user whether or not the lineup contains the passed in element.
     * @param element to check for
     * @return whether or not the lineup contains the element
     */
    public boolean contains(T element) {
        if (element == null) {
            return false;
        }
        return lineup.contains(element);
    }
    /**
     * Accessor method for the size of the lineup.
     * @return the size of the lineup
     */
    public int size() {
        return lineup.size();
    }
    /**
     * Reverses the order of the lineup.
     */
    public void reverseLineup() {
        Collections.reverse(lineup);
        if (isAscending) {
            isAscending = false;
        } else {
            isAscending = true;
        }
    }
    /**
     * Main method to test code.
     * @param args String array argument for main method.
     */
    public static void main(String[] args) {
        System.out.println("////    CREATE LINE   ///");
        GenericLineup<String> l1 = new GenericLineup<>("5", "6", "7", "8");
        GenericLineup<String> l2 = new GenericLineup<>("1", "1", "2", "7");
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======NULL LINE=======");
        GenericLineup<String> l3 = new GenericLineup<>("1", "2", null, "5");
        GenericLineup<String> l4 = new GenericLineup<>(null, null, null, null);
        System.out.println(l3.toString() + ", " + l3.size() + ", " + l3.isAscending);
        System.out.println(l4.toString() + ", " + l4.size() + ", " + l4.isAscending);
        System.out.println();

        System.out.println("======REMOVE FALSE=======");
        System.out.println(l1.remove("9"));
        System.out.println(l2.remove("0"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======REMOVE NULL=======");
        System.out.println(l1.remove(null));
        System.out.println(l2.remove(null));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======REMOVE ALL TRUE=======");
        System.out.println(l1.remove("6"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l1.remove("8"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l1.remove("7"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l1.remove("5"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.remove("1"));
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println(l2.remove("1"));
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println(l2.remove("2"));
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println(l2.remove("7"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======REMOVE EMPTY=======");
        System.out.println(l1.remove("6"));
        System.out.println(l2.remove("0"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("////    ASCENDING   ///");
        System.out.println();
        System.out.println("======ADD TO EMPTY======");
        System.out.println(l1.add("3"));
        System.out.println(l2.add("10"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======ADD FIRST======");
        System.out.println(l1.add("0"));
        System.out.println(l2.add("10"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();
        System.out.println("======ADD LAST======");
        System.out.println(l1.add("6"));
        System.out.println(l2.add("12"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();
        System.out.println("======ADD MIDDLE=======");
        System.out.println(l1.add("2"));
        System.out.println(l2.add("11"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();
        System.out.println("======ADD FULL=======");
        System.out.println(l1.add("0"));
        System.out.println(l2.add("2"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();
        System.out.println("======ADD NULL=======");
        System.out.println(l1.add(null));
        System.out.println(l2.add(null));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======REMOVE BEFORE REVERSE======");
        l1.remove("6");
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        l1.reverseLineup();
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println();

        System.out.println("======REVERSE BEFORE REMOVE======");
        l2.reverseLineup();
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        l2.remove("11");
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======REMOVE FROM REVERSE======");
        l1.remove("0");
        l1.remove("2");
        l2.remove("10");
        l2.remove("12");
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();

        System.out.println("======REVERSE EMPTY LINES======");
        l3.reverseLineup();
        l4.reverseLineup();
        System.out.println(l3.toString() + ", " + l3.size() + ", " + l3.isAscending);
        System.out.println(l4.toString() + ", " + l4.size() + ", " + l4.isAscending);
        System.out.println();

        System.out.println("////    DESCENDING   ///");
        System.out.println();
        System.out.println("======ADD FIRST======");
        System.out.println(l1.add("7"));
        System.out.println(l2.add("15"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();
        System.out.println("======ADD LAST======");
        System.out.println(l1.add("-6"));
        System.out.println(l2.add("0"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();
        System.out.println("======ADD MIDDLE=======");
        System.out.println(l1.add("4"));
        System.out.println(l2.add("09"));
        System.out.println(l1.toString() + ", " + l1.size() + ", " + l1.isAscending);
        System.out.println(l2.toString() + ", " + l2.size() + ", " + l2.isAscending);
        System.out.println();
    }
}