/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Velociraptor extends Dinosaur {
    /** speed of the velociraptor */
    private int speed;
    /** tells user whether or not the velociraptor is in a pack and information about the pack */
    private Pack pack;
    /**
     * Velociraptor object constructor.
     * @param name name of the Velociraptor
     * @param height height of the Velociraptor
     * @param width width of the Velociraptor
     * @param weight weight of the Velociraptor
     * @param speed speed of the Velociraptor
     * @param pack information about the Velociraptor's pack (null if its not in a pack)
     */
    public Velociraptor(String name, double height, double width, double weight, int speed, Pack pack) {
        super(name, height, width, weight);
        this.speed = speed;
        this.pack = pack;
    }
    /**
     * Velociraptor object constructor.
     * @param name name of the Velociraptor
     * @param height height of the Velociraptor
     */
    public Velociraptor(String name, double height) {
        this(name, height, 20, 1000, 30, null);
    }
    /**
     * Velociraptor object constructor.
     * @param other another Velociraptor object that is being copied to create another Velociraptor object
     */
    public Velociraptor(Velociraptor other) {
        this(other.getName(), other.getHeight(), other.getWidth(),
            other.getWeight(), other.getSpeed(), other.getPack());
    }
    /**
     * @Override
     * @return a double that represents the size of the enclosure a Velociraptor needs
     */
    public double enclosureSize() {
        double size;
        if (pack == null) {
            size = 4 * getWidth() * getHeight();
        } else {
            size = pack.getSize() * getWidth() * getHeight();
        }
        size = Math.round(size * 100);
        size = size / 100;
        return size;
    }
    /**
     * @Override
     * @return a double that represents the amount of food
     */
    public double calculateFood() {
        double food = getWeight() * speed * getHeight();
        food = Math.round(food * 100);
        food = food / 100;
        return food;
    }
    /**
     * @Override
     * @return a string representation of the Velociraptor object
     */
    public String toString() {
        String str;
        if (pack == null) {
            return super.toString();
        } else {
            str = String.format("%s is a family of dinosaurs of size %d! ", pack.getPackName(), pack.getSize());
            str += String.format("%s requires a %.2f square foot enclosure ", getName(), enclosureSize());
            str += String.format("and %.2f pounds of food.", calculateFood());
            return str;
        }
    }
    /**
     * Accessor method that retrieves the speed.
     * @return speed of the Velociraptor
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * Accessor method that retrieves the pack.
     * @return the pack that the Velociraptor is in
     */
    public Pack getPack() {
        return pack;
    }
    /**
     * Setter method that sets the speed.
     * @param x new speed
     */
    public void setSpeed(int x) {
        speed = x;
    }
    /**
     * Setter method that sets the new pack.
     * @param x new pack
     */
    public void setPack(Pack x) {
        pack = x;
    }
}