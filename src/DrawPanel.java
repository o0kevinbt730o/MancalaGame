import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private int boardTopLeftX = 50;
	private int boardTopLeftY = 50;
	private int boardWidth = 1025;
	private int boardHeight = 350;
	private Graphics2D g2;
	private ArrayList<PrintPitWithStones> allPits = new ArrayList<>();
	private ArrayList<PrintMancalaWithStones> allMancala = new ArrayList<>();
	private Color pitOutlineColor;
	private Color stoneColor;
	private Color backgroundColor;
	private PrintPitWithStones b6;
	private PrintPitWithStones b5;
	private PrintPitWithStones b4;
	private PrintPitWithStones b3;
	private PrintPitWithStones b2;
	private PrintPitWithStones b1;
	private PrintPitWithStones a1;
	private PrintPitWithStones a2;
	private PrintPitWithStones a3;
	private PrintPitWithStones a4;
	private PrintPitWithStones a5;
	private PrintPitWithStones a6;

	private PrintMancalaWithStones mancalaB;
	private PrintMancalaWithStones mancalaA;
	
	private boolean isThree;

	public DrawPanel(Color pitOutlineColor, Color stoneColor, Color backgroundColor) {
		this.pitOutlineColor = pitOutlineColor;
		this.stoneColor = stoneColor;
		this.backgroundColor = backgroundColor;
		isThree = false;

		b6 = new PrintPitWithStones(200, 75, 100, pitOutlineColor, stoneColor, backgroundColor);
		b5 = new PrintPitWithStones(325, 75, 100, pitOutlineColor, stoneColor, backgroundColor);
		b4 = new PrintPitWithStones(450, 75, 100, pitOutlineColor, stoneColor, backgroundColor);
		b3 = new PrintPitWithStones(575, 75, 100, pitOutlineColor, stoneColor, backgroundColor);
		b2 = new PrintPitWithStones(700, 75, 100, pitOutlineColor, stoneColor, backgroundColor);
		b1 = new PrintPitWithStones(825, 75, 100, pitOutlineColor, stoneColor, backgroundColor);

		a1 = new PrintPitWithStones(200, 275, 100, pitOutlineColor, stoneColor, backgroundColor);
		a2 = new PrintPitWithStones(325, 275, 100, pitOutlineColor, stoneColor, backgroundColor);
		a3 = new PrintPitWithStones(450, 275, 100, pitOutlineColor, stoneColor, backgroundColor);
		a4 = new PrintPitWithStones(575, 275, 100, pitOutlineColor, stoneColor, backgroundColor);
		a5 = new PrintPitWithStones(700, 275, 100, pitOutlineColor, stoneColor, backgroundColor);
		a6 = new PrintPitWithStones(825, 275, 100, pitOutlineColor, stoneColor, backgroundColor);

		mancalaB = new PrintMancalaWithStones(75, 75, 100, 300, pitOutlineColor, stoneColor, backgroundColor);
		mancalaA = new PrintMancalaWithStones(955, 75, 100, 300, pitOutlineColor, stoneColor, backgroundColor);
	}
	
	public void setIsThree(boolean b) {
		isThree = b;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(backgroundColor);

		g2 = (Graphics2D) g;
		Rectangle2D.Double board = new Rectangle2D.Double(boardTopLeftX, boardTopLeftY, boardWidth, boardHeight); // (50,50,900,350)

		g2.draw(board);

		b6.draw(g2);
		b5.draw(g2);
		b4.draw(g2);
		b3.draw(g2);
		b2.draw(g2);
		b1.draw(g2);
		a1.draw(g2);
		a2.draw(g2);
		a3.draw(g2);
		a4.draw(g2);
		a5.draw(g2);
		a6.draw(g2);

		mancalaB.draw(g2);
		mancalaA.draw(g2);
		
		System.out.println("reached remove pit stones for three");

		allPits.add(b6);
		allPits.add(b5);
		allPits.add(b4);
		allPits.add(b3);
		allPits.add(b2);
		allPits.add(b1);

		allPits.add(a1);
		allPits.add(a2);
		allPits.add(a3);
		allPits.add(a4);
		allPits.add(a5);
		allPits.add(a6);

		allMancala.add(mancalaA);
		allMancala.add(mancalaB);

		repaint();
		
		if(isThree) {
			for (PrintPitWithStones p : allPits) {
				// pits
				// System.out.println("yurr");
	//			p.removeStone4();
				p.removeStone4();
//				p.setStone4Null();
			}
	
			for (PrintMancalaWithStones m : allMancala) {
				m.removeMancalaStonesForThree();
				// System.out.println("yur");
			}
	
			repaint();
		}

		// TESTING ZONE
//		b2.removeStone4(); //makes a stone in b2 disappear

//		removeStonesForThree();

	} // end of paintComponent()

	// change each pit from 4 stones to 3 stones

} // end of DrawPanel
