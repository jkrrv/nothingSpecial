import java.awt.Point;
import java.util.Random;


/**
 * Created by James on 11/10/2014.
 */
public abstract class Animal {

    private Point location;
    private String name;
    private Random rNG;

    public Animal(String name, Random rNG) { /* constructor */
        this.name=name;
        this.rNG = rNG;
        this.location.setLocation(this.rNG.nextInt(Main.n),this.rNG.nextInt(Main.n));
    }


    public String getName() {
        return name;
    }

    public Point getLocation() {
        return location;
    }

    public void setStartLocation(Point location) {
        this.location = location;
    }

    public abstract void move();
}
