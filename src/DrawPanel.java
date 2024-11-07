import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private int boardTopLeftX = 50;
	private int boardTopLeftY = 50;
	private int boardWidth = 1025;
	private int boardHeight = 350;
	private Graphics2D g2;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		Rectangle2D.Double board = new Rectangle2D.Double(boardTopLeftX, boardTopLeftY, boardWidth, boardHeight); // (50,50,900,350)
		
		g2.draw(board);

		PrintPitWithStones b6 = new PrintPitWithStones(200, 75, 100);
		PrintPitWithStones b5 = new PrintPitWithStones(325, 75, 100);
		PrintPitWithStones b4 = new PrintPitWithStones(450, 75, 100);
		PrintPitWithStones b3 = new PrintPitWithStones(575, 75, 100);
		PrintPitWithStones b2 = new PrintPitWithStones(700, 75, 100);
		PrintPitWithStones b1 = new PrintPitWithStones(825, 75, 100);

		PrintPitWithStones a1 = new PrintPitWithStones(200, 275, 100);
		PrintPitWithStones a2 = new PrintPitWithStones(325, 275, 100);
		PrintPitWithStones a3 = new PrintPitWithStones(450, 275, 100);
		PrintPitWithStones a4 = new PrintPitWithStones(575, 275, 100);
		PrintPitWithStones a5 = new PrintPitWithStones(700, 275, 100);
		PrintPitWithStones a6 = new PrintPitWithStones(825, 275, 100);
		
		
		PrintMancalaWithStones mancalaB = new PrintMancalaWithStones(75, 75, 100, 300);
		PrintMancalaWithStones mancalaA = new PrintMancalaWithStones(955, 75, 100, 300);
		
//		b2.removeStone4(); //makes b2 disappear a stone
		

	}

	public class PrintPitWithStones {
		
		private Ellipse2D.Double pit;
		private Ellipse2D.Double stone1;
		private Ellipse2D.Double stone2;
		private Ellipse2D.Double stone3;
		private Ellipse2D.Double stone4;
		

		public PrintPitWithStones(int x, int y, int size) {
			
			

			pit = new Ellipse2D.Double(x, y, size, size);
			stone1 = new Ellipse2D.Double(x + 25, y + 25, 20, 20);
			stone2 = new Ellipse2D.Double(x + 50, y + 25, 20, 20);
			stone3 = new Ellipse2D.Double(x + 25, y + 50, 20, 20);
			stone4 = new Ellipse2D.Double(x + 50, y + 50, 20, 20);

			g2.draw(pit);
			
			g2.setColor(Color.black);
			
			g2.fill(stone1);
			g2.fill(stone2);
			g2.fill(stone3);
			g2.fill(stone4);
		}
		
		//use in case the user chooses 3 stones
		public void removeStone4() {
			g2.setColor(getBackground());
			g2.fill(stone4);
			g2.setColor(Color.black);

		}
		public void removeStone3() {
			g2.setColor(getBackground());
			g2.fill(stone3);
			g2.setColor(Color.black);

		}
		
		public void removeStone2() {
			g2.setColor(getBackground());
			g2.fill(stone2);
			g2.setColor(Color.black);

		}
		
		public void removeStone1() {
			g2.setColor(getBackground());
			g2.fill(stone1);
			g2.setColor(Color.black);

		}
		
		
		
		
	} //end of PrintPitWithStones
	
	
	public class PrintMancalaWithStones {
		
		private Rectangle2D.Double mancala;
		private Ellipse2D.Double stone1;
		private Ellipse2D.Double stone2;
		private Ellipse2D.Double stone3;
		private Ellipse2D.Double stone4;
		private Ellipse2D.Double stone5;
		private Ellipse2D.Double stone6;
		private Ellipse2D.Double stone7;
		private Ellipse2D.Double stone8;
		private Ellipse2D.Double stone9;
		private Ellipse2D.Double stone10;
		private Ellipse2D.Double stone11;
		private Ellipse2D.Double stone12;
		private Ellipse2D.Double stone13;
		private Ellipse2D.Double stone14;
		private Ellipse2D.Double stone15;
		private Ellipse2D.Double stone16;
		private Ellipse2D.Double stone17;
		private Ellipse2D.Double stone18;
		private Ellipse2D.Double stone19;
		private Ellipse2D.Double stone20;
		private Ellipse2D.Double stone21;
		private Ellipse2D.Double stone22;
		private Ellipse2D.Double stone23;
		private Ellipse2D.Double stone24;

		
		
		public PrintMancalaWithStones(int x, int y, int width, int height) {
			mancala = new Rectangle2D.Double(x, y, width, height);
			
			stone1 = new Ellipse2D.Double(x + 10, y + 22 , 20, 20);
			stone2 = new Ellipse2D.Double(x + 40, y + 22, 20, 20);
			stone3 = new Ellipse2D.Double(x + 70, y + 22, 20, 20);
			
			stone4 = new Ellipse2D.Double(x + 10, y + 57 , 20, 20);
			stone5 = new Ellipse2D.Double(x + 40, y + 57, 20, 20);
			stone6 = new Ellipse2D.Double(x + 70, y + 57, 20, 20);
			
			stone7 = new Ellipse2D.Double(x + 10, y + 92 , 20, 20);
			stone8 = new Ellipse2D.Double(x + 40, y + 92, 20, 20);
			stone9 = new Ellipse2D.Double(x + 70, y + 92, 20, 20);
			
			stone10 = new Ellipse2D.Double(x + 10, y + 127 , 20, 20);
			stone11 = new Ellipse2D.Double(x + 40, y + 127, 20, 20);
			stone12 = new Ellipse2D.Double(x + 70, y + 127, 20, 20);
			
			stone13 = new Ellipse2D.Double(x + 10, y + 162 , 20, 20);
			stone14 = new Ellipse2D.Double(x + 40, y + 162, 20, 20);
			stone15 = new Ellipse2D.Double(x + 70, y + 162, 20, 20);
			
			stone16 = new Ellipse2D.Double(x + 10, y + 197 , 20, 20);
			stone17 = new Ellipse2D.Double(x + 40, y + 197, 20, 20);
			stone18 = new Ellipse2D.Double(x + 70, y + 197, 20, 20);

			stone19 = new Ellipse2D.Double(x + 10, y + 232 , 20, 20);
			stone20 = new Ellipse2D.Double(x + 40, y + 232, 20, 20);
			stone21 = new Ellipse2D.Double(x + 70, y + 232, 20, 20);
			
			stone22 = new Ellipse2D.Double(x + 10, y + 267 , 20, 20);
			stone23 = new Ellipse2D.Double(x + 40, y + 267, 20, 20);
			stone24 = new Ellipse2D.Double(x + 70, y + 267, 20, 20);

			


			g2.draw(mancala);
			
//			g2.setColor(getBackground());
			g2.setColor(Color.blue); //comment this and uncomment above line to hide mancala stones
			
			g2.fill(stone1);
			g2.fill(stone2);
			g2.fill(stone3);
			
			g2.fill(stone4);
			g2.fill(stone5);
			g2.fill(stone6);
			
			g2.fill(stone7);
			g2.fill(stone8);
			g2.fill(stone9);
			
			g2.fill(stone10);
			g2.fill(stone11);
			g2.fill(stone12);
			
			g2.fill(stone13);
			g2.fill(stone14);
			g2.fill(stone15);
			
			g2.fill(stone16);
			g2.fill(stone17);
			g2.fill(stone18);
			
			g2.fill(stone19);
			g2.fill(stone20);
			g2.fill(stone21);
			
			g2.fill(stone22);
			g2.fill(stone23);
			g2.fill(stone24);
			
			g2.setColor(Color.black);
			
			
		}
		
		public void removeStonesForThree(Color backgroundColor) {
			g2.setColor(backgroundColor);
			g2.fill(stone22);
			g2.fill(stone23);
			g2.fill(stone24);
			
			g2.fill(stone1);
			g2.fill(stone2);
			g2.fill(stone3);
			
			g2.setColor(Color.black);
			

		}
		
	}
	
}//end of PrintMancalaWithStones
