import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Shape;
/**
 * @author Kevin Chau
 * @version 1.0
 * The MancalaController class is responsible for managing the interactions between the model, view, and initial screen
 * in the Mancala game. It sets up the necessary listeners and handles user input to update the game state accordingly.
 */
public class MancalaController{
    MancalaModel model;
    MancalaView view;
    MancalaInitScreen initScreen;
    
    /**
     * Constructs a MancalaController object.
     *
     * @param m the model of the Mancala game
     * @param v the view of the Mancala game
     * @param initView the initial screen view of the Mancala game
     */
    public MancalaController(MancalaModel m, MancalaView v, MancalaInitScreen initView){
        model = m;
        view = v;
        initScreen = initView;
        model.addActionListener(view);
        model.addActionListener(initScreen);
        initViewListeners();
        initScreenListeners();
    }

    /**
     * Initializes the listeners for the initial screen of the Mancala game.
     * 
     * This method sets up action listeners for the following components:
     * - The button to proceed to the next frame, which validates the number of stones input and updates the model accordingly.
     * - The button to select the first board style, which updates the view to use an elliptical bright color board.
     * - The button to select the second board style, which updates the view to use a rectangular dark color board.
     * 
     * If the number of stones input is not 3 or 4, an error message is displayed.
     * If the input is not an integer, an error message is displayed.
     * 
     * The view listeners are reinitialized after changing the board style to update the position of the shapes in the view.
     */
    public void initScreenListeners(){
        initScreen.getToNextFrame().addActionListener((event) -> {
            try{
                int numStones = Integer.parseInt(initScreen.getPitInput().getText());
                if(numStones == 3 || numStones == 4){
                    model.setNumStones(numStones);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a either 3 or 4 for the number of stones.");
                }
            } catch (Exception nfe){
                JOptionPane.showMessageDialog(null, "Please enter an integer for the number of stones.");
            }
        });

        // Below are View-to-View direct interaction without needing a model to update and using 
        // controller as intermediary since having a model to notify is redundant and complicates the code.
        initScreen.getStyle1().addActionListener((event) -> {
            view.setBoardStyle(new EllipseBrightColorBoard());
            // reinitialize listeners to update the position of the shapes in the view
            initViewListeners();
        });

        initScreen.getStyle2().addActionListener((event) -> {
            view.setBoardStyle(new RectangleDarkColorBoard());
            // reinitialize listeners to update the position of the shapes in the view
            initViewListeners();
        });
    }

    /**
     * Initializes the view listeners for the Mancala game. This method sets up mouse listeners
     * for the pits of both players and an action listener for the undo button. When a pit is clicked,
     * it checks if the click is within the pit shape and if the pit is not empty. Depending on the 
     * current player's turn, it mutates the pits accordingly. It also checks for the end of the game 
     * and prompts the user to play again or exit. The undo button allows the user to undo the last move.
     */
    public void initViewListeners(){
        JPanel[] playerAPanels = view.getPlayerAPanels();
        JPanel[] playerBPanels = view.getPlayerBPanels();

        for(int i = 1; i < playerAPanels.length; i++){
            int index = i;
            playerAPanels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Shape shape = view.getPitShape();
                    if(shape.contains(e.getPoint())) {
                        if(model.isPitEmpty(index))
                            return;
                        if(model.isPlayerAturn())
                            model.mutatePlayerAPits(index);
                        if(model.checkEndGame()){
                            model.checkWinner();
                            int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
                            if (response == JOptionPane.YES_OPTION) 
                                model.reset();
                            else   
                                System.exit(0);
                        }
                    }
                }
            });
            playerBPanels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Shape shape = view.getPitShape();
                    if(shape.contains(e.getPoint())) {
                        if(model.isPitEmpty(model.oppositePit(index)))
                            return;
                        if(!model.isPlayerAturn())
                            model.mutatePlayerBPits(model.oppositePit(index));
                        if(model.checkEndGame()){
                            model.checkWinner();
                            int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
                            if (response == JOptionPane.YES_OPTION) 
                                model.reset();
                            else
                                System.exit(0);
                        }
                    }
                }
            });
        }

        view.getUndoButton().addActionListener((event) -> {
            model.undo();
        });
    }
}