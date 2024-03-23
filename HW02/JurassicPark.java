/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class JurassicPark {
    /**
     * @param args main method for testing other classes
     */
    public static void main(String[] args) {
        Pack svt = new Pack(4, "SEVENTEEN");
        Dinosaur dino = new Dinosaur("dino", 4, 2, 25);
        Dinosaur hoshi = new Dinosaur();
        Dinosaur wonwoo = new Dinosaur(hoshi);
        Pterodactyl mingyu = new Pterodactyl("mingyu", 5);
        Pterodactyl joshua = new Pterodactyl("joshua");
        Pterodactyl seungkwan = new Pterodactyl("seungkwan", 5, 5, 5, 0.2);
        Pterodactyl dk = new Pterodactyl(seungkwan);
        Velociraptor vernon = new Velociraptor("vernon", 5.5);
        Velociraptor scoups = new Velociraptor("scoups", 7, 10, 100, 350, svt);
        Velociraptor minghao = new Velociraptor(scoups);
        System.out.println(dino.buildEnclosure());
        System.out.println(hoshi.buildEnclosure());
        System.out.println(mingyu.buildEnclosure());
        System.out.println(seungkwan.buildEnclosure());
        System.out.println(vernon.buildEnclosure());
        System.out.println(scoups.buildEnclosure());
        System.out.println(Dinosaur.getTotalEnclosures());
    }
}