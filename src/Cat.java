import java.awt.*;
import java.util.ArrayList;

/**
 * Created by James on 11/10/2014.
 */
public class Cat extends Animal {
    /* "Inherit from Animal to create a Cat class;" */

    static final public int STATUS_SNACK = 3;

    public void move() {
        /* "override the move method, to randomly move north, south, east or west. Again, the cat will not jump in the water, nor will it cross a bridge." */

        //determine options for where to go next
        ArrayList<Point> nextLoc = new ArrayList<Point>();
        if (location.x>1) {
            //col 1 is the column furthest to the left, still on the island.  If x>1, left is an option still on the island.
            nextLoc.add(new Point(location.x - 1, location.y));
        }
        if (location.x<Main.n) {
            // col n is the column furthest to the right, still on the island.  If x<n, right is an option still on the island.
            nextLoc.add(new Point(location.x + 1, location.y));
        }

        if (location.y>1) {
            //row 1 is the row furthest to the top, still on the island.  If y>1, up is an option still on the island.
            nextLoc.add(new Point(location.x, location.y - 1));
        }
        if (location.y<Main.n) {
            // row n is the row furthest to the bottom, still on the island.  If y<n, down is an option still on the island.
            nextLoc.add(new Point(location.x, location.y + 1));
        }

        //pick one.
        location = nextLoc.get(rNG.nextInt(nextLoc.size()));


        //algo verification.
        System.out.println(location.x + ", " + location.y);


    }

    public Cat(String name) {
        /* "It'll have a single constructor, that takes a String, calls the parent class' constructor to set the name." */
        super(name, Main.rNG); // since there's no indication that the Cat should have the rNG passed to it, it's taken from Main.
    }

}
