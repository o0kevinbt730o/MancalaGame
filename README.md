# CS151 Project 
## Purpose of Project
Design a Mancala Game using GUI and pattern practices in Java.
## Game Description
This game is for two human players. (No computer player is considered in this project. Two players will take a turn to play this game using one mouse.) Initially, the program displays an empty board, then asks the player to enter the number of stones that will be placed in each pit. For example, when the user enters 3, 3 stones will be places in each pit of the board. The two Mancala will be still empty. (Two players will agree on this number and one of the player will enter the number.) Let's make the maximum number of stones per pit is 4. That is, at the beginning the player can enter 3 or 4 for the number of stones/per pit.

A player selects a pit by clicking the mouse on the pit Then, the program updates the board according to the game rule explained above.

The program offers a undo function for the player. Before the other player takes a turn, the current player can undo what he has just selected. The state of the board is going back to the state before the player makes a selection of a pit. The player is not allowed to make multiple undo in a row. For example, suppose the player A selected the pit A1. As a result, the state of the board will change accordingly. If this player undo, the state of the board goes back to its previous state. The players then can not undo again and has to make a choice of a pit.

The player is allowed to undo again after making a choice. The player can make undo at most 3 times at his turn.
## Game Rules
One player starts the game by picking up all of the stones in any one of his own pits. Moving counter-clock wise, the player places one in each pit starting with the next pit until the stones run out. If you run into your own Mancala, place one stone in it. If there are more stones to go past your own Mancala, continue placing them into the opponent's pits. However, skip your opponent's Mancala. If the last stone you drop is your own Mancala, you get a free turn . If the last stone you drop is in an empty pit on your side, you get to take that stone and all of your opponents stones that are in the opposite pit. Place all captured stones in your own Mancala. The game ends when all six pits on one side of the Mancala board are empty. The player who still has stones on his side of the board when the game ends captures all of those pieces and place them in his Mancala. The player who has the most stones in his Mancala wins.
## Running the Code
* Go into src directory.
* Compile the source code under src directory with JDK version 8 and above.
* Run the MancalaTest executable file or run the run.txt file.
    * Example:
        ```
        $ javac *.java
        $ java MancalaTest
        ```
    * Example:
        ```
        $ ./run.txt
        ```