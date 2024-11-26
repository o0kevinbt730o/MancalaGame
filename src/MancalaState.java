public class MancalaState {
    private int[] playerAPits;
    private int[] playerBPits;
    private int mancalaA;
    private int mancalaB;
    private boolean playerAturn;

    MancalaState(int[] APits, int[] BPits, int mancalaPlayerA, int mancalaPlayerB, boolean playerTurn) {
        playerAPits = APits;
        playerBPits = BPits;
        mancalaA = mancalaPlayerA;
        mancalaB = mancalaPlayerB;
        playerAturn = playerTurn;
    }
    
    public int[] getPlayerAPits() {
        return playerAPits;
    }

    public int[] getPlayerBPits() {
        return playerBPits;
    }

    public int getMancalaA() {
        return mancalaA;
    }

    public int getMancalaB() {
        return mancalaB;
    }

    public boolean getPlayerATurn() {
        return playerAturn;
    }
}