package mexer2.prog2.edu.slu;

/**
 * A reference class for creating a rectangle, a quadrilateral with four right angles.
 * It inherits values and attributes from the Square class.
 *
 * @author Paul Pajara
 */
public class Rectangle extends Square {

    /**
     * The length of the second side of the rectangle.
     */
    private final double side2;

    /**
     * Constructs a rectangle object with the specified name, side lengths.
     *
     * @param name  the name of the rectangle
     * @param side1 the length of the first side of the rectangle
     * @param side2 the length of the second side of the rectangle
     */
    public Rectangle(String name, double side1, double side2) {
        super(name, side1);
        this.side2 = side2;
    }

    /**
     * Computes and returns the area of the rectangle.
     * The area of a rectangle is calculated by multiplying the lengths of its two sides.
     *
     * @return the area of the rectangle
     */
    @Override
    public double area() {
        double area = side2 * side;
        String areaString = String.format("%.5f", area);
        return Double.parseDouble(areaString);
    }

    /**
     * Computes and returns the perimeter of the rectangle.
     * The perimeter of a rectangle is calculated by adding the lengths of all its sides.
     *
     * @return the perimeter of the rectangle
     */
    @Override
    public double perimeter() {
        double perimeter = 2*(side2 + side);
        String perimeterString = String.format("%.5f", perimeter);
        return Double.parseDouble(perimeterString);
    }
}
