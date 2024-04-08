package mexer2.prog2.edu.slu;

/**
 * A reference class for creating a circle.
 * Inherits values and attributes from the Shape class.
 *
 * @documentation Oliver Yu
 * @author
 */
public class Circle extends Shape {

    /**
     * Radius of the circle.
     * The radius is the distance from the center of the circle to any point of its circumference.
     */
    private final double radius;

    /**
     * Parameterized constructor of a circle, containing a name and a radius.
     *
     * @param name of the shape
     * @param radius of the circle
     */
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    /**
     * Computes the area of the circle by using the formula π(r^2)
     * where r is the radius of the circle.
     *
     * @return area of the circle
     */
    @Override
    public double area() {
        double area = Math.PI * Math.pow(radius,2);
        String areaString = String.format("%.5f", area);
        return Double.parseDouble(areaString);
    }

    /**
     * Computes the perimeter of the circle by using the formula 2πr
     * where r is the radius of the circle.
     *
     * @return perimeter of the circle
     */
    @Override
    public double perimeter() {
        double perimeter = Math.PI * (2 * radius);
        String perimeterString = String.format("%.5f", perimeter);
        return Double.parseDouble(perimeterString);
    }
}
