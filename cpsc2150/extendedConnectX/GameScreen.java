package cpsc2150.extendedConnectX;

import java.time.temporal.TemporalAccessor;
import java.util.Scanner;

import javax.xml.transform.Templates;

import cpsc2150.extendedConnectX.models.*;

/**
 * This class will hold the GameScreen (basically the main)
 * It will call the other classes' functions to complete the logic
 * of a connect 4 game
 *
 * @author Nicholas Berns
 *
 * @invariant numRows = 9 AND numCols = 7
 *            board.length <= 9 AND board[].length <= 7
 *            there are no vertical gaps between placed tokens
 * @correspondence self = board
 *                 number_of_rows = numRows
 *                 number_of_cols = numCols
 */
public class GameScreen {

    /**
     * This is the main function for the full ConnectX program. It calls the necessary
     * classes, functions, etc to print out and execute a game of connect 4. It also
     * validates inputs to ensure tokens are valid
     */
    public static void main(String args[]){
        /**
         * First it initializes all the variables necessary for the ConnectX game
         * It then sets up the loops necessary to set up the game
         */
        Scanner scnr = new Scanner(System.in);
        int col = 0;
        char userOp;
        final int MIN = 3;
        final int MIN_NUM_PLAYERS = 2;
        final int MAX_NUM_PLAYERS = 10;
        final int MAX_COLUMNS = 100;
        final int MAX_ROWS = 100;
        int numPlayers;
        int numRows;
        int numColumns;
        int numToWin;
        String tempChoice;

        //int col = 0;
        //char option;
        char[] players = new char[10];
        //char player;
        //char prevPlayer;

        do {
            System.out.println("How many players?");
            tempChoice = scnr.nextLine();
            numPlayers = Integer.parseInt(tempChoice);

            while (numPlayers > MAX_NUM_PLAYERS) {
                System.out.println("Must be 10 players or fewer");
                System.out.println("How many players?");

                tempChoice = scnr.nextLine();
                numPlayers = Integer.parseInt(tempChoice);
            }

            while (numPlayers < MIN_NUM_PLAYERS) {
                System.out.println("Must be at least 2 players");
                System.out.println("How many players?");

                tempChoice = scnr.nextLine();
                numPlayers = Integer.parseInt(tempChoice);
            }

            for (int i = 1; i <= numPlayers; i++) {
                System.out.printf("Enter the character to represent player %d\n", i);
                tempChoice = scnr.nextLine();
                players[i - 1] = tempChoice.charAt(0);
            }

            System.out.println("How many rows should be on the board?");

            tempChoice = scnr.nextLine();

            numRows = Integer.parseInt(tempChoice);

            while (numRows > MAX_ROWS) {
                System.out.println("Must be 100 rows or fewer");

                System.out.println("How many rows should be on the board?");
                tempChoice = scnr.nextLine();
                numRows = Integer.parseInt(tempChoice);
            }

            while (numRows < MIN) {
                System.out.println("Must be at least 3 rows");
                System.out.println("How many rows should be on the board?");

                tempChoice = scnr.nextLine();
                numRows = Integer.parseInt(tempChoice);
            }

            System.out.println("How many columns should be on the board?");

            tempChoice = scnr.nextLine();

            numColumns = Integer.parseInt(tempChoice);

            while (numColumns > MAX_COLUMNS) {
                System.out.println("Must be 100 columns or fewer");
                System.out.println("How many columns should be on the board?");

                tempChoice = scnr.nextLine();
                numColumns = Integer.parseInt(tempChoice);
            }

            while (numColumns < MIN) {
                System.out.println("Must be at least 3 columns");
                System.out.println("How many columns should be on the board?");

                tempChoice = scnr.nextLine();
                numColumns = Integer.parseInt(tempChoice);
            }

            System.out.println("How many in a row to win?");

            tempChoice = scnr.nextLine();

            numToWin = Integer.parseInt(tempChoice);

            while ((numToWin > numRows) || (numToWin > numColumns)) {
                System.out.println("Must be less than the number of rows or columns");
                System.out.println("How many in a row to win?");

                tempChoice = scnr.nextLine();
                numToWin = Integer.parseInt(tempChoice);
            }

            while (numToWin < MIN) {
                System.out.println("Must be at least 3 in a row");
                System.out.println("How many in a row to win?");

                tempChoice = scnr.nextLine();
                numToWin = Integer.parseInt(tempChoice);
            }
            
            tempChoice = null;
            //while ((tempChoice != "F") || (tempChoice != "f") || (tempChoice != "M") || (tempChoice != "m")) {
                System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                tempChoice = scnr.nextLine();
                System.out.println(tempChoice);
                tempChoice = null;
            //}
            // System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");

            // tempChoice = scnr.nextLine();

            // while ((tempChoice.charAt(0) == 'F') || (tempChoice.charAt(0) == 'f') || (tempChoice.charAt(0) == 'M') || (tempChoice.charAt(0) == 'm')) {
            //     System.out.println("Please enter F or M");
            //     tempChoice = scnr.nextLine();
            // }

            do {

                //Create and print out game board
                GameBoard board = new GameBoard(numRows, numColumns, numToWin); //new gameboard called board
                System.out.println(board.toString()); //print new board as string
                char player = 'X'; //player is X
                char prevPlayer = 'X'; //previous player is X
                do {
                    do {
                        System.out.printf("Player " + player + ", what column do you want to place your marker in?\n"); //player selects location to drop token
                        col = scnr.nextInt(); //scan for location to drop token
                        //ensure that the token is valid
                        if (col >= board.getNumColumns())
                            System.out.println("Column cannot be greater than " + (board.getNumColumns() - 1));
                            //col can't be less than 0
                        else if (col < 0) System.out.println("Column cannot be less than 0");
                            //make sure col is not full
                        else if (!board.checkIfFree(col)) System.out.println("Column is full");
                    } while (col >= board.getNumColumns() || col < 0 || !board.checkIfFree(col));

                    //place token in board and prep next player
                    board.placeToken(player, col);
                    if (player == 'X') {
                        player = 'O';
                        prevPlayer = 'X';
                    }
                    //get set for next player
                    else {
                        player = 'X';
                        prevPlayer = 'O';
                    }

                    //print to string the updated board
                    System.out.println(board.toString());

                    //It if win, if not, run previous steps again
                } while (!board.checkForWin(col) && !board.checkTie());

                //Once win or tie occurs, print the result
                if (board.checkTie()) System.out.println("There was a Tie!");
                else if (board.checkForWin(col))
                System.out.println("Player " + prevPlayer + " Won!");

                do {
                    System.out.println("Would you like to play again? Y/N");
                    userOp = scnr.next().charAt(0);
                } while (userOp != 'y' && userOp != 'n');

            } while (userOp == 'y');
            //close scnr, program completeq
            scnr.close();

        } while (userOp == 'y');
        //close scnr, program completeq
        scnr.close();
    }
}
