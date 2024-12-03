import java.awt.*;
/**
 * @author Kevin Chau
 * @version 1.0
 * The BoardStyle interface provides methods for drawing various components of a Mancala board.
 * Implementations of this interface should define how stones are drawn in the Mancala and pits,
 * as well as how the borders of the board are drawn.
 */
public interface BoardStyle{
    void drawStonesInMancala(Graphics2D g2, int x, int y, int width, int height, int numStones);
    void drawStonesInPits(Graphics2D g2, int x, int y, int width, int height, int numStones);
    void drawRoundRectBorder(Graphics2D g2, int x, int y, int width, int height, int arcWidth, int arcHeight);
    Shape getPit();
}