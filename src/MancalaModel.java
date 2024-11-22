import java.awt.event.*;
import java.util.*;
public class MancalaModel{
    private int[] playerAPits;
    private int[] playerBPits;
    private int mancalaA;
    private int mancalaB;
    boolean playerAturn;
    private ArrayList<ActionListener> listeners;

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
        listeners = new ArrayList<ActionListener>();
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

    // This is a helper method for mutatePlayerAPits and mutatePlayerBPits to calculate the opposite pit.
    private int oppositePit(int index){
        return 7 - index;
    }

    public void mutatePlayerAPits(int index){
        int stones = playerAPits[index];
        playerAPits[index] = 0;
        int i = index + 1;
        while(stones > 0){
            for (int j = i; j <= 7; j++){
                if(j == 7 && stones != 0){
                    mancalaA++;
                    stones--;
                    playerAturn = false;
                    break;
                }
                if(stones == 0){
                    if(j < 7){
                        if(playerAPits[j] == 1 && playerBPits[oppositePit(j)] != 0){
                            mancalaA += playerBPits[oppositePit(j)] + playerAPits[j];
                            playerBPits[oppositePit(j)] = 0;
                            playerAPits[j] = 0;
                        }
                    } else if (j == 7){
                        mancalaA++;
                        break;
                    }
                    playerAturn = false;
                    break;
                }
                playerAPits[j]++;
                stones--;
            }
            // This if statement is to account for when stones == 0 and the last stone is placed in the mancala so the player gets another turn. This corresponds with the stones == 0 and j == 7 condition in the for loop above.
            if (playerAturn && stones == 0){
                break;
            }

            //i = 1;
            for(int j = 6; j >= 1; j--){
                if(stones == 0){
                    playerAturn = false;
                    break;
                }
                playerBPits[j]++;
                stones--;
            }
            i = 1;
        }
    }

    public void mutatePlayerBPits(int index){
        index = oppositePit(index);
        int stones = playerBPits[index];
        playerBPits[index] = 0;
        int i = index - 1; //look at this index
        while(stones > 0){
            for (int j = i; j+1 > 0; j--){ //look at this index
                if(j == 0 && stones != 0){
                    mancalaB++;
                    stones--;
                    playerAturn = true;
                    System.out.println("I'm here 129");
                    break;
                }
                if(stones == 0){
                    if(j > 0){
                        if(playerBPits[j] == 1 && playerAPits[oppositePit(j)] != 0){
                            mancalaB += playerBPits[j] + playerAPits[oppositePit(j)];
                            playerBPits[j] = 0;
                            playerAPits[oppositePit(j)] = 0;
                        }
                    } else if (j == 0){
                        mancalaB++;
                        System.out.println("I'm here 141");
                        break;
                    }
                    System.out.println("I'm here 143");
                    playerAturn = true;
                    break;
                }
                playerBPits[j]++;
                stones--;
            }
            // This if statement is to account for when stones == 0 and the last stone is placed in the mancala so the player gets another turn. This corresponds with the stones == 0 and j == 7 condition in the for loop above.
            if (!playerAturn && stones == 0){
                break;
            }

            //i = 1;
            for(int j = 1; j < 7; j++){
                if(stones == 0){
                    System.out.println("I'm here 158");
                    playerAturn = true;
                    break;
                }
                playerAPits[j]++;
                stones--;
            }
            i = 1;
        }

        for(ActionListener listener : listeners){
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "updatePits"));
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

    public String checkWinner(){
        if(mancalaA > mancalaB)
            return "Player A wins!";
        if(mancalaA < mancalaB)
            return "Player B wins!";
        return "It's a tie!";
    }

    // ------------------- For Testing -------------------
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

    public void testEmptyAndWin(){
        for (int i = 1; i < 7; i++){
            playerAPits[i] = 0;
            playerBPits[i] = 0;
        }
    }


    public static void main(String[] args) {
        MancalaModel model = new MancalaModel(4);
        int command = 1;
        model.print();
        //System.out.println("" + model.isEmptyPlayerAPits() + " " + model.isEmptyPlayerBPits() + " " + model.checkEndGame());
        if(model.isPlayerAturn()) {
            System.out.println("command" + command++);

            model.mutatePlayerAPits(4);
            model.print();
            // model.mutatePlayerAPits(2);
            // model.print();
            // model.mutatePlayerAPits(6);
            // model.print();
            
        } 
        
        if(!model.isPlayerAturn()) {
            System.out.println("command" + command++);

            model.mutatePlayerBPits(1);
            model.print();
        }

        if(model.isPlayerAturn()) {
            System.out.println("command" + command++);

            model.mutatePlayerAPits(3);
            model.print();
        }
    }
}