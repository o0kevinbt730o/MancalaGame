import java.awt.Graphics2D;
import java.awt.Shape;

public class BoardStyleContext{
    private BoardStyle boardStyle;

    public BoardStyleContext(BoardStyle style){
        boardStyle = style;
    }

    public void drawMancala(Graphics2D g2, int x, int y, int width, int height, int numStones){
        boardStyle.drawStonesInMancala(g2, x, y, width, height, numStones);
    }

    public void drawPits(Graphics2D g2, int x, int y, int width, int height, int numStones){
        boardStyle.drawStonesInPits(g2, x, y, width, height, numStones);
    }

    public void drawBorder(Graphics2D g2, int x, int y, int width, int height, int arcWidth, int arcHeight){
        boardStyle.drawRoundRectBorder(g2, x, y, width, height, arcWidth, arcHeight);
    }

    public Shape getPit(){
        return boardStyle.getPit();
    }
    
}