import javax.swing.*;
import java.awt.*;

public class TextFieldExample extends JFrame {

    public TextFieldExample() {
        setTitle("Text Field Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField(10);
        JLabel leftLabel = new JLabel("r");
        JLabel rightLabel = new JLabel(" cm");
        panel.add(leftLabel, BorderLayout.WEST);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(rightLabel, BorderLayout.EAST);

        add(panel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextFieldExample::new);
    }
}
