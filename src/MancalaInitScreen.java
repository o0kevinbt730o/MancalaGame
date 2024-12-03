import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
/**
 * @author Kevin Chau, Benny Chen
 * @version 1.0
 * MancalaInitScreen is a JFrame that initializes the game mode screen for the Mancala game.
 * It allows the user to input the number of stones in each pit and choose between two styles.
 * The user can also start the game from this screen.
 */
public class MancalaInitScreen extends JFrame implements ActionListener{
	private JTextField pitInput;
	private JButton style1, style2, toNextFrame;

	/**
	 * Initializes the Mancala game mode selection screen.
	 *
	 * @param model The MancalaModel instance used to manage the game state.
	 *
	 * This constructor sets up the initial screen for selecting the game mode.
	 * It includes the following components:
	 * - A title label "Mancala".
	 * - An input field for the number of stones in each pit.
	 * - Two buttons for selecting different styles ("Style 1" and "Style 2").
	 * - A button to start the game ("Start Game").
	 *
	 * The window is set to a fixed size of 500x500 pixels, centered on the screen,
	 * and is not resizable. The layout is set to null for absolute positioning of components.
	 */
	public MancalaInitScreen(MancalaModel model) {
		this.setTitle("Game Mode");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		//Add title
		JLabel title = new JLabel("Mancala");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setBounds(10, 5, 200, 50);
		this.add(title);
		
		//Add input text for number of stones in each pit
		JLabel pitText = new JLabel("Number of Stones:");
		pitText.setBounds(10, 80, 200, 100);
		this.add(pitText);
		
		pitInput = new JTextField();
		this.add(pitInput);
		pitInput.setBounds(130, 115, 100, 30);
		
		style1 = new JButton("Style 1");
		style1.setBounds(20, 240, 200, 85);
		this.getContentPane().add(style1);
		
		style2 = new JButton("Style 2");
		style2.setBounds(265, 240, 200, 85);
		this.getContentPane().add(style2);
		
		toNextFrame = new JButton("Start Game");
		toNextFrame.setBounds(370, 350, 100, 100);
		this.getContentPane().add(toNextFrame);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
	}

	/**
	 * Retrieves the input from the pit input field.
	 *
	 * @return the JTextField containing the pit input.
	 */
	public JTextField getPitInput() {
		return pitInput;
	}

	/**
	 * Returns the JButton representing style 1.
	 *
	 * @return the JButton for style 1
	 */
	public JButton getStyle1() {
		return style1;
	}

	/**
	 * Returns the JButton representing the second style option.
	 *
	 * @return the JButton for style2
	 */
	public JButton getStyle2() {
		return style2;
	}

	/**
	 * Returns the JButton that navigates to the next frame.
	 *
	 * @return the JButton that triggers the transition to the next frame
	 */
	public JButton getToNextFrame() {
		return toNextFrame;
	}

	/**
	 * Handles action events triggered by user interactions.
	 * 
	 * @param e the ActionEvent object containing details about the event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("gameStart"))
			this.setVisible(false);
		if(cmd.equals("playAgain"))
			this.setVisible(true);
	}
}