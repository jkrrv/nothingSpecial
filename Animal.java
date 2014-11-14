import java.awt.Point;
import java.util.Random;


/**
 * Created by James on 11/10/2014.
 */
public abstract class Animal {
    /* Create an Animal abstract class. It'll have
    a protected attribute, of type Point, its location on the map, and
    a private String attribute, the animal's name. You'll need to add other attributes, as well. */

    protected Point location;
    private String name;
    protected Random rNG;

    public Animal(String name, Random rNG) { /* constructor */
        this.name = name;
        this.rNG = rNG;
        setStartLocation(new Point(this.rNG.nextInt(Chase.n)+1,this.rNG.nextInt(Chase.n)+1));
    }


    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }

    private void setStartLocation(Point location) {
        this.location = location;
    }

    public abstract void move();
}
