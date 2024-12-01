import java.awt.event.*;
import java.util.*;
public class MancalaModel{
    private int[] playerAPits;
    private int[] playerBPits;
    private int mancalaA;
    private int mancalaB;
    boolean playerAturn;
    private Stack<MancalaState> undoStack;
    private int undoCount;
    private int undoCountPlayerA;
    private int undoCountPlayerB;
    private ArrayList<ActionListener> listeners;

    public MancalaModel(int stones){
        listeners = new ArrayList<ActionListener>();

        playerAPits = new int[7];
        playerBPits = new int[7];
        setNumStones(stones);

        mancalaA = 0;
        mancalaB = 0;
        playerAturn = true;   

        undoStack = new Stack<>();
        undoCount = 0; 
        undoCountPlayerA = 0;
        undoCountPlayerB = 0;
    }

    public void setNumStones(int stones){
        for(int i = 1; i < 7; i++){
            playerAPits[i] = stones;
            playerBPits[i] = stones;
        }
        for(ActionListener listener : listeners){
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "updateView"));
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "gameStart"));
        }
    }

    public void reset(){
        for(int i = 1; i < 7; i++){
            playerAPits[i] = 0;
            playerBPits[i] = 0;
        }
        mancalaA = 0;
        mancalaB = 0;
        playerAturn = true;
        while(!undoStack.isEmpty())
            undoStack.pop();
        undoCount = 0;
        undoCountPlayerA = 0;
        undoCountPlayerB = 0;
        for(ActionListener listener : listeners){
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "updateViewPlayAgain"));
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "playAgain"));
        }
    }

    public void saveState() {
        undoStack.push(new MancalaState(playerAPits.clone(), playerBPits.clone(), mancalaA, mancalaB, playerAturn));
    }

    public void undo() {
        if(undoCountPlayerA > 2 || undoCountPlayerB > 2)
            return;
        if (!undoStack.isEmpty() && undoCount < 1) {
            MancalaState prevState = undoStack.pop();
            playerAPits = prevState.getPlayerAPits();
            playerBPits = prevState.getPlayerBPits();
            mancalaA = prevState.getMancalaA();
            mancalaB = prevState.getMancalaB();
            playerAturn = prevState.getPlayerATurn();
            undoCount++;
            undoCountPlayerA++;
            undoCountPlayerB++;
            for (ActionListener listener : listeners) {
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "undoPits"));
            }
        }
    }

    public void addActionListener(ActionListener listener){
        listeners.add(listener);
    }

    public void removeActionListener(ActionListener listener){
        listeners.remove(listener);
    }

    public int[] getPlayerAPits(){
        return playerAPits;
    }
    
    public int[] getPlayerBPits(){
        return playerBPits;
    }

    public int getMancalaA(){
        return mancalaA;
    }

    public int getMancalaB(){
        return mancalaB;
    }

    // This method needs to be called in the controller to check whether if the buttons A[1] --> A[6] are clicked and isPlayerATurn == true.
    public boolean isPlayerAturn(){
        return playerAturn;
    }

    // User A clicks on the empty pit, the controller must do nothing. if(model.isPitEmpty(#) == false) return;
    public boolean isPitEmpty(int index){
        if(playerAturn){
            if(playerAPits[index] == 0)
                return true;
        }
        else{
            if(playerBPits[index] == 0)
                return true;
        }
        return false;
    }

    // This is a helper method for mutatePlayerBPits accessed by the MancalaController and MancalaView.
    public int oppositePit(int index){
        return 7 - index;
    }

    public void mutatePlayerAPits(int index){
        saveState();
        int stones = playerAPits[index];
        playerAPits[index] = 0;
        int currentIndex = index;
        while (stones > 0) {
            currentIndex++;
            
            if (currentIndex == 14)
                currentIndex = 1;

            if (currentIndex == 7)
                mancalaA++;

            if (currentIndex < 7) 
                playerAPits[currentIndex]++;
            else 
                playerBPits[currentIndex - 7]++;
            
            stones--;
        }

        if (currentIndex < 7 && playerAPits[currentIndex] == 1 && playerBPits[oppositePit(currentIndex)] > 0) {
            mancalaA += playerBPits[oppositePit(currentIndex)] + playerAPits[currentIndex];
            playerBPits[oppositePit(currentIndex)] = 0;
            playerAPits[currentIndex] = 0;
            playerAturn = false;
        } else if (currentIndex == 7) 
            playerAturn = true;
        else
            playerAturn = false;
        
        undoCount = 0;
        undoCountPlayerB = 0;
        for(ActionListener listener : listeners){
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "updateView"));
        }
    }

    public void mutatePlayerBPits(int index) {
        saveState();
        int stones = playerBPits[index];
        playerBPits[index] = 0;
        int currentIndex = index;
        while (stones > 0) {
            currentIndex++;
            
            if (currentIndex == 14) 
                currentIndex = 1;

            if (currentIndex == 7) 
                mancalaB++;

            if (currentIndex < 7) 
                playerBPits[currentIndex]++;
            else 
                playerAPits[currentIndex - 7]++;

            stones--;
        }

        if (currentIndex < 7 && playerBPits[currentIndex] == 1 && playerAPits[oppositePit(currentIndex)] > 0) {
            mancalaB += playerAPits[oppositePit(currentIndex)] + playerBPits[currentIndex];
            playerAPits[oppositePit(currentIndex)] = 0;
            playerBPits[currentIndex] = 0;
            playerAturn = true;
        } else if (currentIndex == 7) 
            playerAturn = false;
        else
            playerAturn = true;

        undoCount = 0;
        undoCountPlayerA = 0;
        for(ActionListener listener : listeners){
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "updateView"));
        }
    }

    public boolean checkEndGame(){
        if(isEmptyPlayerAPits() || isEmptyPlayerBPits())
            return true;
        return false;
    }

    // Call by checkEndGame
    public boolean isEmptyPlayerAPits(){
        for(int i = 1; i < 7; i++){
            if(playerAPits[i] != 0)
                return false;
        }
        return true;
    }

    // Call by checkEndGame
    public boolean isEmptyPlayerBPits(){
        for(int i = 1; i < 7; i++){
            if(playerBPits[i] != 0)
                return false;
        }
        return true;
    }

    public void checkWinner(){
        if(isEmptyPlayerAPits()){
            for(int i = 1; i < 7; i++){
                mancalaB += playerBPits[i];
                playerBPits[i] = 0;
            }
        } else if (isEmptyPlayerBPits()){
            for(int i = 1; i < 7; i++){
                mancalaA += playerAPits[i];
                playerAPits[i] = 0;
            }
        }
        for(ActionListener listener : listeners){
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "updateView"));
            if(mancalaA > mancalaB)
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "playerAWins"));
            else if(mancalaA < mancalaB)
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "playerBWins"));
            else 
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Tie"));
        }
    }
}

