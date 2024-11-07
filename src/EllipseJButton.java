import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class EllipseJButton extends JButton {
    private int x, y, width, height;
    public EllipseJButton() {
        // this.x = x;
        // this.y = y;
        // this.width = width;
        // this.height = height;

        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        //this.setBounds(x, y, width, height);
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        g2.draw(new Ellipse2D.Double(0, 0, 100, 150));
        
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(width, height);
    }

    @Override
    public boolean contains(int x, int y){
        Ellipse2D ellipse = new Ellipse2D.Double(0, 0, width, height);
        return ellipse.contains(x, y);
    }
}
