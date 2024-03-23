import java.util.ArrayList;
public class Driver {
    public static void main(String[] args) {
        Member[] members = new Member[6];
        Member kb9 = new Member("Ken", Group.BACKEND, 9);
        Member eb8 = new Member("Erich", Group.BACKEND, 8);
        Member nf7 = new Member("Nathalie", Group.FRONTEND, 7);
        Member ef6 = new Member("Eman", Group.FRONTEND, 6);
        Member ef8 = new Member("Erich", Group.FRONTEND, 8);
        Member eb10 = new Member("Erich", Group.BACKEND, 10);

        members[0] = kb9;
        members[1] = eb8;
        members[2] = nf7;
        members[3] = ef6;
        members[4] = ef8;
        members[5] = eb10;

        Team abc = new Team(members);

        // abc.mergeSortMembers();

        // for(int i = 0; i < abc.members.length; i++) {
        //     //System.out.println(abc.members[i]);
        // }
        //System.out.println(abc.searchMember(eb10));
        //abc.reverseMembers();

        Member[][] membermember = new Member[3][2];
        membermember[0][0] = new Member("Uzma", Group.FRONTEND, 40);
        membermember[0][1] = new Member("Isabella", Group.BACKEND, 20);
        membermember[1][0] = new Member("Rhea", Group.FRONTEND, 6);
        membermember[1][1] = new Member("Areta", Group.BACKEND, 45);
        membermember[2][0] = new Member("Sreehitha", Group.FRONTEND, 4);
        membermember[2][1] = new Member("Sabah", Group.BACKEND, 3);
        // for(int i = 0; i < membermember.length; i++) {
        //     for(int x = 0; x < membermember[i].length; x++) {
        //         System.out.println(membermember[i][x]);
        //     }
        // }
        //abc.mergeAllMembers(membermember);
        // for(int i = 0; i < abc.members.length; i++) {
        //     System.out.println(abc.members[i]);
        // }
        ArrayList<Member> mem = abc.selectLeaderboard();
        System.out.println(mem.get(0));
        System.out.println(mem.get(1));
    }
}
