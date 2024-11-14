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

    public void mutatePlayerAPits(int index){
        int stones = playerAPits[index];
        playerAPits[index] = 0;
        // for(int i = index + 1; i <= 7; i++){
        //     if(i == 7 && stones != 0){
        //         mancalaA++;
        //         stones--;
        //         break;
        //     }
        //     if(stones == 0){
        //         if(i == 7){
        //             playerAturn = true;
        //         }
        //         else{
        //             if(playerAPits[i] == 1 && playerBPits[i] != 0){
        //                 mancalaA += playerBPits[i] + playerAPits[i];
        //                 playerBPits[i] = 0;
        //                 playerAPits[i] = 0;
        //             }
        //             playerAturn = false;
        //         }
        //         break;
        //     }
        //     playerAPits[i]++;
        //     stones--;
        // }
        int i = index + 1;
        while(stones > 0){
            for (int j = i; j <= 7; j++){
                if(j == 7 && stones != 0){
                    mancalaA++;
                    stones--;
                    break;
                }
                if(stones == 0){
                    if(j < 7){
                        if(playerAPits[j] == 1 && playerBPits[j] != 0){
                            mancalaA += playerBPits[j] + playerAPits[j];
                            playerBPits[j] = 0;
                            playerAPits[j] = 0;
                        }
                    }
                    playerAturn = false;
                    break;
                }
                playerAPits[j]++;
                stones--;
            }
            i = 1;
            for(int j = i; j < 6; j++){
                if(stones == 0)
                    break;
                playerBPits[j]++;
                stones--;
            }
            i = 1;
        }
    }

    public void mutatePlayerBPits(int index){
        int stones = playerBPits[index];
        playerBPits[index] = 0;
        int i = index + 1;
        while(stones > 0){
            for (int j = i; j <= 7; j++){
                if(j == 7 && stones != 0){
                    mancalaB++;
                    stones--;
                    break;
                }
                if(stones == 0){
                    if(j < 7){
                        if(playerBPits[j] == 1 && playerAPits[j] != 0){
                            mancalaB += playerBPits[j] + playerAPits[j];
                            playerBPits[j] = 0;
                            playerAPits[j] = 0;
                        }
                    }
                    playerAturn = true;
                    break;
                }
                playerBPits[j]++;
                stones--;
            }
            i = 1;
            for(int j = i; j < 6; j++){
                if(stones == 0)
                    break;
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

    public boolean isEmptyPlayerAPits(){
        for(int i = 1; i < 7; i++){
            if(playerAPits[i] != 0)
                return false;
        }
        return true;
    }

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
        model.print();
        //System.out.println("" + model.isEmptyPlayerAPits() + " " + model.isEmptyPlayerBPits() + " " + model.checkEndGame());
        if(model.isPlayerAturn()) {
            if(model.isPitEmpty(2))
                return;
            model.mutatePlayerAPits(1);
            model.print();
            model.mutatePlayerAPits(2);
            model.print();
            model.mutatePlayerAPits(6);
            model.print();
        } 
        // if(!model.isPlayerAturn()) {
        //     if(model.isPitEmpty(1))
        //         return;
        //     //model.mutatePlayerBPits(1);
        //     model.print();
        // }
    }
}