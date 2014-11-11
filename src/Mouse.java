import java.awt.*;
import java.util.ArrayList;

/**
 * Created by James on 11/10/2014.
 */
public class Mouse extends Animal {
    static final public int STATUS_ALIVE = 0;
    static final public int STATUS_DROWN = 2; // rearranged to meet order expected in output specs.
    static final public int STATUS_ESCAPE = 1;

    private int status = 0;

    public void move() {
        if (getStatus() != STATUS_ALIVE) {
            throw new IllegalStateException("Mouse is already off the island and can't move about the island.");
        }
        /* "override the move method, to randomly move north, south, east or west. Again, the cat will not jump in the water, nor will it cross a bridge." */

        //determine options for where to go next (any direction will do; don't think about it until after you're there.)
        ArrayList<Point> nextLoc = new ArrayList<Point>();
        nextLoc.add(new Point(location.x - 1, location.y));
        nextLoc.add(new Point(location.x + 1, location.y));
        nextLoc.add(new Point(location.x, location.y - 1));
        nextLoc.add(new Point(location.x, location.y + 1));


        //pick one.
        location = nextLoc.get(rNG.nextInt(nextLoc.size()));


        //determine if alive/well
        if (location.y<1 || location.y>Chase.n) {  // off the top or bottom of the island
            if ((location.x & 1) == 0) {
                // even -> bridge.
                this.status = STATUS_ESCAPE;
            } else {
                // odd -> drown
                this.status = STATUS_DROWN;
            }
        }
        if (location.x<1 || location.x>Chase.n) {  // off the left or right of the island
            if ((location.y & 1) == 0) {
                // even -> bridge.
                this.status = STATUS_ESCAPE;
            } else {
                // odd -> drown
                this.status = STATUS_DROWN;
            }
        }

        //algo verification.
        //System.out.println(location.x + ", " + location.y + ", " + status);
    }

    public Mouse(String name) {
        /* "It'll have a single constructor, that takes a String, calls the parent class' constructor to set the name." */
        super(name, Chase.rNG); // since there's no indication in the instructions that the Mouse should have the rNG passed to it, it's taken from Chase.
    }

    public int getStatus() {
        //return something useful to indicate whether mouse is drowned, escaped, or still alive.
        return this.status;
    }
}
