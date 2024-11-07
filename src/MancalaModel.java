public class MancalaModel{
    private int[] playerAPits;
    private int[] playerBPits;
    private int mancalaA;
    private int mancalaB;
    boolean playerAturn;

    public MancalaModel(int stones){
        playerAPits = new int[7];
        playerBPits = new int[7];
        for(int i = 1; i < 7; i++){
            playerAPits[i] = stones;
            playerBPits[i] = stones;
        }
        mancalaA = 0;
        mancalaB = 0;
        playerAturn = true;    
    }

    public void print(){
        System.out.println("Player A: ");
        for(int i = 1; i < 7; i++){
            System.out.print(playerAPits[i] + " ");
        }
        System.out.println();
        System.out.println("Player B: ");
        for(int i = 1; i < 7; i++){
            System.out.print(playerBPits[i] + " ");
        }
        System.out.println();
        System.out.println("Mancala A: " + mancalaA);
        System.out.println("Mancala B: " + mancalaB);
    }


    public static void main(String[] args) {
        MancalaModel model = new MancalaModel(4);
        model.print();

    }
}