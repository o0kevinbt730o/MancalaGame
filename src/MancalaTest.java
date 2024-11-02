import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MancalaTest{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing");
        JPanel panel = new JPanel();
        frame.add(panel);

        Shape ellipse = new Ellipse2D.Double(0, 0, 100, 200);
        
        JButton hello = new JButton();
        hello.setText("Hello World");
        frame.add(hello);


        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}