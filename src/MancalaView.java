import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MancalaView extends JFrame implements ActionListener {
    private JPanel[] playerAPanels;
    private JPanel[] playerBPanels;
    private JButton undoButton;
    private MancalaModel model;
    private BoardStyleContext boardStyle;

    public MancalaView(MancalaModel m) {
        model = m;
        boardStyle = new BoardStyleContext(new RegularColorMancalaBoard());
        this.setTitle("Mancala Game");
        this.setSize(1500, 800);
        this.setResizable(false);
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
                int mancalaB = model.getMancalaB();
                boardStyle.drawMancala(g2, 0, 0, getWidth() - 10, getHeight() - 10, mancalaB);
            }
        };
        panelLeft.setPreferredSize(new Dimension(125, 550));

        JPanel panelRight = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                int mancalaA = model.getMancalaA();
                boardStyle.drawMancala(g2, 0, 0, getWidth() - 10, getHeight() - 10, mancalaA);
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
            int index = i;
            playerAPanels[i] = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    int[] playerAPits = model.getPlayerAPits();
                    int numStones = playerAPits[index];
                    boardStyle.drawPits(g2, 0, 0, getWidth() - 10, getHeight() - 10, numStones);
                }
            };
            playerAPanels[i].setPreferredSize(new Dimension(175, 260));
            aboveBottomLabelsPanel.add(playerAPanels[i]);

            playerBPanels[i] = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    int[] playerBPits = model.getPlayerBPits();
                    int numStones = playerBPits[model.oppositePit(index)];
                    boardStyle.drawPits(g2, 0, 0, getWidth() - 10, getHeight() - 10, numStones);
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
                boardStyle.drawBorder(g2, 10, 0, getWidth() - 20, getHeight(), 50, 50);
            }
        };
        roundRectanglePanel.setPreferredSize(new Dimension(1400, 650));
        roundRectanglePanel.setLayout(new BorderLayout());
        // Decorate roundRectanglePanel with padding by using BorderFactory.createEmptyBorder() --> Decorator Pattern
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

    public Shape getPitShape() {
        return boardStyle.getPit();
    }

    // View-to-View interaction usin controller as intermediary.
    public void setBoardStyle(BoardStyle style) {
        boardStyle = new BoardStyleContext(style);
        repaint();
        // Below is the method to repaint this MancalaView (JFrame) instantly
        RepaintManager.currentManager(this).paintDirtyRegions();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("updateView")){
            repaint();
        } else if (cmd.equals("updateViewPlayAgain")){
            setBoardStyle(new RegularColorMancalaBoard());
        } else if (cmd.equals("undoPits"))
            repaint();
        else if (cmd.equals("playerAWins"))
            JOptionPane.showMessageDialog(this, "PLAYER A WINS!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        else if (cmd.equals("playerBWins"))
            JOptionPane.showMessageDialog(this, "PLAYER B WINS!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        else if (cmd.equals("Tie"))
            JOptionPane.showMessageDialog(this, "IT'S A TIE!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }
}