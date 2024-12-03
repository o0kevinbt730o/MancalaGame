import java.awt.Graphics2D;
import java.awt.Shape;
/**
 * @author Kevin Chau
 * @version 1.0
 * The BoardStyleContext class is responsible for managing and applying a specific board style.
 * It delegates the drawing operations to the BoardStyle instance provided during construction.
 */
public class BoardStyleContext{
    private BoardStyle boardStyle;

    /**
     * Constructs a BoardStyleContext with the specified BoardStyle.
     *
     * @param style the BoardStyle to be used for this context
     */
    public BoardStyleContext(BoardStyle style){
        boardStyle = style;
    }

    /**
     * Draws a Mancala pit with the specified dimensions and number of stones by the concrete strategy implementation of boardStyle.
     *
     * @param g2 the Graphics2D object used for drawing
     * @param x the x-coordinate of the top-left corner of the Mancala pit
     * @param y the y-coordinate of the top-left corner of the Mancala pit
     * @param width the width of the Mancala pit
     * @param height the height of the Mancala pit
     * @param numStones the number of stones to be drawn in the Mancala pit
     */
    public void drawMancala(Graphics2D g2, int x, int y, int width, int height, int numStones){
        boardStyle.drawStonesInMancala(g2, x, y, width, height, numStones);
    }

    /**
     * Draws the pits on the board with the specified parameters by the concrete strategy implementation of boardStyle.
     *
     * @param g2 the Graphics2D object used for drawing
     * @param x the x-coordinate of the top-left corner of the pit
     * @param y the y-coordinate of the top-left corner of the pit
     * @param width the width of the pit
     * @param height the height of the pit
     * @param numStones the number of stones to be drawn in the pit
     */
    public void drawPits(Graphics2D g2, int x, int y, int width, int height, int numStones){
        boardStyle.drawStonesInPits(g2, x, y, width, height, numStones);
    }

    /**
     * Draws a rounded rectangle border using the specified graphics context by the concrete strategy implementation of boardStyle.
     *
     * @param g2 the graphics context to use for drawing
     * @param x the x coordinate of the rectangle to be drawn
     * @param y the y coordinate of the rectangle to be drawn
     * @param width the width of the rectangle to be drawn
     * @param height the height of the rectangle to be drawn
     * @param arcWidth the horizontal diameter of the arc at the four corners
     * @param arcHeight the vertical diameter of the arc at the four corners
     */
    public void drawBorder(Graphics2D g2, int x, int y, int width, int height, int arcWidth, int arcHeight){
        boardStyle.drawRoundRectBorder(g2, x, y, width, height, arcWidth, arcHeight);
    }

    /**
     * Retrieves the shape of the pit from the board style by the concrete strategy implementation of boardStyle.
     *
     * @return the Shape object representing the pit.
     */
    public Shape getPit(){
        return boardStyle.getPit();
    }
}