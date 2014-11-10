/**
 * Created by James on 11/10/2014.
 */
public class Cat extends Animal { /* Inherit from Animal to create a Cat class; */

    public void move() {
        /* "override the move method, to randomly move north, south, east or west. Again, the cat will not jump in the water, nor will it cross a bridge." */
    }

    public Cat(String name) { /* "It'll have a single constructor, that takes a String, calls the parent class' constructor to set the name." */
        super("Cat",Main.rNG);
    }

}
