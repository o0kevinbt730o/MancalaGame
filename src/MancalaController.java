import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class MancalaController{
    MancalaModel model;
    MancalaView view;
    
    public MancalaController(MancalaModel m, MancalaView v){
        model = m;
        view = v;
        model.addActionListener(view);
        initListeners();
    }

    public void initListeners(){
        JPanel[] playerAPanels = view.getPlayerAPanels();
        JPanel[] playerBPanels = view.getPlayerBPanels();
        Ellipse2D.Double ellipse = new Ellipse2D.Double(0, 0, 175, 260);

        for(int i = 1; i < playerAPanels.length; i++){
            int index = i;
            playerAPanels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(ellipse.contains(e.getPoint())) {
                        if(model.isPitEmpty(index))
                            return;
                        if(model.isPlayerAturn())
                            model.mutatePlayerAPits(index);
                        if(model.checkEndGame())
                            model.checkWinner();
                        System.out.println("Player A " + index + " Button clicked");
                    }
                }
            });

            playerBPanels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(ellipse.contains(e.getPoint())) {
                        if(model.isPitEmpty(model.oppositePit(index)))
                            return;
                        if(!model.isPlayerAturn())
                            model.mutatePlayerBPits(model.oppositePit(index));
                        if(model.checkEndGame())
                            model.checkWinner();
                    }
                    System.out.println("Player B " + index + " Button clicked");
                }
            });
        }

        view.getUndoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.undo();
            }
        });
    }
}