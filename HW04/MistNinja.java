/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class MistNinja extends Ninja {
    /** int that represents the chances of a mist ninja getting hit by another ninja  */
    private int hitChance;
    /**
     * Ninja object constructor that creates a Ninja object.
     * @param name of the ninja
     * @param health int representation of the health of a ninja
     * @param attack int representation of the attack points for the ninja
     * @param hitChance int that represents the chances of a mist ninja getting hit by another ninja
     */
    public MistNinja(String  name, int health, int attack, int hitChance) {
        super(name, health, attack);
        if (hitChance < 5 || hitChance > 15) {
            hitChance = 12;
        }
        this.hitChance = hitChance;

    }
    /**
     * No argument Ninja object constructor that creates a Ninja object.
     */
    public MistNinja() {
        this("Naruto Uzumaki", 7, 8, 12);
    }
    /**
     * Method that increments hit chance if it stays within its range (under 15).
     */
    public void getConfused() {
        if ((hitChance + 1) < 15) {
            hitChance++;
        }
    }
    @Override
    public void getAttacked(int damage) {
        if (!((damage % hitChance) == 0)) {
            super.getAttacked(damage);
        }
    }
    @Override
    public String toString() {
        return String.format("Mist Ninja: %s/%d", super.toString(), hitChance);
    }
}