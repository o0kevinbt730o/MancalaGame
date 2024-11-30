import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Shape;
public class MancalaController{
    MancalaModel model;
    MancalaView view;
    MancalaInitScreen initScreen;
    
    public MancalaController(MancalaModel m, MancalaView v, MancalaInitScreen initView){
        model = m;
        view = v;
        initScreen = initView;
        model.addActionListener(view);
        model.addActionListener(initScreen);
        initViewListeners();
        initScreenListeners();
    }

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

        // Below are View-to-View direct interaction without needing model to update and using controller as intermediary
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
                        System.out.println("Player A " + index + " Button clicked");
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
                        System.out.println("Player B " + index + " Button clicked");
                    }
                }
            });
        }

        view.getUndoButton().addActionListener((event) -> {
            model.undo();
        });
    }
}