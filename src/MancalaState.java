/**
 * @author Kevin Chau
 * @version 1.0
 * The MancalaState class represents the state of a Mancala game.
 * It holds the number of stones in each player's pits and their respective Mancalas,
 * as well as whose turn it is to play.
 */
public class MancalaState {
    private int[] playerAPits;
    private int[] playerBPits;
    private int mancalaA;
    private int mancalaB;
    private boolean playerAturn;

    /**
     * Constructs a new MancalaState with the specified parameters.
     *
     * @param APits an array representing the pits of player A
     * @param BPits an array representing the pits of player B
     * @param mancalaPlayerA the number of stones in player A's mancala
     * @param mancalaPlayerB the number of stones in player B's mancala
     * @param playerTurn a boolean indicating if it is player A's turn (true if it is player A's turn, false if it is player B's turn)
     */
    MancalaState(int[] APits, int[] BPits, int mancalaPlayerA, int mancalaPlayerB, boolean playerTurn) {
        playerAPits = APits;
        playerBPits = BPits;
        mancalaA = mancalaPlayerA;
        mancalaB = mancalaPlayerB;
        playerAturn = playerTurn;
    }
    
    /**
     * Returns the array representing the pits of Player A.
     *
     * @return an array of integers where each element represents the number of stones in a pit for Player A.
     */
    public int[] getPlayerAPits() {
        return playerAPits;
    }

    /**
     * Returns the array of pits for player B.
     *
     * @return an array of integers representing the pits for player B.
     */
    public int[] getPlayerBPits() {
        return playerBPits;
    }

    /**
     * Returns the number of stones in Mancala A.
     *
     * @return the number of stones in Mancala A
     */
    public int getMancalaA() {
        return mancalaA;
    }

    /**
     * Returns the number of stones in player B's Mancala.
     *
     * @return the number of stones in player B's Mancala.
     */
    public int getMancalaB() {
        return mancalaB;
    }

    /**
     * Returns the current turn status of player A.
     *
     * @return true if it is player A's turn, false otherwise.
     */
    public boolean getPlayerATurn() {
        return playerAturn;
    }
}