
Below is the Javadoc documentation for the provided Square class:

java
Copy code
package mexer2.prog2.edu.slu;

/**
 * The Square class represents a square shape, extending the Shape class.
 * It calculates the area and perimeter of the square.
 */
public class Square extends Shape {
    /**
     * The length of each side of the square.
     */
    protected double side;

    /**
     * Constructs a Square object with the given name and side length.
     *
     * @param name The name of the square.
     * @param side The length of each side of the square.
     * @throws NumberFormatException If the side length is not a valid number.
     */
    public Square(String name, double side) throws NumberFormatException {
        super(name);
        this.side = side;
    }

    /**
     * Calculates the area of the square.
     *
     * @return The area of the square.
     */
    @Override
    public double area() {
        double area = side * side;
        // Format the area to 5 decimal places
        String areaString = String.format("%.5f", area);
        return Double.parseDouble(areaString);
    }

    /**
     * Calculates the perimeter of the square.
     *
     * @return The perimeter of the square.
     */
    @Override
    public double perimeter() {
        double perimeter = 4 * side;
        // Format the perimeter to 5 decimal places
        String perimeterString = String.format("%.5f", perimeter);
        return Double.parseDouble(perimeterString);
    }
}
