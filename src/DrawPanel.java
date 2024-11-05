import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.JPanel;

//idk if yall like this mancala board
public class DrawPanel extends JPanel {
	private int boardTopLeftX = 50;
	private int boardTopLeftY = 50;
	private int boardWidth = 1025;
	private int boardHeight = 350;

    public DrawPanel() {
        super();
    }

    @Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double board = new Rectangle2D.Double(boardTopLeftX, boardTopLeftY, boardWidth, boardHeight); //(50,50,900,350)
        
        Rectangle2D.Double mancalaB = new Rectangle2D.Double(75,75, 100, 300); 
        Rectangle2D.Double mancalaA = new Rectangle2D.Double(950,75, 100, 300); 
        

        
        //idk how to make the pits buttons if we want them to be buttons
        // Ellipse2D.Double b6 = new Ellipse2D.Double(200, 75, 100, 100);
        // Ellipse2D.Double b5 = new Ellipse2D.Double(325, 75, 100, 100);
        // Ellipse2D.Double b4 = new Ellipse2D.Double(450, 75, 100, 100);
        // Ellipse2D.Double b3 = new Ellipse2D.Double(575, 75, 100, 100);
        // Ellipse2D.Double b2 = new Ellipse2D.Double(700, 75, 100, 100);
        // Ellipse2D.Double b1 = new Ellipse2D.Double(825, 75, 100, 100);
        
        // Ellipse2D.Double a6 = new Ellipse2D.Double(200, 275, 100, 100);
        // Ellipse2D.Double a5 = new Ellipse2D.Double(325, 275, 100, 100);
        // Ellipse2D.Double a4 = new Ellipse2D.Double(450, 275, 100, 100);
        // Ellipse2D.Double a3 = new Ellipse2D.Double(575, 275, 100, 100);
        // Ellipse2D.Double a2 = new Ellipse2D.Double(700, 275, 100, 100);
        // Ellipse2D.Double a1 = new Ellipse2D.Double(825, 275, 100, 100);
        
        
        g2.draw(board);
        // g2.draw(b6);
        // g2.draw(b5);
        // g2.draw(b4);
        // g2.draw(b3);
        // g2.draw(b2);
        // g2.draw(b1);
        // g2.draw(a6);
        // g2.draw(a5);
        // g2.draw(a4);
        // g2.draw(a3);
        // g2.draw(a2);
        // g2.draw(a1);
        g2.draw(mancalaA);
        g2.draw(mancalaB);
        

	}
}
