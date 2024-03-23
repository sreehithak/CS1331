/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public abstract class Ninja implements Comparable<Ninja> {
    /** Strng representaion of the name of the ninja */
    private String name;
    /** int representation of the health of a ninja */
    private int health;
    /** int representation of the attack points for the ninja */
    private int attack;
    /**
     * Ninja object constructor that creates a Ninja object.
     * @param name of the ninja
     * @param health int representation of the health of a ninja
     * @param attack int representation of the attack points for the ninja
     */
    public Ninja(String name, int health, int attack) {
        if (name == null || name.isBlank()) {
            this.name = "Naruto Uzumaki";
        } else {
            this.name = name;
        }
        if (health <= 0) {
            this.health = 1;
        } else {
            this.health = health;
        }
        if (attack < 2) {
            this.attack = 2;
        } else {
            this.attack = attack;
        }
    }
    /**
     * Method that tells the user whether or not a Ninja has fainted.
     * @return boolean representing whether or not a ninja has fainted
     */
    public boolean hasFainted() {
        return health <= 0;
    }
    /**
     * Method that is called when a ninja gets attacked.
     * @param damage an integer representation of the damage a ninja goes through
     */
    public void getAttacked(int damage) {
        health -= damage;
    }
    /**
     * Method that is called when this Ninja attacks another ninja.
     * @param otherNinja the Ninja being attacked
     */
    public void attackNinja(Ninja otherNinja) {
        otherNinja.getAttacked(this.attack);
    }
    @Override
    public String toString() {
        return String.format("%s/%d/%d", name, attack, health);
    }
    @Override
    public int compareTo(Ninja otherNinja) {
        if (otherNinja == null) {
            return 1;
        }
        //Ninja otherNinja = (Ninja) otherObj;
        int numThis = this.health + this.attack;
        int numOther = otherNinja.health + otherNinja.attack;
        if (numOther == numThis) {
            return 0;
        } else if (numThis > numOther) {
            return 1;
        } else {
            return -1;
        }
    }
    /**
     * Accessor method that returns the value of attack.
     * @return int representation of the attack points for the ninja
     */
    public int getAttack() {
        return this.attack;
    }
}