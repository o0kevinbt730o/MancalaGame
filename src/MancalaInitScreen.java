import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class MancalaInitScreen extends JFrame implements ActionListener{
	private JTextField pitInput;
	private JButton style1, style2, toNextFrame;

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

	public JTextField getPitInput() {
		return pitInput;
	}

	public JButton getStyle1() {
		return style1;
	}

	public JButton getStyle2() {
		return style2;
	}

	public JButton getToNextFrame() {
		return toNextFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("gameStart"))
			this.setVisible(false);
		if(cmd.equals("playAgain"))
			this.setVisible(true);
	}

}