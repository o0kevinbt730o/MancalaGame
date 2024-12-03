import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Color;
/**
 * @author Kevin Chau
 * @version 1.0
 * The EllipseBrightColorBoard class implements the BoardStyle interface and provides
 * methods to draw the Mancala board with pits and stones. This class is a 
 * concrete strategy implementation of the BoardStyle interface.
 */
public class EllipseBrightColorBoard implements BoardStyle{
    private Ellipse2D.Double pit;
    private RoundRectangle2D.Double mancala;
    private RoundRectangle2D.Double boardBorder;

    /**
     * Draws stones in the Mancala board.
     *
     * @param g2 the graphics context
     * @param x the x-coordinate of the top-left corner of the Mancala
     * @param y the y-coordinate of the top-left corner of the Mancala
     * @param width the width of the Mancala
     * @param height the height of the Mancala
     * @param numStones the number of stones to draw in the Mancala
     */
    public void drawStonesInMancala(Graphics2D g2, int x, int y, int width, int height, int numStones) {
        mancala = new RoundRectangle2D.Double(x, y, width, height, 50, 50);
        g2.setColor(Color.RED);
        g2.draw(mancala);
        
        int row = numStones / 4 + 1;
        Ellipse2D.Double[][] ellipses = new Ellipse2D.Double[row][4];
        double xpos = mancala.getX() + 10;
        double ypos = mancala.getY() + 10;
        int count = 0;
        for (int r = 0; r < ellipses.length; r++) {
            for (int c = 0; c < ellipses[r].length; c++) {
                if (count >= numStones)
                    return;
                ellipses[r][c] = new Ellipse2D.Double(xpos, ypos, 20, 20);
                xpos += 25;
                g2.setColor(Color.GREEN);
                g2.fill(ellipses[r][c]);
                g2.setColor(Color.BLACK);
                g2.draw(ellipses[r][c]);
                count++;
            }
            xpos = mancala.getX() + 10;
            ypos += 25;
        }
    }

    /**
     * Draws stones in the pits on the Mancala board.
     *
     * @param g2        the Graphics2D object used for drawing
     * @param x         the x-coordinate of the pit
     * @param y         the y-coordinate of the pit
     * @param width     the width of the pit
     * @param height    the height of the pit
     * @param numStones the number of stones to draw in the pit
     */
    public void drawStonesInPits(Graphics2D g2, int x, int y, int width, int height, int numStones) {
        pit = new Ellipse2D.Double(x, y, width, height);
        g2.setColor(Color.ORANGE);
        g2.draw(pit);
        
        int row = numStones / 4 + 1;
        Ellipse2D.Double[][] ellipses = new Ellipse2D.Double[row][4];
        double xpos = pit.getX() + 40;
        double ypos = pit.getY() + 40;
        int count = 0;
        for (int r = 0; r < ellipses.length; r++) {
            for (int c = 0; c < ellipses[r].length; c++) {
                if (count >= numStones)
                    return;
                ellipses[r][c] = new Ellipse2D.Double(xpos, ypos, 20, 20);
                xpos += 25;
                g2.setColor(Color.RED);
                g2.fill(ellipses[r][c]);
                g2.setColor(Color.BLACK);
                g2.draw(ellipses[r][c]);
                count++;
            }
            xpos = pit.getX() + 40;
            ypos += 30;
        }
    }

    /**
     * Draws a rounded rectangle border on the given Graphics2D context.
     *
     * @param g2 the Graphics2D context to draw on
     * @param x the x coordinate of the rectangle
     * @param y the y coordinate of the rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @param arcWidth the horizontal diameter of the arc at the four corners
     * @param arcHeight the vertical diameter of the arc at the four corners
     */
    public void drawRoundRectBorder(Graphics2D g2, int x, int y, int width, int height, int arcWidth, int arcHeight) {
        boardBorder = new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);
        g2.setColor(Color.BLUE);
        g2.draw(boardBorder);
    }

    /**
     * Retrieves the shape of the pit to be used for detecting the bounds of the pit. This is used for mouse events in 
     * MancalaController to track where the user clicks inside the pit JPanels.
     *
     * @return the shape of the pit
     */
    public Shape getPit() {
        return pit;
    }
}