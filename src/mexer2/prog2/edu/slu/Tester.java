package mexer2.prog2.edu.slu;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


/**
 * Tester class represents the main JFrame for the Perimeter and Area Calculator application.
 * It contains panels for title, options, dashboard, and buttons, along with various components
 * for user interaction and display.
 * @author: Bag-eo, Jim Hendrix
 */
public class Tester extends JFrame {
    private JPanel titlePanel;
    private JPanel optionsPanel;
    private JPanel dashboardPanel;
    private JPanel buttonPanel;

    private JComboBox<String> areaOrPerimeter;
    private JComboBox<String> polygonMenu;

    private JLabel formula;
    private JLabel squareAreaOrPerimeterLabel, rectangleAreaOrPerimeterLabel, triangleAreaOrPerimeterLabel, circleAreaOrPerimeterLabel;
    private JLabel squareUnitsLabel, rectangleUnitsLabel, triangleUnitsLabel, circleUnitsLabel;

    private JTextField side, length, width, radius, side2, side3, side4;
    private JTextField squareAnswerJTextfield, rectangleAnswerJTextfield, circleAnswerJTextfield, triangleAnswerJTextfield;

    private JButton calculate;
    private JButton clear;
    private JButton exit;

    private CardLayout figureCardLayout, answerCardLayout;
    private JPanel figureCardPanel, answerCardPanel;


    private static final Font font = new Font("Comic Sans MS", Font.BOLD, 30);
    private static final Font font1 = new Font("Verdana", Font.BOLD, 20);



    /**
     * Constructs a Tester object.
     * Initializes the JFrame and sets up its components.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    public Tester(){
        setTitle("Bag-eoMalasanMartinPajaraSambotYu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitlePanel();
        setOptionsPanel();
        setDashboardPanel();
        setButtonPanel();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(titlePanel);
        add(optionsPanel);
        add(dashboardPanel);
        add(buttonPanel);

        setSize(new Dimension(800, 600));
        setVisible(true);

        setEnabled(true);
    }


    /**
     * Sets up the title panel with the application title and description.
     * @author: Bag-eo, Jim Hendrix
     */
    private void setTitlePanel() {
        // Create and configure the title label
        JLabel titleLabel = new JLabel("Perimeter and Area Calculator");
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 30));

        // Create and configure the description label
        JLabel descriptionLabel = new JLabel("The app efficiently calculates the perimeter and area " +
                                            "of squares, triangles, rectangles, and circles.");
        descriptionLabel.setVerticalAlignment(JLabel.TOP);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Create the title panel with a grid layout
        titlePanel = new JPanel(new GridLayout(2,1));
        titlePanel.add(titleLabel);
        titlePanel.add(descriptionLabel);
    }

    /**
     * Sets up the options panel with dropdown menus for selecting the calculation type (area or perimeter)
     * and the geometric shape (square, rectangle, triangle, or circle).
     * @author: Bag-eo, Jim Hendrix
     */
    private void setOptionsPanel() {
        // Create 2 dropdown menus for selecting a calculation type and geometric shape
        String[] options = {"Area", "Perimeter"};
        String[] options2 = {"Square", "Rectangle", "Triangle", "Circle"};
        areaOrPerimeter = new JComboBox<>(options);
        polygonMenu = new JComboBox<>(options2);

        // Action listener for dropdown menus
        ActionHandler polygonDropHandler = new ActionHandler();
        areaOrPerimeter.addActionListener(polygonDropHandler);
        polygonMenu.addActionListener(polygonDropHandler);

        // Set preferred size and font for dropdown menus
        areaOrPerimeter.setPreferredSize(new Dimension(150, 40));
        areaOrPerimeter.setFont(font1);
        polygonMenu.setPreferredSize(new Dimension(150, 40));
        polygonMenu.setFont(font1);

        // Add dropdown menus to the options panel
        optionsPanel = new JPanel();
        optionsPanel.add(areaOrPerimeter);
        optionsPanel.add(polygonMenu);
    }



        /**
     * Sets up the dashboard panel with graphical representations of geometric shapes
     * and input fields for user input and displaying calculation results.
     * @author: Bag-eo, Jim Hendrix
     *
     * <p>This DashboardPanel consists of two panels, each utilizing a CardLayout: one with four
     * panels containing shape images, and the other with two panels displaying input and calculation results.</p>
     *
     */
    private void setDashboardPanel() {
        // The first panel
        JPanel panel1 = new JPanel(new BorderLayout());

        // method for setting up the first panel
        setUpFirstPanelOfDashBoard(panel1);

        // the second panel
        JPanel panel2 = new JPanel();

        // method for setting up the second panel
        setUpSecondPanelOfDashBoard(panel2);

        // the 2 panels being added to the dashboard
        dashboardPanel = new JPanel(new GridBagLayout());
        dashboardPanel.add(panel1);
        dashboardPanel.add(panel2);
    }


    /**
     * Sets up the first panel of the dashboard with a CardLayout containing shape images.
     * @param panel1 The panel to set up.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setUpFirstPanelOfDashBoard(JPanel panel1) {
        // the first panel's CardLayout which contains images
        figureCardPanel = new JPanel();
        figureCardLayout = new CardLayout();
        figureCardPanel.setLayout(figureCardLayout);

        // panel container for the images
        JPanel squarePanel = new JPanel();
        JPanel rectanglePanel = new JPanel();
        JPanel circlePanel = new JPanel();
        JPanel trianglePanel = new JPanel();

        // the images being placed on a JLabel because it cannot be added in a panel if they're on an ImageIcon
        ImageIcon square = new ImageIcon("pic-square.png");
        JLabel squareLabel = new JLabel(square); // Create a JLabel to hold the ImageIcon
        ImageIcon rectangle = new ImageIcon("pic-rectangle.png");
        JLabel rectangleLabel = new JLabel(rectangle); // Create a JLabel to hold the ImageIcon
        ImageIcon circle = new ImageIcon("pic-circle.png");
        JLabel circleLabel = new JLabel(circle); // Create a JLabel to hold the ImageIcon
        ImageIcon triangle = new ImageIcon("pic-triangle.png");
        JLabel triangleLabel = new JLabel(triangle); // Create a JLabel to hold the ImageIcon

        // The images being added on their panels
        squarePanel.add(squareLabel);
        rectanglePanel.add(rectangleLabel);
        circlePanel.add(circleLabel);
        trianglePanel.add(triangleLabel);

        // the 4 panels being added to the CardLayout
        figureCardPanel.add(squarePanel, "square");
        figureCardPanel.add(rectanglePanel, "rectangle");
        figureCardPanel.add(circlePanel, "circle");
        figureCardPanel.add(trianglePanel, "triangle");

        formula = new JLabel("Area : a²");
        formula.setHorizontalAlignment(SwingConstants.CENTER);
        formula.setFont(font);

        // The CardLayout being added to the panel1
        panel1.add(figureCardPanel, BorderLayout.PAGE_START);

        // Add formula to panel1 at the bottom
        panel1.add(formula, BorderLayout.PAGE_END);
    }


    /**
     * Sets up the second panel of the dashboard with a CardLayout containing calculation results.
     * @param panel2 The panel to set up.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setUpSecondPanelOfDashBoard(JPanel panel2) {
        // Create CardLayout panel for calculation results
        answerCardPanel = new JPanel();
        answerCardLayout = new CardLayout();
        answerCardPanel.setLayout(answerCardLayout);

        // Panels for each shape's input and answer
        JPanel squareAnswer = new JPanel(new GridLayout(0,1));
        setSquare(squareAnswer);
        JPanel rectangleAnswer = new JPanel(new GridLayout(0,1));
        setRectangle(rectangleAnswer);
        JPanel circleAnswer = new JPanel(new GridLayout(0,1));
        setCircleAnswer(circleAnswer);
        JPanel triangleAnswer = new JPanel(new GridLayout(0,1));
        setTriangleAnswer(triangleAnswer);

        // Add panels to CardLayout
        answerCardPanel.add(squareAnswer, "squareAnswer");
        answerCardPanel.add(rectangleAnswer, "rectangleAnswer");
        answerCardPanel.add(circleAnswer, "circleAnswer");
        answerCardPanel.add(triangleAnswer, "triangleAnswer");

        // Add answer CardLayout panel to the second panel of the Dashboard
        panel2.add(answerCardPanel);
    }



    /**
     * Sets up the input fields and labels for calculating the area and perimeter of a square.
     *
     * @param squareAnswer The panel where the input fields and labels are added.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setSquare(JPanel squareAnswer) {
        // Input panel for side length
        JPanel panel = new JPanel(new BorderLayout());
        side = new JTextField();
        setDigitsAndDotFilter(side);
        side.setHorizontalAlignment(JTextField.CENTER);
        side.setPreferredSize(new Dimension(200, 50)); // Set the preferred size for the side text field
        JLabel leftLabel = new JLabel("a   ");
        JLabel rightLabel = new JLabel(" units");
        panel.add(leftLabel, BorderLayout.WEST);
        panel.add(side, BorderLayout.CENTER);
        panel.add(rightLabel, BorderLayout.EAST);

        // Result panel for square area
        JPanel panel1 = new JPanel(new BorderLayout());
        squareAnswerJTextfield = new JTextField();
        squareAnswerJTextfield.setPreferredSize(side.getPreferredSize()); // Set the preferred size for the squareAnswerJTextfield text field to match the side text field
        squareAnswerJTextfield.setHorizontalAlignment(JTextField.CENTER);
        squareAnswerJTextfield.setEnabled(false);
        squareAnswerJTextfield.setDisabledTextColor(Color.BLACK);
        squareAreaOrPerimeterLabel = new JLabel("Area : ");
        squareUnitsLabel = new JLabel(" units²");
        panel1.add(squareAreaOrPerimeterLabel, BorderLayout.WEST);
        panel1.add(squareAnswerJTextfield, BorderLayout.CENTER);
        panel1.add(squareUnitsLabel, BorderLayout.EAST);

        // Adding panels to the squareAnswer panel
        squareAnswer.add(new JLabel());
        squareAnswer.add(panel);
        squareAnswer.add(new JLabel());
        squareAnswer.add(panel1);
    }



    /**
     * Sets up the input fields and labels for calculating the area and perimeter of a rectangle.
     *
     * @param rectangleAnswer The panel where the input fields and labels are added.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setRectangle(JPanel rectangleAnswer) {
        // Input panel for length
        JPanel panel = new JPanel(new BorderLayout());
        length = new JTextField();
        setDigitsAndDotFilter(length);
        length.setHorizontalAlignment(JTextField.CENTER);
        length.setPreferredSize(new Dimension(200, 50)); // Set the preferred size for the length text field
        JLabel leftLabel = new JLabel("a   ");
        JLabel rightLabel = new JLabel(" units");
        panel.add(leftLabel, BorderLayout.WEST);
        panel.add(length, BorderLayout.CENTER);
        panel.add(rightLabel, BorderLayout.EAST);

        // Input panel for width
        JPanel panel1 = new JPanel(new BorderLayout());
        width = new JTextField();
        setDigitsAndDotFilter(width);
        width.setHorizontalAlignment(JTextField.CENTER);
        width.setPreferredSize(length.getPreferredSize()); // Set the preferred size for the length text field
        JLabel leftLabel1 = new JLabel("b   ");
        JLabel rightLabel1 = new JLabel(" units");
        panel1.add(leftLabel1, BorderLayout.WEST);
        panel1.add(width, BorderLayout.CENTER);
        panel1.add(rightLabel1, BorderLayout.EAST);

        // Result panel for rectangle area
        JPanel panel2 = new JPanel(new BorderLayout());
        rectangleAnswerJTextfield = new JTextField();
        rectangleAnswerJTextfield.setPreferredSize(length.getPreferredSize()); // Set the preferred size for the rectangleAnswerJTextfield text field to match the length text field
        rectangleAnswerJTextfield.setHorizontalAlignment(JTextField.CENTER);
        rectangleAnswerJTextfield.setEnabled(false);
        rectangleAnswerJTextfield.setDisabledTextColor(Color.BLACK);
        rectangleAreaOrPerimeterLabel = new JLabel("Area : ");
        rectangleUnitsLabel = new JLabel(" units²");
        panel2.add(rectangleAreaOrPerimeterLabel, BorderLayout.WEST);
        panel2.add(rectangleAnswerJTextfield, BorderLayout.CENTER);
        panel2.add(rectangleUnitsLabel, BorderLayout.EAST);

        // Adding panels to the rectangleAnswer panel
        rectangleAnswer.add(panel);
        rectangleAnswer.add(panel1);
        rectangleAnswer.add(new JLabel());
        rectangleAnswer.add(panel2);
        
    }


    /**
     * Sets up the input fields and labels for calculating the area and perimeter of a circle.
     *
     * @param circleAnswer The panel where the input fields and labels are added.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setCircleAnswer(JPanel circleAnswer) {
        // Input panel for radius
        JPanel panel = new JPanel(new BorderLayout());
        radius = new JTextField();
        setDigitsAndDotFilter(radius);
        radius.setHorizontalAlignment(JTextField.CENTER);
        radius.setPreferredSize(new Dimension(200, 50)); // Set the preferred size for the radius text field
        JLabel leftLabel = new JLabel("r   ");
        JLabel rightLabel = new JLabel(" units");
        panel.add(leftLabel, BorderLayout.WEST);
        panel.add(radius, BorderLayout.CENTER);
        panel.add(rightLabel, BorderLayout.EAST);

        // Result panel for circle area
        JPanel panel1 = new JPanel(new BorderLayout());
        circleAnswerJTextfield = new JTextField();
        circleAnswerJTextfield.setPreferredSize(radius.getPreferredSize()); // Set the preferred size for the circleAnswerJTextfield text field to match the radius text field
        circleAnswerJTextfield.setHorizontalAlignment(JTextField.CENTER);
        circleAnswerJTextfield.setEnabled(false);
        circleAnswerJTextfield.setDisabledTextColor(Color.black);
        circleAreaOrPerimeterLabel = new JLabel("Area : ");
        circleUnitsLabel = new JLabel(" units²");
        panel1.add(circleAreaOrPerimeterLabel, BorderLayout.WEST);
        panel1.add(circleAnswerJTextfield, BorderLayout.CENTER);
        panel1.add(circleUnitsLabel, BorderLayout.EAST);

        // Adding panels to the circleAnswer panel
        circleAnswer.add(new JLabel());
        circleAnswer.add(panel);
        circleAnswer.add(new JLabel());
        circleAnswer.add(panel1);
    }



    /**
     * Sets up the input fields and labels for calculating the area and perimeter of a triangle.
     *
     * @param triangleAnswer The panel where the input fields and labels are added.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setTriangleAnswer(JPanel triangleAnswer) {
        // Input panel for side length 1
        JPanel panel = new JPanel(new BorderLayout());
        side2 = new JTextField();
        setDigitsAndDotFilter(side2);
        side2.setHorizontalAlignment(JTextField.CENTER);
        side2.setPreferredSize(new Dimension(200, 50)); // Set the preferred size for the side2 text field
        JLabel leftLabel = new JLabel("a   ");
        JLabel rightLabel = new JLabel(" units");
        panel.add(leftLabel, BorderLayout.WEST);
        panel.add(side2, BorderLayout.CENTER);
        panel.add(rightLabel, BorderLayout.EAST);

        // Input panel for side length 2
        JPanel panel1 = new JPanel(new BorderLayout());
        side3 = new JTextField();
        setDigitsAndDotFilter(side3);
        side3.setHorizontalAlignment(JTextField.CENTER);
        side3.setPreferredSize(side2.getPreferredSize()); // Set the preferred size for the side2 text field
        JLabel leftLabel1 = new JLabel("b   ");
        JLabel rightLabel1 = new JLabel(" units");
        panel1.add(leftLabel1, BorderLayout.WEST);
        panel1.add(side3, BorderLayout.CENTER);
        panel1.add(rightLabel1, BorderLayout.EAST);

        // Input panel for side length3
        JPanel panel2 = new JPanel(new BorderLayout());
        side4 = new JTextField();
        setDigitsAndDotFilter(side4);
        side4.setHorizontalAlignment(JTextField.CENTER);
        side4.setPreferredSize(side2.getPreferredSize()); // Set the preferred size for the side2 text field
        JLabel leftLabel2 = new JLabel("c   ");
        JLabel rightLabel2 = new JLabel(" units");
        panel2.add(leftLabel2, BorderLayout.WEST);
        panel2.add(side4, BorderLayout.CENTER);
        panel2.add(rightLabel2, BorderLayout.EAST);

        // Result panel for triangle area
        JPanel panel3 = new JPanel(new BorderLayout());
        triangleAnswerJTextfield = new JTextField();
        triangleAnswerJTextfield.setPreferredSize(side2.getPreferredSize()); // Set the preferred size for the triangleAnswerJTextfield text field to match the side text field
        triangleAnswerJTextfield.setHorizontalAlignment(JTextField.CENTER);
        triangleAnswerJTextfield.setEnabled(false);
        triangleAnswerJTextfield.setDisabledTextColor(Color.black);
        triangleAreaOrPerimeterLabel = new JLabel("Area : ");
        triangleUnitsLabel = new JLabel(" units²");
        panel3.add(triangleAreaOrPerimeterLabel, BorderLayout.WEST);
        panel3.add(triangleAnswerJTextfield, BorderLayout.CENTER);
        panel3.add(triangleUnitsLabel, BorderLayout.EAST);

        // Adding panels to the triangleAnswer panel
        triangleAnswer.add(panel);
        triangleAnswer.add(panel1);
        triangleAnswer.add(panel2);
        triangleAnswer.add(new JLabel());
        triangleAnswer.add(panel3);
    }


    /**
     * Sets up the panel containing buttons for calculation and control.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setButtonPanel() {
        calculate = new JButton("Calculate");
        clear = new JButton("Clear");
        exit = new JButton("Exit");
        
        ActionHandler actionHandler = new ActionHandler();
        calculate.addActionListener(actionHandler);
        clear.addActionListener(actionHandler);
        exit.addActionListener(actionHandler);

        buttonPanel = new JPanel();
        buttonPanel.add(calculate);
        buttonPanel.add(clear);
        buttonPanel.add(exit);
    }


    /**
     * Attaches a document filter to a text field to accept only digits and a dot.
     *
     * @param textField The text field to attach the filter to.
     *
     * @author: Bag-eo, Jim Hendrix
     */
    private void setDigitsAndDotFilter(JTextField textField) {
        AbstractDocument doc = (AbstractDocument) textField.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newText.matches("^-?\\d*\\.?\\d*$")) { // Only allow digits and a dot
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }


    // the main method, launcher of the GUI program
    public static void main(String[] args) {
        new Tester();
    }









    /**
     * Private class that handles actions for the GUI components
     * (dropdowns for showing the right panel in the CardLayout and Buttons).
     * Implements the ActionListener interface.
     * <p>designed by: Bag-eo, Jim Hendrix</p>
     */
    private class ActionHandler implements ActionListener{

        /**
         * Invoked when an action occurs.
         * @param e The ActionEvent object representing the action.
         * @author: Bag-eo, Jim Hendrix
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonChoice = e.getSource(); // Get the source of the action (button clicked)
            String selectedPolygon = (String) polygonMenu.getSelectedItem(); // Get the selected polygon from the dropdown menu
            boolean isArea = (areaOrPerimeter.getSelectedItem()).equals("Area"); // determine whether if the selected choice in the dropdown is area or perimeter, if area then true, false otherwise.

            // show the right card panels according to the selected in the dropdowns
            switch (Objects.requireNonNull(selectedPolygon)){
                case "Triangle" -> {
                    showTriangle(isArea);
                }
                case "Circle" -> {
                    showCircle(isArea);
                }
                case "Square" -> {
                    showSquare(isArea);
                }
                case "Rectangle" -> {
                    showRectangle(isArea);
                }
            }

            // Button handlers
            if (buttonChoice != clear || buttonChoice != exit || buttonChoice != calculate){
                if (buttonChoice == clear){
                    clearTextFields();
                }
                else if (buttonChoice == exit){
                    System.exit(0);
                }
                else if (buttonChoice == calculate){
                    performCalculation(selectedPolygon, isArea);
                }
            }

        } // end of method -> actionPerformed



        /**
         * Display the panel for the Triangle perimeter and area calculation.
         * If isArea is true, displays the card panel for area calculation of the Triangle. Otherwise, displays card panel for perimeter calculation of the Triangle.
         *
         * @param isArea indicates whether it should display area GUI or perimeter GUI.
         *
         * @author Edison Malasan
         */
        private void showTriangle(boolean isArea) {
            figureCardLayout.show(figureCardPanel, "triangle"); // display the figureCardPanel
            answerCardLayout.show(answerCardPanel, "triangleAnswer"); // display the answerCardPanel

            // Statement that checks if area should be display
            if (isArea){
                formula.setText("");
                triangleAreaOrPerimeterLabel.setText("Area : ");
                triangleAnswerJTextfield.setText(""); 
                triangleUnitsLabel.setText("units²");
            } else { //Display perimeter card panel
                formula.setText("Perimeter : a + b + c");
                triangleAreaOrPerimeterLabel.setText("Perimeter : ");
                triangleUnitsLabel.setText("units");
                triangleAnswerJTextfield.setText("");
            }
        } // end of method -> showTriangle

        /**
         * Displays the card panel for the circle perimeter and area calculation.
         * If the isArea boolean is true, the panel will display the GUI for the calculation of the area of the circle.
         * Otherwise, the panel will display the GUI for the calculation of the perimeter of the circle.
         *
         * @documentation Oliver Yu
         *
         * @param isArea is true if the selected option in the dropdown is Area. False if perimeter is selected.
         */
        private void showCircle(boolean isArea) {
            figureCardLayout.show(figureCardPanel, "circle"); //displays the figureCardPanel, which is located on the left side of the user interface.
            answerCardLayout.show(answerCardPanel, "circleAnswer"); //displays the answerCardPanel, which is located on the right side of the user interface.

            //if-else statement to identify which texts will be displayed.
            if (isArea){
                formula.setText("Area : πr²");
                circleAreaOrPerimeterLabel.setText("Area : ");
                circleUnitsLabel.setText("units²");
                circleAnswerJTextfield.setText("");
            } else {
                formula.setText("Perimeter : 2πr");
                circleAreaOrPerimeterLabel.setText("Perimeter : ");
                circleUnitsLabel.setText("units");
                circleAnswerJTextfield.setText("");
            }
        } // end of method -> showCircle


        /**
         * Displays the square panel and corresponding answer panel while updating the displayed formula and labels based on the specified parameter.
         *
         * @param isArea A boolean value indicating whether to display information related to the area or perimeter of the square.
         *               If {@code true}, information related to the area will be displayed; otherwise, information related to the perimeter will be displayed.
         * @author: Sambot, Kyle Archilles
         */

        private void showSquare(boolean isArea) {
            figureCardLayout.show(figureCardPanel, "square");
            answerCardLayout.show(answerCardPanel, "squareAnswer");
            if (isArea){
                formula.setText("Area : a²");
                squareAreaOrPerimeterLabel.setText("Area : ");
                squareUnitsLabel.setText("units²");
                squareAnswerJTextfield.setText("");
            } else {
                formula.setText("Perimeter : 4a");
                squareAreaOrPerimeterLabel.setText("Perimeter : ");
                squareUnitsLabel.setText("units");
                squareAnswerJTextfield.setText("");
            }
        } // end of method -> showSquare



        
        private void showRectangle(boolean isArea) {
            figureCardLayout.show(figureCardPanel, "rectangle");
            answerCardLayout.show(answerCardPanel, "rectangleAnswer");
            if (isArea) {
                formula.setText("Area : a * b");
                rectangleAreaOrPerimeterLabel.setText("Area : ");
                rectangleUnitsLabel.setText("units²");
                rectangleAnswerJTextfield.setText("");
            } else {
                formula.setText("Perimeter : 2a + 2b");
                rectangleAreaOrPerimeterLabel.setText("Perimeter : ");
                rectangleUnitsLabel.setText("units");
                rectangleAnswerJTextfield.setText("");
            }
        } // end of method -> showRectangle



        
        private void clearTextFields() {
            side.setText("");
            length.setText("");
            width.setText("");
            radius.setText("");
            side2.setText("");
            side3.setText("");
            side4.setText("");
            squareAnswerJTextfield.setText("");
            triangleAnswerJTextfield.setText("");
            rectangleAnswerJTextfield.setText("");
            circleAnswerJTextfield.setText("");
        } // end of method -> clearTextFields





        
        private void performCalculation(String selectedPolygon, boolean isArea) {
            switch (selectedPolygon) {
                case "Triangle" -> calculateTriangle(isArea);
                case "Square" -> calculateSquare(isArea);
                case "Circle" -> calculateCircle(isArea);
                case "Rectangle" -> calculateRectangle(isArea);
            }
        } // end of method -> performCalculations




        /**
         * Calculates either the area or perimeter of a Triangle based on the choice of the user in the dropdown.
         * If isArea is true, calculates and displays the area of the triangle. If it's false then it will calculates and displays the perimeter of the triangle
         *
         * @param isArea indicates whether it should calculate the area or the perimeter of the triangle.
         *
         * @author Edison Malasan
         */
        private void calculateTriangle(boolean isArea) {

            //Parse the input side Lengths of the Triangle
            double a = Double.parseDouble(side2.getText());
            double b = Double.parseDouble(side3.getText());
            double c = Double.parseDouble(side4.getText());

            // Create a Triangle object
            Shape shape = new Triangle("triangle", a, b, c);

            if (isArea) {
                triangleAnswerJTextfield.setText(String.valueOf(shape.area()));
            } else {
                triangleAnswerJTextfield.setText(String.valueOf(shape.perimeter()));
            }
        } // end of method -> calculateTriangle





        /**
         * Calculates the area or perimeter of a square based on the provided side length and updates the answer field accordingly.
         *
         * This method retrieves the side length of the square from the text field {@code side}, creates a Square object with the given side length, and calculates either the area or perimeter based on the value of the {@code isArea} parameter. It then updates the text field {@code squareAnswerJTextfield} with the calculated result.
         *
         * @param isArea A boolean value indicating whether to calculate the area or perimeter of the square.
         *               If {@code true}, the area of the square will be calculated; otherwise, the perimeter will be calculated.
         * @author: Sambot, Kyle Archilles
         */
        private void calculateSquare(boolean isArea) {
            // Retrieve the side length of the square from the text field
            double a = Double.parseDouble(side.getText());

            // Create a Square object with the given side length
            Shape shape = new Square("square", a);

            // Calculate either the area or perimeter based on the specified parameter
            if (isArea) {
                // Calculate the area of the square and update the answer field
                squareAnswerJTextfield.setText(String.valueOf(shape.area()));
            } else {
                // Calculate the perimeter of the square and update the answer field
                squareAnswerJTextfield.setText(String.valueOf(shape.perimeter()));
            }
        } // end of method -> calculateSquare

        
        /**
         * Calculates the required field of the circle, depending on the boolean provided.
         * If isArea is true, the area of the circle is calculated.
         * Otherwise, the perimeter of the circle is calculated.
         *
         * @documentation Oliver Yu
         *
         * @param isArea is true if the selected option in the dropdown is Area. False if perimeter is selected.
         */
        private void calculateCircle(boolean isArea) {
            double r = Double.parseDouble(radius.getText()); //value of r is extracted from the radius textField.
            Shape shape = new Circle("circle", r); //instantiation of a new circle object with a parameter of "circle" as the name and r as the radius.

            //if-else statement to identify which calculation will be used.
            if (isArea) {
                circleAnswerJTextfield.setText(String.valueOf(shape.area()));
            } else {
                circleAnswerJTextfield.setText(String.valueOf(shape.perimeter()));
            }
        } // end of method -> calculateCircle





        private void calculateRectangle(boolean isArea) {
            double a = Double.parseDouble(length.getText());
            double b = Double.parseDouble(width.getText());
            Shape shape = new Rectangle("rectangle", a, b);
            if (isArea) {
                rectangleAnswerJTextfield.setText(String.valueOf(shape.area()));
            } else {
                rectangleAnswerJTextfield.setText(String.valueOf(shape.perimeter()));
            }
        } // end of method -> calculateRectangle

    } // end of the inner class -> ActionHandler

} // end of the outer class -> Tester


