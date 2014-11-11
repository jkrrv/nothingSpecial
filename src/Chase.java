/**
 * Created by James on 11/10/2014.
 */
public class Chase {
     public static int playGame() {
        Mouse m = new Mouse("mouse");
        Cat c = new Cat("cat");


        // verify that animals are not starting on the same location
        while (m.getLocation() == c.getLocation()) {
            m = new Mouse("mouse"); // effectively, re-rerun the constructor.  May be more efficient to make SetStartLocation public and re-call just that method, but that's a bunch more spaghetti here.
        }


        // begin. Assuming both animals move at "the same time"
        do {
            //m.move();
            c.move();

            // The mouse is blind to the cat.  This is the best way to determine if they're in the same place.
            if (m.getLocation() == c.getLocation()) {
                return Cat.STATUS_SNACK;
            }

            // keep doing this until either the above case is met, or the mouse ends the game on his own.
        } while (m.getStatus() == Mouse.STATUS_ALIVE);
        return m.getStatus();
    }
}
