import javax.swing.*;

import java.awt.*;
// import java.awt.geom.*;
public class MancalaView extends JFrame{
    private EllipseJButton[] playerAButtons;
    private EllipseJButton[] playerBButtons;
    // private JButton undoButton;
    
    public MancalaView(){
        this.setTitle("Mancala Game");
        this.setSize(1500, 1000);
        this.setLayout(new BorderLayout());


        JPanel panelLeft = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                g2.drawRoundRect(0, 0, 100, 700, 50, 50);
            }
        };
        panelLeft.setPreferredSize(new Dimension(100, 1000));

        JPanel panelRight = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                g2.drawRoundRect(0, 0, 100, 700, 50, 50);
            }
        };
        panelRight.setPreferredSize(new Dimension(100, 1000));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(2,6));
        panelCenter.setPreferredSize(new Dimension(1200, 700));

        playerAButtons = new EllipseJButton[6];
        playerBButtons = new EllipseJButton[6];
        // int playerXPos = 200;
        for(int i = 0; i < 5; i++){
            playerAButtons[i] = new EllipseJButton();
            playerBButtons[i] = new EllipseJButton();
            panelCenter.add(playerAButtons[i]);
            panelCenter.add(playerBButtons[i]);
            // playerXPos += 125;
        }

        //DrawPanel panel = new DrawPanel();
        //panel.setBounds(0, 0, 1200, 1200); // Set the bounds for the panel
        
        JLabel playerA = new JLabel("PLAYER A --->");
        playerA.setHorizontalAlignment(JLabel.CENTER);
        playerA.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel playerB = new JLabel("<--- PLAYER B");
        playerB.setHorizontalAlignment(JLabel.CENTER);
        playerB.setFont(new Font("Arial", Font.BOLD, 30));
        playerB.setHorizontalAlignment(JLabel.CENTER);
        
        this.add(playerA, BorderLayout.SOUTH);
        this.add(playerB, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MancalaView view = new MancalaView();
    }
}