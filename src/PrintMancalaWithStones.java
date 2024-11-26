import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class PrintMancalaWithStones{
		
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
		private Ellipse2D.Double stone25;
		private Ellipse2D.Double stone26;
		private Ellipse2D.Double stone27;
		private Ellipse2D.Double stone28;
		private Ellipse2D.Double stone29;
		private Ellipse2D.Double stone30;
		private Ellipse2D.Double stone31;
		private Ellipse2D.Double stone32;
		private Ellipse2D.Double stone33;
		private Ellipse2D.Double stone34;
		private Ellipse2D.Double stone35;
		private Ellipse2D.Double stone36;
		private Ellipse2D.Double stone37;
		private Ellipse2D.Double stone38;
		private Ellipse2D.Double stone39;
		private Ellipse2D.Double stone40;
		private Ellipse2D.Double stone41;
		private Ellipse2D.Double stone42;
		private Ellipse2D.Double stone43;
		private Ellipse2D.Double stone44;
		private Ellipse2D.Double stone45;
		private Ellipse2D.Double stone46;
		private Ellipse2D.Double stone47;
		private Ellipse2D.Double stone48;
		
		private Color pitOutlineColor;
		private Color stoneColor;
		private Color backgroundColor;
		private Graphics2D g2;

		
		
		public PrintMancalaWithStones(int x, int y, int width, int height, Color pitOutlineColor, Color stoneColor, Color backgroundColor) {
			
			this.pitOutlineColor = pitOutlineColor;
			this.stoneColor = stoneColor;
			this.backgroundColor = backgroundColor;
			
			mancala = new Rectangle2D.Double(x, y, width, height);
			
			stone1 = new Ellipse2D.Double(x + 2, y + 5, width/5, width/5);
			stone2 = new Ellipse2D.Double(x+28, y+5, width/5, width/5);
			stone3 = new Ellipse2D.Double(x+53, y+5, width/5, width/5);
			stone4 = new Ellipse2D.Double(x+78, y+5, width/5, width/5);
			
			stone5 = new Ellipse2D.Double(x + 2, y + 30, width/5, width/5);
			stone6 = new Ellipse2D.Double(x+28, y+30, width/5, width/5);
			stone7 = new Ellipse2D.Double(x+53, y+30, width/5, width/5);
			stone8 = new Ellipse2D.Double(x+78, y+30, width/5, width/5);
			
			stone9 = new Ellipse2D.Double(x + 2, y + 55, width/5, width/5);
			stone10 = new Ellipse2D.Double(x+28, y+55, width/5, width/5);
			stone11 = new Ellipse2D.Double(x+53, y+55, width/5, width/5);
			stone12 = new Ellipse2D.Double(x+78, y+55, width/5, width/5);
			
			stone13 = new Ellipse2D.Double(x + 2, y + 80, width/5, width/5);
			stone14 = new Ellipse2D.Double(x+28, y+80, width/5, width/5);
			stone15 = new Ellipse2D.Double(x+53, y+80, width/5, width/5);
			stone16 = new Ellipse2D.Double(x+78, y+80, width/5, width/5);
			
			stone17 = new Ellipse2D.Double(x + 2, y + 105, width/5, width/5);
			stone18 = new Ellipse2D.Double(x+28, y+105, width/5, width/5);
			stone19 = new Ellipse2D.Double(x+53, y+105, width/5, width/5);
			stone20 = new Ellipse2D.Double(x+78, y+105, width/5, width/5);
			
			stone21 = new Ellipse2D.Double(x + 2, y + 130, width/5, width/5);
			stone22 = new Ellipse2D.Double(x+28, y+130, width/5, width/5);
			stone23 = new Ellipse2D.Double(x+53, y+130, width/5, width/5);
			stone24 = new Ellipse2D.Double(x+78, y+130, width/5, width/5);
			
			stone25 = new Ellipse2D.Double(x + 2, y + 155, width/5, width/5);
			stone26 = new Ellipse2D.Double(x+28, y+155, width/5, width/5);
			stone27 = new Ellipse2D.Double(x+53, y+155, width/5, width/5);
			stone28 = new Ellipse2D.Double(x+78, y+155, width/5, width/5);
			
			stone29 = new Ellipse2D.Double(x + 2, y + 180, width/5, width/5);
			stone30 = new Ellipse2D.Double(x+28, y+180, width/5, width/5);
			stone31 = new Ellipse2D.Double(x+53, y+180, width/5, width/5);
			stone32 = new Ellipse2D.Double(x+78, y+180, width/5, width/5);
			
			stone33 = new Ellipse2D.Double(x + 2, y + 205, width/5, width/5);
			stone34 = new Ellipse2D.Double(x+28, y+205, width/5, width/5);
			stone35 = new Ellipse2D.Double(x+53, y+205, width/5, width/5);
			stone36 = new Ellipse2D.Double(x+78, y+205, width/5, width/5);
			
			stone37 = new Ellipse2D.Double(x + 2, y + 230, width/5, width/5);
			stone38 = new Ellipse2D.Double(x+28, y+230, width/5, width/5);
			stone39 = new Ellipse2D.Double(x+53, y+230, width/5, width/5);
			stone40 = new Ellipse2D.Double(x+78, y+230, width/5, width/5);
			
			stone41 = new Ellipse2D.Double(x + 2, y + 255, width/5, width/5);
			stone42 = new Ellipse2D.Double(x+28, y+255, width/5, width/5);
			stone43 = new Ellipse2D.Double(x+53, y+255, width/5, width/5);
			stone44 = new Ellipse2D.Double(x+78, y+255, width/5, width/5);
			
			stone45 = new Ellipse2D.Double(x + 2, y + 280, width/5, width/5);
			stone46 = new Ellipse2D.Double(x+28, y+280, width/5, width/5);
			stone47 = new Ellipse2D.Double(x+53, y+280, width/5, width/5);
			stone48 = new Ellipse2D.Double(x+78, y+280, width/5, width/5);		
			
		}
		
		
		//reduce the number of stones in the mancalca from 48 to 36
		public void removeMancalaStonesForThree() {
//			stone33 = null;
//			stone34 = null; 
//			stone35 = null;
//			stone36 = null;
//			
//			stone37 = null;
//			stone38 = null; 
//			stone39 = null;
//			stone40 = null;
//			
//			stone41 = null;
//			stone42 = null; 
//			stone43 = null;
//			stone44 = null;
//			
//			stone45 = null;
//			stone46 = null; 
//			stone47 = null;
//			stone48 = null;
			
			g2.setColor(backgroundColor);
			
			g2.fill(stone33);
			g2.fill(stone34);
			g2.fill(stone35);
			g2.fill(stone36);
			g2.fill(stone37);
			g2.fill(stone38);
			g2.fill(stone39);
			g2.fill(stone40);
			g2.fill(stone41);
			g2.fill(stone42);
			g2.fill(stone43);
			g2.fill(stone44);
			g2.fill(stone45);
			g2.fill(stone46);
			g2.fill(stone47);
			g2.fill(stone48);
			
			g2.setColor(stoneColor);

		}
		
		
		public void setMancalaColor(Color c){
			
		}


		public void draw(Graphics2D g2) {
			this.g2 = g2;
			// TODO Auto-generated method stub
			g2.setColor(pitOutlineColor);
			g2.draw(mancala);
			
//			g2.setColor(getBackground());
			g2.setColor(stoneColor); //comment this and uncomment above line to hide mancala stones
			
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
			
			g2.fill(stone25);
			g2.fill(stone26);
			g2.fill(stone27);
			g2.fill(stone28);
			
			g2.fill(stone29);
			g2.fill(stone30);
			g2.fill(stone31);
			g2.fill(stone32);
			
			g2.fill(stone33);
			g2.fill(stone34);
			g2.fill(stone35);
			g2.fill(stone36);
			
			g2.fill(stone37);
			g2.fill(stone38);
			g2.fill(stone39);
			g2.fill(stone40);
			
			g2.fill(stone41);
			g2.fill(stone42);
			g2.fill(stone43);
			g2.fill(stone44);
			
			g2.fill(stone45);
			g2.fill(stone46);
			g2.fill(stone47);
			g2.fill(stone48);
			
			g2.setColor(Color.black);
			
		}

		
	}//end of PrintMancalaWithStones