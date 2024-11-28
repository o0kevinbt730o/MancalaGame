import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

public class MancalaView extends JFrame implements ActionListener {
    private JPanel[] playerAPanels;
    private JPanel[] playerBPanels;
    private JButton undoButton;
    private MancalaModel model;

    public MancalaView(MancalaModel m) {
        model = m;
        this.setTitle("Mancala Game");
        this.setSize(1500, 800);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // Index 0 will be ignored for easier implementation
        playerAPanels = new JPanel[7];
        playerBPanels = new JPanel[7];

        JPanel panelLeft = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);
                // Draw panelLeft within roundRectanglePanel bounds by using getWidth() and getHeight()
                RoundRectangle2D.Double roundRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 10, getHeight() - 10, 50, 50);
                g2.draw(roundRectangle);
                int mancalaB = model.getMancalaB();
                drawMancala(g2, mancalaB, roundRectangle);
            }
        };
        panelLeft.setPreferredSize(new Dimension(125, 550));

        JPanel panelRight = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);

                // Draw panelRight within roundRectanglePanel bounds by using getWidth() and getHeight()
                RoundRectangle2D.Double roundRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 10, getHeight() - 10, 50, 50);
                g2.draw(roundRectangle);
                int mancalaA = model.getMancalaA();
                drawMancala(g2, mancalaA, roundRectangle);
            }
        };
        panelRight.setPreferredSize(new Dimension(125, 550));

        JPanel bottomLabelsPanel = new JPanel();
        bottomLabelsPanel.setLayout(new GridLayout(1, 6));
        JLabel[] bottomLabels = new JLabel[7];
        for (int i = 1; i < 7; i++) {
            bottomLabels[i] = new JLabel("A" + i);
            bottomLabels[i].setFont(new Font("Arial", Font.BOLD, 30));
            bottomLabels[i].setHorizontalAlignment(JLabel.CENTER);
            bottomLabelsPanel.add(bottomLabels[i]);
        }
        // panelMiddle.add(bottomLabelsPanel);
        bottomLabelsPanel.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 120));

        JPanel topLabelsPanel = new JPanel();
        topLabelsPanel.setLayout(new GridLayout(1, 6));
        JLabel[] topLabels = new JLabel[7];
        for (int i = 1; i < 7; i++) {
            topLabels[i] = new JLabel("B" + (7 - i));
            topLabels[i].setFont(new Font("Arial", Font.BOLD, 30));
            topLabels[i].setHorizontalAlignment(JLabel.CENTER);
            topLabelsPanel.add(topLabels[i]);
        }
        // panelMiddle.add(topLabelsPanel);
        topLabelsPanel.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 120));

        JPanel panelMiddle = new JPanel();
        panelMiddle.setLayout(new GridLayout(2, 6));

        JPanel belowTopLabelsPanel = new JPanel();
        belowTopLabelsPanel.setLayout(new GridLayout(1, 6));
        belowTopLabelsPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        JPanel aboveBottomLabelsPanel = new JPanel();
        aboveBottomLabelsPanel.setLayout(new GridLayout(1, 6));
        aboveBottomLabelsPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        for (int i = 1; i < 7; i++) {
            Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 175, 260);
            int index = i;
            playerAPanels[i] = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    // Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, getWidth() - 10, getHeight() - 10);
                    //System.out.println("Ellipse: " + ellipse.getWidth() + " " + ellipse.getHeight());
                    g2.draw(ellipse);
                    int[] playerAPits = model.getPlayerAPits();
                    int numCircles = playerAPits[index];
                    drawCircles(g2, numCircles, ellipse);
                }
            };
            playerAPanels[i].setPreferredSize(new Dimension(175, 260));
            aboveBottomLabelsPanel.add(playerAPanels[i]);

            playerBPanels[i] = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    // Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, getWidth() - 10, getHeight() - 10);
                    g2.draw(ellipse);
                    int[] playerBPits = model.getPlayerBPits();
                    int numCircles = playerBPits[model.oppositePit(index)];
                    drawCircles(g2, numCircles, ellipse);
                }
            };
            playerBPanels[i].setPreferredSize(new Dimension(175, 260));
            belowTopLabelsPanel.add(playerBPanels[i]);
        }
        panelMiddle.add(belowTopLabelsPanel);
        panelMiddle.add(aboveBottomLabelsPanel);

        JPanel roundRectanglePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                // draw roundRectanglePanel within JFrame bounds by using getWidth() and getHeight()
                g2.drawRoundRect(10, 0, getWidth() - 20, getHeight(), 50, 50);
                // System.out.println("Round Rectangle: " + getWidth() + " " + getHeight());
            }
        };
        roundRectanglePanel.setPreferredSize(new Dimension(1400, 650));
        roundRectanglePanel.setLayout(new BorderLayout());
        // Decorate roundRectanglePanel with padding by using
        // BorderFactory.createEmptyBorder() --> Decorator Pattern
        roundRectanglePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        roundRectanglePanel.add(panelLeft, BorderLayout.WEST);
        roundRectanglePanel.add(panelRight, BorderLayout.EAST);
        roundRectanglePanel.add(panelMiddle, BorderLayout.CENTER);
        roundRectanglePanel.add(topLabelsPanel, BorderLayout.NORTH);
        roundRectanglePanel.add(bottomLabelsPanel, BorderLayout.SOUTH);

        JLabel playerA = new JLabel("PLAYER A →");
        playerA.setHorizontalAlignment(JLabel.CENTER);
        playerA.setFont(new Font("Arial", Font.BOLD, 48));

        JLabel playerB = new JLabel("← PLAYER B");
        playerB.setHorizontalAlignment(JLabel.CENTER);
        playerB.setFont(new Font("Arial", Font.BOLD, 48));

        JPanel mancalaA = new JPanel();
        mancalaA.setLayout(new BoxLayout(mancalaA, BoxLayout.Y_AXIS));
        String textMancalaA = "MANCALA B";
        JLabel blankLabelMancalaA = new JLabel(" ");
        blankLabelMancalaA.setFont(new Font("Arial", Font.BOLD, 48));
        blankLabelMancalaA.setAlignmentX(Component.CENTER_ALIGNMENT);
        mancalaA.add(blankLabelMancalaA);
        for (int i = 0; i < textMancalaA.length(); ++i) {
            JLabel label = new JLabel(textMancalaA.substring(i, i + 1));
            label.setFont(new Font("Arial", Font.BOLD, 48));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            mancalaA.add(label);
        }

        JPanel mancalaB = new JPanel();
        mancalaB.setLayout(new BoxLayout(mancalaB, BoxLayout.Y_AXIS));
        String textMancalaB = "MANCALA A";
        JLabel blankLabelMancalaB = new JLabel(" ");
        blankLabelMancalaB.setFont(new Font("Arial", Font.BOLD, 48));
        blankLabelMancalaB.setAlignmentX(Component.CENTER_ALIGNMENT);
        mancalaB.add(blankLabelMancalaB);
        for (int i = 0; i < textMancalaB.length(); ++i) {
            JLabel label = new JLabel(textMancalaB.substring(i, i + 1));
            label.setFont(new Font("Arial", Font.BOLD, 48));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            mancalaB.add(label);
        }

        undoButton = new JButton("Undo");
        undoButton.setFocusPainted(false);
        JPanel undoPanelAndPlayerALabel = new JPanel();
        undoPanelAndPlayerALabel.setLayout(new FlowLayout(FlowLayout.CENTER));
        undoPanelAndPlayerALabel.add(undoButton);
        undoPanelAndPlayerALabel.add(playerA);

        this.add(undoPanelAndPlayerALabel, BorderLayout.SOUTH);
        this.add(playerB, BorderLayout.NORTH);
        this.add(roundRectanglePanel, BorderLayout.CENTER);
        this.add(mancalaA, BorderLayout.WEST);
        this.add(mancalaB, BorderLayout.EAST);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel[] getPlayerAPanels() {
        return playerAPanels;
    }

    public JPanel[] getPlayerBPanels() {
        return playerBPanels;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    private void drawCircles(Graphics2D g2, int numCircles, Ellipse2D ellipse) {
        int row = numCircles / 4 + 1;
        Ellipse2D.Double[][] ellipses = new Ellipse2D.Double[row][4];
        double x = ellipse.getX() + 40;
        double y = ellipse.getY() + 40;
        int count = 0;
        for (int r = 0; r < ellipses.length; r++) {
            for (int c = 0; c < ellipses[r].length; c++) {
                if (count >= numCircles)
                    return;
                ellipses[r][c] = new Ellipse2D.Double(x, y, 20, 20);
                x += 25;
                g2.setColor(Color.RED);
                g2.fill(ellipses[r][c]);
                g2.setColor(Color.BLACK);
                g2.draw(ellipses[r][c]);
                count++;
            }
            x = ellipse.getX() + 40;
            y += 30;
        }
    }

    private void drawMancala(Graphics2D g2, int numCircles, RoundRectangle2D roundRectangle) {
        int row = numCircles / 4 + 1;
        Ellipse2D.Double[][] ellipses = new Ellipse2D.Double[row][4];
        double x = roundRectangle.getX() + 10;
        double y = roundRectangle.getY() + 10;
        int count = 0;
        for (int r = 0; r < ellipses.length; r++) {
            for (int c = 0; c < ellipses[r].length; c++) {
                if (count >= numCircles)
                    return;
                ellipses[r][c] = new Ellipse2D.Double(x, y, 20, 20);
                x += 25;
                g2.setColor(Color.GREEN);
                g2.fill(ellipses[r][c]);
                g2.setColor(Color.BLACK);
                g2.draw(ellipses[r][c]);
                count++;
            }
            x = roundRectangle.getX() + 10;
            y += 25;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("updateView")){
            System.out.println("Update View");
            model.print();
            repaint();
        } 
        else if (e.getActionCommand().equals("undoPits"))
            repaint();
        else if (e.getActionCommand().equals("playerAWins"))
            JOptionPane.showMessageDialog(this, "PLAYER A WINS!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        else if (e.getActionCommand().equals("playerBWins"))
            JOptionPane.showMessageDialog(this, "PLAYER B WINS!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        else if (e.getActionCommand().equals("tie"))
            JOptionPane.showMessageDialog(this, "IT'S A TIE!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }
}