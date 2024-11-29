import java.awt.geom.*;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Color;

public class RectangleDarkColorBoard implements BoardStyle{
    private RoundRectangle2D.Double pit;
    private Rectangle2D.Double mancala;
    private RoundRectangle2D.Double boardBorder;

    public void drawStonesInMancala(Graphics2D g2, int x, int y, int width, int height, int numStones) {
        mancala = new Rectangle2D.Double(x, y, width, height);
        g2.setColor(Color.decode("#990099"));
        g2.draw(mancala);
        
        int row = numStones / 4 + 1;
        Rectangle2D.Double[][] ellipses = new Rectangle2D.Double[row][4];
        double xpos = mancala.getX() + 10;
        double ypos = mancala.getY() + 10;
        int count = 0;
        for (int r = 0; r < ellipses.length; r++) {
            for (int c = 0; c < ellipses[r].length; c++) {
                if (count >= numStones)
                    return;
                ellipses[r][c] = new Rectangle2D.Double(xpos, ypos, 20, 20);
                xpos += 25;
                g2.setColor(Color.decode("#4C0099"));
                g2.fill(ellipses[r][c]);
                g2.setColor(Color.BLACK);
                g2.draw(ellipses[r][c]);
                count++;
            }
            xpos = mancala.getX() + 10;
            ypos += 25;
        }
    }

    public void drawStonesInPits(Graphics2D g2, int x, int y, int width, int height, int numStones) {
        pit = new RoundRectangle2D.Double(x, y, width, height, 50, 50);
        g2.setColor(Color.decode("#009900"));
        g2.draw(pit);
        
        int row = numStones / 4 + 1;
        Rectangle2D.Double[][] ellipses = new Rectangle2D.Double[row][4];
        double xpos = pit.getX() + 40;
        double ypos = pit.getY() + 40;
        int count = 0;
        for (int r = 0; r < ellipses.length; r++) {
            for (int c = 0; c < ellipses[r].length; c++) {
                if (count >= numStones)
                    return;
                ellipses[r][c] = new Rectangle2D.Double(xpos, ypos, 20, 20);
                xpos += 25;
                g2.setColor(Color.decode("#99004C"));
                g2.fill(ellipses[r][c]);
                g2.setColor(Color.BLACK);
                g2.draw(ellipses[r][c]);
                count++;
            }
            xpos = pit.getX() + 40;
            ypos += 30;
        }
    }

    public void drawRoundRectBorder(Graphics2D g2, int x, int y, int width, int height, int arcWidth, int arcHeight) {
        boardBorder = new RoundRectangle2D.Double(x, y, width, height, 50, 50);
        g2.setColor(Color.decode("#990000"));
        g2.draw(boardBorder);
    }

    public Shape getPit() {
        return pit;
    }
}