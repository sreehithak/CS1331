/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Driver {
    /**
     * Main method used to test other classes.
     * @param args parameter of the main method.
     */
    public static void main(String[] args) {
        String[] skzMembers = {null, "Felix", "Hyunjin", null, "Jisung", null, "Lee Know", "Seungmin"};
        String[] szkOtherMembers = {"Bang Chan", "Chang Bin", "I.N"};
        String[] bpMembers1 = {"Jennie", "Lisa"};
        String[] bpMembers2 = {"Jisoo", "Rosé"};
        RollerCoaster skz = new RollerCoaster("SKZ", 0, skzMembers, 2.0, 4.0, 9);
        RollerCoaster bp = new RollerCoaster("Blackpink");
        RollerCoaster wp = new RollerCoaster("Blackpink");
        System.out.println(skz.equals(bp));
        System.out.println(bp.equals(wp));
        skz.addPassengers(1, szkOtherMembers);
        bp.addPassengers(7, bpMembers1);
        bp.addPassengers(11, bpMembers2);
        System.out.println(skz);
        System.out.println(bp);
        String[] tourStops2022 = {"Chicago", "Atlanta", "LA", "Miami", "NYC"};
        String[] tourStops2023 = {"Singapore", "Hong Kong", "Tokyo"};
        String[] newJeansMembers1 = {"Hanni", "Hyein"};
        String[] newJeansMembers2 = {"Haerin", "Minji", "Danielle"};
        Trolley northAmericaTour = new Trolley("NewJeans in North America", 3, tourStops2022, 1);
        Trolley asiaTour = new Trolley("NewJeans in Asia", tourStops2023, 0);
        Trolley asiaTour2 = new Trolley("NewJeans in Asia", tourStops2023, 0);
        System.out.println(northAmericaTour.equals(asiaTour));
        System.out.println(asiaTour.equals(asiaTour2));
        System.out.println(northAmericaTour.addPassengers(4, newJeansMembers1));
        System.out.println(asiaTour.addPassengers(5, newJeansMembers2));
        System.out.println(northAmericaTour);
        System.out.println(asiaTour);
    }
}
