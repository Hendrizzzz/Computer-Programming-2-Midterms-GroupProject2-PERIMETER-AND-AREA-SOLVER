/**
 * Reference class for Triangle.
 * Inherits the attributes from the Shape class.
 *
 * @author Edison Malasan
 */
package mexer2.prog2.edu.slu;

public class Triangle extends Shape{

    /**
     * Three sides for triangle
     */
    private final double side1;
    private final double side2;
    private final double side3;


    /**
    * Constructor for triangle
    * @param name, side1, side2, side3
    */
    public Triangle(String name, double side1, double side2, double side3) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
    * Calculate the area of the triangle using Heron's formula
    * @return area of the traingle with the datatype double
    */
    @Override
    public double area() {
        double p = (side1 + side2 + side3) / 2; // half the perimeter
        double area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        String areaString = String.format("%.5f", area); // Format the area to 5 decimal places
        return Double.parseDouble(areaString);
    }

    /**
    * Calculate the perimeter of the triangle using the formula (side1 + side2 + side3)
    * @return perimeter of the triangle with the datatype double
    */
    @Override
    public double perimeter() {
        double perimeter = side1 + side2 + side3;
        String perimeterString = String.format("%.5f", perimeter); // Format the perimeter to 5 decimal places
        return Double.parseDouble(perimeterString);
    }
}
