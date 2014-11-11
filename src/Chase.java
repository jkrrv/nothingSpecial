import com.sun.deploy.util.StringUtils;

import java.util.Random;

/**
 * Created by James on 11/10/2014.
 */

public class Chase {
    public static final int n = 5; // grid size.  Bridges are on even-numbered rows/columns, regardless of size.
    private static final int runs = 30;
    public static final Random rNG = new Random();

    public static void main(String[] args) {
        int[] results = new int[4];

        //run trials
        for (int i=1; i<=runs; i++) {
            int thisResult = Chase.playGame();
            results[thisResult]++;
            System.out.println(i+": "+nameOfResult(thisResult)+".");
        }

        //print a blank line.
        System.out.println();

        //print each desired stat. (only statuses 1-3)
        for (int i=1; i<4; i++) {
            System.out.print(String.format("%1$" + 16 + "s", nameOfResult(i)+": "));
            System.out.println(String.format("%,.2f%%", ((float)results[i]/(float)runs*100)));
        }


    }

    private static String nameOfResult(int index) {
        switch (index) {
            case Mouse.STATUS_ALIVE:
                return "Continued to live on island";
            case Mouse.STATUS_DROWN:
                return "Mouse Drowned";
            case Mouse.STATUS_ESCAPE:
                return "Mouse Escaped";
            case Cat.STATUS_SNACK:
                return "Cat Snacked";
        }
        throw new IllegalArgumentException("Name of Result is unknown for given result number.");
    }


    public static int playGame() {
        Mouse m = new Mouse("mouse");
        Cat c = new Cat("cat");


        // verify that animals are not starting on the same location
        while (m.getLocation() == c.getLocation()) {
            m = new Mouse("mouse"); // effectively, re-rerun the constructor.  May be more efficient to make SetStartLocation public and re-call just that method, but that'd be more spaghetti here.
        }

        // begin.
        do {
            //debug(m,c);

            m.move();
            //assuming that cat does not win if mouse moves to location from which cat is about to move.
            c.move();

            //debug(m,c);

            // The mouse is blind to the cat.  This is the best way to determine if they're in the same place.
            if (m.getLocation().equals(c.getLocation())) {
                return Cat.STATUS_SNACK;
            }

            // keep doing this until either the above case is met, or the mouse ends the game on his own.
        } while (m.getStatus() == Mouse.STATUS_ALIVE);
        return m.getStatus();
        }

        private static void debug(Mouse m, Cat c) {
        System.out.println("Mouse: " + m.getLocation().x + "," + m.getLocation().y + " " + m.getStatus() +
        "  Cat: " + c.getLocation().x + "," + c.getLocation().y);
    }
}
