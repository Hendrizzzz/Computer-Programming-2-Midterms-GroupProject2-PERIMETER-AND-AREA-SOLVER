package mexer2.prog2.edu.slu;

/**
 * Represents a generic geometric shape.
 * This is an abstract class that provides basic functionalities for shapes.
 * @author Martin, Michael
 */
public abstract class Shape {

    /**
     * The name of the shape.
     */
    private final String name;

    /**
     * The number of sides of the shape.
     */
    protected int sides;

    /**
     * Constructs a shape with a given name.
     *
     * @param name the name of the shape
     */
    public Shape(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the shape.
     *
     * @return a string containing the name of the shape and the number of sides
     */
    public String toString() {
        return name + " with " + sides + " sides";
    }

    /**
     * Gets the number of sides of the shape.
     *
     * @return the number of sides

     */
    public int getSides() {
        return sides;
    }

    /**
     * Calculates the area of the shape.
     * This method must be implemented by subclasses.
     *
     * @return the area of the shape
     */
    public abstract double area();

    /**
     * Calculates the perimeter of the shape.
     * This method must be implemented by subclasses.
     *
     * @return the perimeter of the shape
     */
    public abstract double perimeter();
}
