package cpsc2150.extendedConnectX.models;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class GameBoardMem extends AbsGameBoard implements IGameBoard{
    private int NUM_ROWS;
    private int NUM_COLS;
    private int NUM_WIN;
    private Map<Character, List<BoardPosition>> board;
    /**
     * Constructor: Initialize private members
     *
     * @pre 3 {@code <=} numRows {@code <=} 100 AND 3 {@code <=} numColumns {@code <=} 100 AND
     *      3 {@code <=} numToWin {@code <=} numRows OR numColumns
     * @post [board is a map] AND [assign board numRows and numColumns]
     */
    public GameBoardMem(int numRows, int numColumns, int numToWin) {
        NUM_ROWS = numRows;
        NUM_COLS = numColumns;
        NUM_WIN = numToWin;

        board = new HashMap<>();
    }

    /**
     * This functions returns max num of cols in game board.
     *
     * @return max num of cols for gameboard
     *
     * @pre None
     * @post board = #board AND
     *       NUM_COLS = #NUM_COLS AND
     *       getNumColumns = NUM_COLS
     */
    public int getNumColumns() {
        return NUM_COLS;
    }

    /**
     * This functions returns max num of rows in game board.
     *
     * @return max num of rows for gameboard
     *
     * @pre None
     * @post board = #board AND
     *       NUM_ROWS = #NUM_ROWS AND
     *       getNumRows = NUM_ROWS
     */
    public int getNumRows() {
        return NUM_ROWS;
    }

    /**
     * This functions returns num of tokens in a row for win in game board.
     *
     * @return num of tokens in a row for a win for gameboard
     *
     * @pre None
     * @post board = #board AND
     *       NUM_WIN = #NUM_WIN AND
     *       getNumWin = NUM_WIN
     */
    public int getNumToWin() {
        return NUM_WIN;
    }

    /**
     * whatsAtPos returns whatever character is currently at a given
     * BoardPosition pos from cpsc2150.extendedConnectX.models.BoardPosition
     * using a map.
     *
     * @param pos is a cpsc2150.extendedConnectX.models.BoardPosition
     * @return The character that at pos (cpsc2150.extendedConnectX.models.BoardPosition)
     *
     * @pre 0 {@code <=} pos row {@code <=} 8 AND 0 {@code <=} pos column {@code <=} 6
     * @post return the character that at pos (cpsc2150.extendedConnectX.models.BoardPosition)
     *       pos = #pos AND numRows = #numRows AND numCols = #numCols AND board = #board
     */
    public char whatsAtPos(BoardPosition pos) {
        char token = ' ';

        // First enhanced for loop enters a map by creating an iterator i of the map type
        // and looping through it.
        for (Map.Entry<Character, List<BoardPosition>> i: board.entrySet()) {
            // Second enchanced for loop iterates through the board positions (mapped values)
            // looking for the matching value for the token that its searching for.
            // That matching value is the key which will be returned as token.
            for(BoardPosition j: i.getValue()) {
                if (pos.equals(j)) token = i.getKey();
            }
        }

        return token;
    }

    /**
     * isPlayerAtPos checks to see if player char is at pos, returns true if yes and false if not.
     *
     * @param pos is a cpsc2150.extendedConnectX.models.BoardPosition
     * @param player is a char
     * @return True if "player" character is at pos, false if not.
     *
     * @pre player = 'X' or 'O' AND 0 {@code <=} pos row {@code <=} 8 AND 0 {@code <=} pos columns {@code <=} 6
     * @post return true if "player" character is at pos, false if not.
     *       pos = #pos AND player = #player AND numRows = #numRows AND numCols = #numCols AND board = #board
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player) {
        return false;
    }
    /**
     * placeToken takes "p" (player token) and places it in "c" (column)
     *
     * @param p is the player token which is either 'X' or 'O'
     * @param c is the column number where the token will be placed
     *
     * @pre p = 'X' OR p = 'O' AND (numCols-numCol) {@code <=} c {@code <=} (numCols)
     * @post p = #p AND c = #c AND numRows = #numRows AND numCols = #numCols and the token will go in the
     *       lowest available spot in the selected column
     */
    public void placeToken(char p, int c) {
        int i = 0;
        if(!board.containsKey(p)) {
            board.put(p, new ArrayList<BoardPosition>());
        }

        List<BoardPosition> temp = board.get(p);
        
        BoardPosition playerToken = new BoardPosition(i, c);

        while(whatsAtPos(playerToken) != ' ') {
            i++;
            playerToken = new BoardPosition(i, c);
        }

        temp.add(playerToken);

        board.remove(p);

        board.put(p, temp);
    }
}