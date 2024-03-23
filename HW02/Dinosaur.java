/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Dinosaur {
    /** name of the Dinosaur that connot be changed */
    protected final String name;
    /** height of the Dinosaur */
    private double height;
    /** width of the Dinosaur */
    private double width;
    /** weight of the Dinosaur */
    private double weight;
    /** total number of enclosures at the park */
    protected static int totalEnclosures;
    /**
     * Dinosaur object constructor.
     * @param name name of the Dinosaur
     * @param height height of the Dinosaur
     * @param width width of the Dinosaur
     * @param weight weight of the Dinosaur
     */
    public Dinosaur(String name, double height, double width, double weight) {
        if (name == null || name.isBlank()) {
            name = "Barney";
        }
        this.name = name;
        this.height = height;
        this.width = width;
        this.weight = weight;
    }
    /**
     * Dinosaur object no argument constructor.
     */
    public Dinosaur() {
        this("Barney", 15, 20, 1000);
    }
    /**
     * Dinosaur object copy constructor.
     * @param dinosaur another Dinosaur object that is being copied and used to create another Dinosaur object
     */
    public Dinosaur(Dinosaur dinosaur) {
        this(dinosaur.getName(), dinosaur.getHeight(), dinosaur.getWidth(), dinosaur.getWeight());
    }
    /**
     * Method that calculates the size of a dinosaur enclosure.
     * @return a double that represents the size of the enclosure
     */
    public double enclosureSize() {
        double size = 10 * width * height;
        size = Math.round(size * 100);
        size = size / 100;
        return size;
    }
    /**
     * Method that calculates the amount of food a dinosaur will eat.
     * @return a double that represents the amount of food
     */
    public double calculateFood() {
        double food = weight * width * height;
        food = Math.round(food * 100);
        food = food / 100;
        return food;
    }
    /**
     * @return a string representation of the Dinosaur object
     */
    public String toString() {
        String str = String.format("%s requires a %.2f square foot enclosure", name, enclosureSize());
        str += String.format(" and %.2f pounds of food.", calculateFood());
        return str;
    }
    /**
     * Method to build an enclosure at the Dinosaur park.
     * @return a string that tells the user whether or not a dinosaur enclosure was added to the park
     */
    public String buildEnclosure() {
        String str = toString();
        if (enclosureSize() > 6000 || calculateFood() > 80000) {
            return str +  String.format(" %s is too expensive for the park!", name);
        } else {
            totalEnclosures++;
            return str + String.format(" %s has been added to the park!", name);
        }
    }
    /**
     * Accessor method that retrieves the height.
     * @return the height of the Dinosaur
     */
    public double getHeight() {
        return height;
    }
    /**
     * Accessor method that retrieves the width.
     * @return the width of the Dinosaur
     */
    public double getWidth() {
        return width;
    }
    /**
     * Accessor method that retrieves the weight.
     * @return the weight of the Dinosaur
     */
    public double getWeight() {
        return weight;
    }
    /**
     * Accessor method that retrieves the name.
     * @return the name of the Dinosaur
     */
    public String getName() {
        return name;
    }
    /**
     * Accessor method that retrieves the weight.
     * @return the number of enclosures in the park
     */
    public static int getTotalEnclosures() {
        return totalEnclosures;
    }
    /**
     * Setter method that sets the height.
     * @param x new height
     */
    public void setHeight(double x) {
        height = x;
    }
    /**
     * Setter method that sets the width.
     * @param x new width
     */
    public void setWidth(double x) {
        width = x;
    }
    /**
     * Setter method that sets the weight.
     * @param x new weight
     */
    public void setWeight(double x) {
        weight = x;
    }
}