/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class FifthGreatNinjaWar {
    /** array of ninja objects represnting the first team of ninjas. */
    private Ninja[] firstTeam;
    /** array of ninja objects represnting the second team of ninjas. */
    private Ninja[] secondTeam;
    /**
     * FifthGreatNinjaWar object constructor that creates a Ninja war simulator object.
     * @param firstTeam array of ninja objects represnting the first team
     * @param secondTeam array of ninja objects represnting the second team
     */
    public FifthGreatNinjaWar(Ninja[] firstTeam, Ninja[] secondTeam) {
        if (firstTeam.length != 5 || secondTeam.length != 5) {
            this.firstTeam = new Ninja[5];
            this.secondTeam = new Ninja[5];
        } else {
            this.firstTeam = firstTeam;
            this.secondTeam = secondTeam;
        }
    }
    @Override
    public String toString() {
        String str = "First Team: ";
        for (int i = 0; i < firstTeam.length; i++) {
            if (i == 4) {
                if (firstTeam[4] == null) {
                    str += "Empty";
                } else {
                    str += firstTeam[4].toString();
                }
            } else {
                if (firstTeam[i] == null) {
                    str += "Empty, ";
                } else {
                    str += firstTeam[i].toString() + ", ";
                }
            }
        }
        str += " vs Second Team: ";
        for (int i = 0; i < secondTeam.length; i++) {
            if (i == 4) {
                if (secondTeam[4] == null) {
                    str += "Empty";
                } else {
                    str += secondTeam[4].toString();
                }
            } else {
                if (secondTeam[i] == null) {
                    str += "Empty, ";
                } else {
                    str += secondTeam[i].toString() + ", ";
                }
            }
        }
        return str;
    }
    /**
     * Method that compares the two ninja teams and predicts which one would win the battle.
     */
    public void compareTeams() {
        int num1 = 0;
        int num2 = 0;
        int x;
        for (int i = 0; i < 5; i++) {
            if (firstTeam[i] == null) {
                x = -1;
            } else {
                x = firstTeam[i].compareTo(secondTeam[i]);
            }
            switch (x) {
            case 0:
                break;
            case 1:
                num1++;
                break;
            case -1:
                num2++;
                break;
            default:
                break;
            }
        }
        String winner;
        if (num1 == num2) {
            System.out.println("It is an even match.");
        } else {
            if (num1 > num2) {
                winner = "first";
            } else {
                winner = "second";
            }
            System.out.printf("The %s team will probably win.", winner);
        }
    }
    /**
     * private helper method that determines how many fainted ninjas there are in team 1.
     * @return boolean representation of whether or not team 1 has lost
     */
    private boolean team1HasLost() {
        int x = 0;
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i] == null) {
                x++;
            }
        }
        return x == 5;
    }
    /**
     * private helper method that determines how many fainted ninjas there are in team 2.
     * @return boolean representation of whether or not team 2 has lost
     */
    private boolean team2HasLost() {
        int x = 0;
        for (int i = 0; i < secondTeam.length; i++) {
            if (secondTeam[i] == null) {
                x++;
            }
        }
        return x == 5;
    }
    /**
     * Method that simulates battle between two ninja teams and prints the winner.
     */
    public void battle() {
        int i = 0;
        int x = 0;
        while (!team1HasLost() && !team2HasLost()) {
            firstTeam[i].attackNinja(secondTeam[x]);
            secondTeam[x].attackNinja(firstTeam[i]);
            if (firstTeam[i].hasFainted()) {
                firstTeam[i] = null;
                if (i < 4) {
                    i++;
                }
            }
            if (secondTeam[x].hasFainted()) {
                secondTeam[x] = null;
                if (x < 4) {
                    x++;
                }
            }
            if (firstTeam[i] == null) {
                i++;
            } else if (secondTeam[x] == null) {
                x++;
            }
        }
        String str;
        if (team1HasLost() && team2HasLost()) {
            System.out.println("Both teams fainted.");
        } else {
            if (team1HasLost()) {
                str = "second";
            } else {
                str = "first";
            }
            System.out.printf("The %s team won!%n", str);
        }
    }
    /**
     * Java main method to test code.
     * @param args String aray argument of the main method
     */
    public static void main(String[] args) {
        Ninja[] newJeans = new Ninja[5];
        StoneNinja haerin = new StoneNinja("Haerin", 0, -1000, false);
        LeafNinja hanni = new LeafNinja("Hanni", 0, 2, 1);
        MistNinja hyein = new MistNinja("Hyein", 0, 0, 0);
        StoneNinja danielle = new StoneNinja("Danielle", 0, 0, false);
        newJeans[0] = haerin;
        newJeans[1] = hanni;
        newJeans[2] = null;
        newJeans[3] = hyein;
        newJeans[4] = danielle;
        Ninja[] txt = new Ninja[5];
        StoneNinja beomgyu = new StoneNinja("Beomgyu", 0, 0, false);
        LeafNinja taehyun =  new LeafNinja("Taehyun", 0, 0, 10);
        MistNinja soobin = new MistNinja("Soobin", 0, 0, 12);
        MistNinja yeonjun = new MistNinja("Yeonjun", 0, 0, 0);
        txt[0] = soobin;
        txt[1] = taehyun;
        txt[2] = yeonjun;
        txt[3] = beomgyu;
        txt[4] = null;
        FifthGreatNinjaWar war = new FifthGreatNinjaWar(newJeans, txt);
        war.compareTeams();
        war.battle();
    }
}