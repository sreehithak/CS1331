import java.util.ArrayList;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Olivia {
    /** the total amount of money Olivia can spend. */
    private static double budget = 100000;
    /** the media items in the cart. */
    private static ArrayList<Media> cart;
    /** whether Olivia's console at home is working. */
    private static boolean canUseConsole;
    /**
     * Method that adds a mediaItem to Olivia's cart.
     * @param mediaItem the media object being added to the cart
     * @param store the store that Olivia is shopping at
     * @return boolean value representing whether or not the item was added to the cart
     */
    public static boolean addToCart(Media mediaItem, Blockbuster store) {
        if (mediaItem.getRentalPrice() <= budget && store.findMedia(mediaItem) != null) {
            if (mediaItem instanceof VideoGame) {
                VideoGame game = (VideoGame) mediaItem;
                if (game.getneedsConsole() && !canUseConsole) {
                    return false;
                }
            }
            budget -= mediaItem.getRentalPrice();
            cart.add((store.removeMedia(mediaItem)));
            return true;
        }
        return false;
    }
    /**
     * Method that returns an item from Olivia's cart to the store's mediaItems array list.
     * @param mediaItem the media object being removed from the cart
     * @param store the store that Olivia is shopping at
     */
    public static void changeMind(Media mediaItem, Blockbuster store) {
        int i = cart.indexOf(mediaItem);
        Media itemInCart = cart.get(i);
        budget += mediaItem.getRentalPrice();
        cart.remove(itemInCart);
        store.addMedia(itemInCart);
    }
}