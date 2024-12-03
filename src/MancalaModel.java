import java.awt.event.*;
import java.util.*;
/**
 * @author Kevin Chau
 * @version 1.0
 * The MancalaModel class represents the state and behavior of a Mancala game.
 * It manages the pits, mancalas, player turns, and game state, and provides methods
 * for manipulating the game state and notifying listeners of changes.
 */
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

    /**
     * Constructs a MancalaModel with the specified number of stones in each pit.
     *
     * @param stones the number of stones to place in each pit at the start of the game
     */
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

    /**
     * Sets the number of stones in each pit for both players.
     * Initializes the pits for both Player A and Player B with the specified number of stones.
     * Notifies all registered listeners to update the view and indicate the start of the game.
     *
     * @param stones the number of stones to be placed in each pit
     */
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

    /**
     * Resets the game state to its initial conditions.
     * 
     * This method performs the following actions:
     * - Sets all pits for both players to 0.
     * - Sets both players' mancalas to 0.
     * - Sets the turn to player A.
     * - Clears the undo stack.
     * - Resets the undo counts for both players.
     * - Notifies all registered listeners to update the view and prepare for a new game.
     */
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

    /**
     * Saves the current state of the game to the undo stack.
     * This method creates a new instance of MancalaState with the current
     * state of the game, including the pits for both players, the mancala
     * stores, and the current player's turn, and pushes it onto the undo stack.
     */
    public void saveState() {
        undoStack.push(new MancalaState(playerAPits.clone(), playerBPits.clone(), mancalaA, mancalaB, playerAturn));
    }

    /**
     * Reverts the game state to the previous state if the undo conditions are met.
     * 
     * The method checks if the undo count for either player exceeds 2 or if the undo stack is empty.
     * If the conditions are met, it pops the previous state from the undo stack and restores the game state.
     * It then increments the undo counts for both players and notifies all registered listeners about the undo action.
     */
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

    /**
     * Adds an ActionListener to the list of listeners.
     *
     * @param listener the ActionListener to be added
     */
    public void addActionListener(ActionListener listener){
        listeners.add(listener);
    }

    /**
     * Removes the specified ActionListener from the list of listeners.
     *
     * @param listener the ActionListener to be removed
     */
    public void removeActionListener(ActionListener listener){
        listeners.remove(listener);
    }

    /**
     * Retrieves the array representing the pits for Player A.
     *
     * @return an array of integers where each element represents the number of stones in a pit for Player A.
     */
    public int[] getPlayerAPits(){
        return playerAPits;
    }
    
    /**
     * Retrieves the array of pits for player B.
     *
     * @return an array of integers representing the pits for player B.
     */
    public int[] getPlayerBPits(){
        return playerBPits;
    }

    /**
     * Returns the number of stones in Mancala A.
     *
     * @return the number of stones in Mancala A
     */
    public int getMancalaA(){
        return mancalaA;
    }

    /**
     * Returns the number of stones in Mancala B.
     *
     * @return the number of stones in Mancala B
     */
    public int getMancalaB(){
        return mancalaB;
    }

    /**
     * Checks if it is currently player A's turn.
     * 
     * @return true if it is player A's turn, false otherwise.
     */
    public boolean isPlayerAturn(){
        return playerAturn;
    }

    /**
     * Checks if the specified pit is empty for the current player.
     * 
     * @param index the index of the pit to check
     * @return true if the specified pit is empty, false otherwise
     */
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

    /**
     * This is a helper method for mutatePlayerBPits accessed by the MancalaController and MancalaView.
     * Returns the index of the pit directly opposite to the given pit index.
     * 
     * @param index the index of the pit for which the opposite pit index is to be found
     * @return the index of the pit directly opposite to the given pit index
     */
    public int oppositePit(int index){
        return 7 - index;
    }

    /**
     * Mutates the pits for player A by distributing stones from the specified pit index.
     * 
     * This method performs the following steps:
     * 1. Saves the current state.
     * 2. Retrieves the number of stones from the specified pit and sets that pit to 0.
     * 3. Distributes the stones to subsequent pits, including the player's Mancala.
     * 4. Handles capturing of opponent's stones if the last stone lands in an empty pit on the player's side.
     * 5. Determines if the player's turn continues based on the final pit.
     * 6. Resets undo counts for both players.
     * 7. Notifies listeners to update the view.
     * 
     * @param index the index of the pit from which to start distributing stones
     */
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

    /**
     * Mutates the pits for player B by distributing stones from the specified pit index.
     * 
     * This method performs the following steps:
     * 1. Saves the current state.
     * 2. Retrieves the number of stones from the specified pit and sets that pit to 0.
     * 3. Distributes the stones to subsequent pits, including the player's Mancala.
     * 4. Handles capturing of opponent's stones if the last stone lands in an empty pit on the player's side.
     * 5. Determines if the player's turn continues based on the final pit.
     * 6. Resets undo counts for both players.
     * 7. Notifies listeners to update the view.
     * 
     * @param index the index of the pit from which to start distributing stones
     */
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

    /**
     * Checks if the game has ended by determining if either player A's or player B's pits are empty.
     *
     * @return true if either player A's or player B's pits are empty, indicating the end of the game; false otherwise.
     */
    public boolean checkEndGame(){
        if(isEmptyPlayerAPits() || isEmptyPlayerBPits())
            return true;
        return false;
    }

    /**
     * Checks if all pits for player A are empty.
     *
     * This method iterates through the pits for player A
     * and checks if any of them contain stones. If any pit contains stones, it returns false.
     * If all pits are empty, it returns true.
     *
     * @return true if all pits for player A are empty, false otherwise.
     */
    public boolean isEmptyPlayerAPits(){
        for(int i = 1; i < 7; i++){
            if(playerAPits[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * Checks if all pits for player B are empty.
     *
     * This method iterates through the pits for player B
     * and checks if any of them contain stones. If any pit contains stones, it returns false.
     * If all pits are empty, it returns true.
     *
     * @return true if all pits for player A are empty, false otherwise.
     */
    public boolean isEmptyPlayerBPits(){
        for(int i = 1; i < 7; i++){
            if(playerBPits[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * This method is to check for the winner of the Mancala game.
     * If player A's pits are empty, all stones from player B's pits are moved to player B's Mancala.
     * If player B's pits are empty, all stones from player A's pits are moved to player A's Mancala.
     * Notifies all registered listeners to update the view.
     * Determines the winner based on the number of stones in each player's Mancala and notifies listeners:
     * - "playerAWins" if player A has more stones
     * - "playerBWins" if player B has more stones
     * - "Tie" if both players have the same number of stones
     */
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

