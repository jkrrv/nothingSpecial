/**
 * Created by James on 11/10/2014.
 */
public class Mouse extends Animal {
    static final public int STATUS_ALIVE = 0;
    static final public int STATUS_DROWN = 1;
    static final public int STATUS_ESCAPE = 2;

    public void move() {
        if (getStatus() == STATUS_ALIVE) {
            /* "override the move method, to randomly move north, south, east or west. Again, the cat will not jump in the water, nor will it cross a bridge." */
            return;
        }
        throw new IllegalStateException("Mouse is no longer on the island and cannot move as you'd like.");
    }

    public Mouse(String name) {
        /* "It'll have a single constructor, that takes a String, calls the parent class' constructor to set the name." */
        super(name, Main.rNG); // since there's no indication that the Cat should have the rNG passed to it, it's taken from Main.
    }

    public int getStatus() {
        //return something useful to indicate whether mouse is drowned, escaped, or still alive.
        return 0;
    }
}
