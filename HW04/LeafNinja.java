/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class LeafNinja extends Ninja {
    /** int representation of the amount of poison a leaf ninja has */
    private int poisonAmount;
    /**
     * LeafNinja object constructor that creates a LeafNinja object.
     * @param name of the ninja
     * @param health int representation of the health of a ninja
     * @param attack int representation of the attack points for the ninja
     * @param poisonAmount int representation of the amount of poison a leaf ninja has
     */
    public LeafNinja(String name, int health, int attack, int poisonAmount) {
        super(name, health, attack);
        if (poisonAmount < 0) {
            poisonAmount = 5;
        }
        this.poisonAmount = poisonAmount;
    }
    /**
     * No argument LeafNinja object constructor that creates a LeafNinja object.
     */
    public LeafNinja() {
        this("Naruto Uzumaki", 5, 9, 10);
    }
    /**
     * Method that is called when the leaf ninja object attacks another ninja onject using poison.
     * @param otherNinja ninja object that references the ninja being attacked
     */
    public void poisonAttack(Ninja otherNinja) {
        if (poisonAmount > 0) {
            poisonAmount--;
            if (otherNinja instanceof StoneNinja) {
                StoneNinja otherStoneNinja = (StoneNinja) otherNinja;
                if (otherStoneNinja.getNinjaArmor()) {
                    otherStoneNinja.breakArmor();
                }
            } else if (otherNinja instanceof MistNinja) {
                MistNinja otherMistNinja = (MistNinja) otherNinja;
                otherMistNinja.getConfused();
            } else if (otherNinja instanceof LeafNinja) {
                LeafNinja otherLeafNinja = (LeafNinja) otherNinja;
                switch (super.compareTo(otherLeafNinja)) {
                case 0:
                    break;
                case 1:
                    this.poisonAmount++;
                    break;
                case -1:
                    otherLeafNinja.poisonAmount++;
                    break;
                default:
                    break;
                }
            }
        }
    }
    @Override
    public void attackNinja(Ninja otherNinja) {
        this.poisonAttack(otherNinja);
        if (poisonAmount == 0) {
            int newAttack = this.getAttack() / 2;
            otherNinja.getAttacked(newAttack);
        } else {
            super.attackNinja(otherNinja);
        }
    }
    @Override
    public String toString() {
        return String.format("Leaf Ninja: %s/%d", super.toString(), poisonAmount);
    }
}