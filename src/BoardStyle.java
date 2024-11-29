import java.awt.*;
public interface BoardStyle{
    void drawStonesInMancala(Graphics2D g2, int x, int y, int width, int height, int numStones);
    void drawStonesInPits(Graphics2D g2, int x, int y, int width, int height, int numStones);
    void drawRoundRectBorder(Graphics2D g2, int x, int y, int width, int height, int arcWidth, int arcHeight);
    Shape getPit();
}