import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Color;

public class EllipseBrightColorBoard implements BoardStyle{
    private Ellipse2D.Double pit;
    private RoundRectangle2D.Double mancala;
    private RoundRectangle2D.Double boardBorder;

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

    public void drawRoundRectBorder(Graphics2D g2, int x, int y, int width, int height, int arcWidth, int arcHeight) {
        boardBorder = new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);
        g2.setColor(Color.BLUE);
        g2.draw(boardBorder);
    }

    public Shape getPit() {
        return pit;
    }
}