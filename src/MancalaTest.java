import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MancalaTest {
    public static void main(String[] args) {
        /*JFrame frame = new JFrame("Testing");
        // JPanel panel = new JPanel();

        // idk where to put it run it and see if you like
        DrawPanel mancalaBoard = new DrawPanel();
        frame.add(mancalaBoard);

        // EllipseButton hello = new EllipseButton("Hello World");
        // panel.add(hello);

        // frame.add(panel);
        frame.setSize(1200, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);*/
        showFrame();
    }
    public static void showFrame() {
    	JFrame initFrame = new JFrame("Initial Screen");
    	initFrame.setSize(500, 500);
    	initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	initFrame.getContentPane().setLayout(null);
    	initFrame.setVisible(true);
    	
    	JButton toNextFrame = new JButton("Start Game");
    	toNextFrame.setBounds(370, 350, 100, 100);
    	initFrame.getContentPane().add(toNextFrame);
    	
    	//Add title
    	JLabel title = new JLabel("Mancala");
    	title.setFont(new Font("Arial", Font.BOLD, 20));
    	title.setBounds(10, 5, 200, 50);
    	initFrame.add(title);
    	
    	//Add input text for number of stones in each pit
    	//Add 2 buttons for the style
    	
    	toNextFrame.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			initFrame.setVisible(false);
    			
    			JFrame mancalaFrame = new JFrame("Mancala");
    			DrawPanel mancalaBoard = new DrawPanel();
    			mancalaFrame.add(mancalaBoard);
    			
    			mancalaFrame.setSize(1200, 500);
    			mancalaFrame.setVisible(true);
    			mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		}
    	});
    }
}