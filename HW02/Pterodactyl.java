/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Pterodactyl extends Dinosaur {
    /** Double representing how high a Pterodactyl can fly. */
    private double flightCeiling;
    /**
     * Pterodactyl object constructor.
     * @param name name of the Pterodactyl
     * @param height height of the Pterodactyl
     * @param width width of the Pterodactyl
     * @param weight weight of the Pterodactyl
     * @param flightCeiling how high a Pterodactyl can fly
     */
    public Pterodactyl(String name, double height, double width, double weight, double flightCeiling) {
        super(name, height, width, weight);
        if (flightCeiling < 10 || flightCeiling > 100) {
            flightCeiling = 50;
        }
        this.flightCeiling = flightCeiling;
    }
    /**
     * Pterodactyl object constructor.
     * @param name name of the Pterodactyl
     * @param width width of the Pterodactyl
     */
    public Pterodactyl(String name, double width) {
        this(name, 15, width, 1000, 50);
    }
    /**
     * Pterodactyl object constructor.
     * @param name name of the Pterodactyl
     */
    public Pterodactyl(String name) {
        this(name, 15, 12, 1000, 50);
    }
    /**
     * Pterodactyl object copy constructor.
     * @param other another Pterodactyl object that is being copied and used to create another Pterodactyl object
     */
    public Pterodactyl(Pterodactyl other) {
        this(other.getName(), other.getHeight(), other.getWidth(), other.getWeight(), other.getFlightCeiling());
    }
    /**
     * @Override
     * @return a double that represents the size of the enclosure a Pterodactyl needs
     */
    public double enclosureSize() {
        double size = 4 * getWidth() * getHeight() + flightCeiling;
        size = Math.round(size * 100);
        size = size / 100;
        return size;
    }
    /**
     * @Override
     * @return a string representation of the Pterodactyl object
     */
    public String toString() {
        String str = String.format("%s can fly %.2f feet into the air! ", getName(), flightCeiling);
        str +=  String.format("%s requires a %.2f square foot enclosure ", getName(), enclosureSize());
        str += String.format("and %.2f pounds of food.", calculateFood());
        return str;
    }
    /**
     * Setter method that sets the weight.
     * @param x new flightCeiling
     */
    public void setFlightCeiling(double x) {
        flightCeiling = x;
    }
    /**
     * @return Accessor method that returns the flightCeiling.
     */
    public double getFlightCeiling() {
        return flightCeiling;
    }
}