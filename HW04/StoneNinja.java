/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class StoneNinja extends Ninja {
    /** boolean represntation of a ninja's armor */
    private boolean ninjaArmor;
    /**
     * StonNinja object constructor that creates a StoneNinja object.
     * @param name of the ninja
     * @param health int representation of the health of a ninja
     * @param attack int representation of the attack points for the ninja
     * @param ninjaArmor boolean represntation of a ninja's armor
     */
    public StoneNinja(String name, int health, int attack, boolean ninjaArmor) {
        super(name, health, attack);
        this.ninjaArmor = ninjaArmor;
    }
    /**
     * No argument StonNinja object constructor that creates a StoneNinja object.
     */
    public StoneNinja() {
        this("Naruto Uzumaki", 8, 10, true);
    }
    /**
     * Method that breaks a Stone Ninja's armor by setting ninjaArmor to false.
     */
    public void breakArmor() {
        ninjaArmor = false;
    }
    @Override
    public void getAttacked(int damage) {
        if (ninjaArmor) {
            damage -= 20;
            if (damage < 0) {
                damage = 0;
            }
            ninjaArmor = false;
        }
        super.getAttacked(damage);
    }
    @Override
    public String toString() {
        return String.format("Stone Ninja: %s/%s", super.toString(), ninjaArmor);
    }
    /**
     * Accessor method that returns the value of ninjaArmor.
     * @return the value of ninjaArmor
     */
    public boolean getNinjaArmor() {
        return ninjaArmor;
    }
}