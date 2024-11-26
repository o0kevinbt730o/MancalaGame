import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class MancalaTest {
    public static void main(String[] args) {
        showFrame();
    }
    public static void showFrame() {
    	JFrame initFrame = new JFrame("Initial Screen");
    	initFrame.setSize(500, 500);
    	
    	//11-25-2024 I moved these lines of code to the bottom, because i noticed that when
    	//i ran the Java program, the buttons were not showing up.
//	 	initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	initFrame.getContentPane().setLayout(null);
//    	initFrame.setVisible(true);
  
    	
    	//Add title
    	JLabel title = new JLabel("Mancala");
    	title.setFont(new Font("Arial", Font.BOLD, 20));
    	title.setBounds(10, 5, 200, 50);
    	initFrame.add(title);
    	
    	//Add input text for number of stones in each pit
    	JLabel pitText = new JLabel("Number of Stones:");
    	pitText.setBounds(10, 80, 200, 100);
    	initFrame.add(pitText);
    	
    	JTextField pitInput = new JTextField();
    	initFrame.add(pitInput);
    	pitInput.setBounds(130, 115, 100, 30);
    	
    	
		AtomicInteger numStonesInPit = new AtomicInteger(0);
		
//    	pitInput.addActionListener(new ActionListener() {
//    		
//    		@Override
//    		public void actionPerformed(ActionEvent e) {
//    			//Triggers some method to start the board with x stones in each pit
//				numStonesInPit.set(Integer.parseInt(pitInput.getText()));
//    		}
//    	});
    	
    	//Add 2 style buttons
    	JButton style1 = new JButton("Style 1");
    	style1.setBounds(20, 240, 200, 85);
    	initFrame.getContentPane().add(style1);
    	
    	style1.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			//Triggers some method to use style 1
    		}
    	});
    	
    	JButton style2 = new JButton("Style 2");
    	style2.setBounds(265, 240, 200, 85);
    	initFrame.getContentPane().add(style2);
    	
    	style2.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			//Triggers some method to use style 2
    		}
    	});
    	
		JButton toNextFrame = new JButton("Start Game");
    	toNextFrame.setBounds(370, 350, 100, 100);
    	initFrame.getContentPane().add(toNextFrame);
    	toNextFrame.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			initFrame.setVisible(false);
    			
    			JFrame mancalaFrame = new JFrame("Mancala");

				DrawPanel mancalaBoard = new DrawPanel(Color.orange, Color.cyan, Color.lightGray);
//				mancalaBoard.repaint();
				
				numStonesInPit.set(Integer.parseInt(pitInput.getText()));

				if (numStonesInPit.intValue() == 3) {
					//Remove pits to fit board
//					mancalaBoard.repaint();
					mancalaBoard.setIsThree(true);
					
					System.out.println(97);

				}
				
    			mancalaFrame.add(mancalaBoard);
				
    			
    			mancalaFrame.setSize(1200, 500);
    			mancalaFrame.setVisible(true);
    			mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			

    		}
    	});
    	
    	//11-25-2024 I moved these lines of code to the bottom, because i noticed that when
    	//i ran the Java program, the buttons were not showing up.
	 	initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	initFrame.getContentPane().setLayout(null);
    	initFrame.setVisible(true);
    }
}