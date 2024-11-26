import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class PrintPitWithStones{
		
		private Ellipse2D.Double pit;
		private Ellipse2D.Double stone1;
		private Ellipse2D.Double stone2;
		private Ellipse2D.Double stone3;
		private Ellipse2D.Double stone4;
		private Color pitColor;
		private Color stoneColor;
		private Color backgroundColor;
		private Graphics2D g2;
		

		public PrintPitWithStones(int x, int y, int size, Color pitColor, Color stoneColor, Color backgroundColor) {
			
			pit = new Ellipse2D.Double(x, y, size, size);
			stone1 = new Ellipse2D.Double(x + 25, y + 25, 20, 20);
			stone2 = new Ellipse2D.Double(x + 50, y + 25, 20, 20);
			stone3 = new Ellipse2D.Double(x + 25, y + 50, 20, 20);
			stone4 = new Ellipse2D.Double(x + 50, y + 50, 20, 20);
			this.pitColor = pitColor;
			this.stoneColor = stoneColor;
			this.backgroundColor = backgroundColor;
		}
		
		public void draw(Graphics2D g2) {
			this.g2 = g2;
			
			
			g2.setColor(pitColor);
			g2.draw(pit);
			
			g2.setColor(stoneColor);
			g2.fill(stone1);
			g2.fill(stone2);
			g2.fill(stone3);
			g2.fill(stone4);
			
			
			
		}
		
		public void removeStone4() {
		    g2.setColor(backgroundColor);
		    g2.fill(stone4);
		}
		
//		public void setStone4Null() {
//			stone4 = null;
//		}

		public void removeStone3() {
		    g2.setColor(backgroundColor);
		    g2.fill(stone3);
		}

		public void removeStone2() {
		    g2.setColor(backgroundColor);
		    g2.fill(stone2);
		}

		public void removeStone1() {
		    g2.setColor(backgroundColor);
		    g2.fill(stone1);
		}
		

		
		
		
		
	} //end of PrintPitWithStones