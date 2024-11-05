import javax.swing.*;
import java.awt.geom.*;
public class MancalaView extends JFrame{
    private EllipseJButton[] playerAButtons;
    private EllipseJButton[] playerBButtons;
    private JLabel mancalaA;
    private JLabel mancalaB;
    private JButton undoButton;
    
    public MancalaView(){
        this.setTitle("Mancala Game");
        this.setSize(1200,1200);
        this.setLayout(null);
        playerAButtons = new EllipseJButton[6];
        playerBButtons = new EllipseJButton[6];

        int player_XPOS = 200;
        for(int i = 0; i < 5; i++){
            playerAButtons[i] = new EllipseJButton(player_XPOS, 75, 100, 150);
            playerBButtons[i] = new EllipseJButton(player_XPOS, 275, 100, 150);
            this.add(playerAButtons[i]);
            this.add(playerBButtons[i]);
            player_XPOS+=125;
        }

        DrawPanel panel = new DrawPanel();
        panel.setBounds(0, 0, 1200, 1200); // Set the bounds for the panel
        this.add(panel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}