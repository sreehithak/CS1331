/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Pack {
    /** size of the pack */
    private final int size;
    /** name of the pack */
    private final String packName;
    /**
     * Pack object constructor.
     * @param size size of the pack
     * @param packName name of the pack
     */
    public Pack(int size, String packName) {
        if (packName == null || packName.isBlank()) {
            packName = "The Power Pack";
        }
        if (size < 0) {
            size = 4;
        }
        this.size = size;
        this.packName = packName;
    }
    /**
     * @Override
     * @return a string representation of the Pack object
     */
    public String toString() {
        return String.format("%s is a family of dinosaurs of size %d!", packName, size);
    }
    /**
     * Accessor method that retrieves the size.
     * @return size of the pack
     */
    public int getSize() {
        return size;
    }
    /**
     * Accessor method that retrieves the name.
     * @return name of the pack
     */
    public String getPackName() {
        return packName;
    }
}