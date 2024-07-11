package cpsc2150.extendedConnectX.models;

/**
 * This class will hold the board of connect 4
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
public class GameBoard extends AbsGameBoard implements IGameBoard {
    private char[][] board;
    private static int NUM_ROWS;
    private static int NUM_COLS;
    private static int NUM_WIN;
    /**
     * The constructor initializes private members, creating a board
     *
     * @pre NONE
     * @post board created that is numRows tall and numCols wide. 
     *       numRows = 9 AND numCols = 7
     *       AND assign board numRows and numCols
     */
    public GameBoard(int inputRows, int inputCols, int inputNumToWin) {
        NUM_ROWS = inputRows;
        NUM_COLS = inputCols;
        NUM_WIN = inputNumToWin;
        board = new char[NUM_ROWS][NUM_COLS];
        //the first for loop intializes the rows
        for(int row = 0; row < NUM_ROWS; row++){
            //the second for loops intializes the cols, all to ' ' for now.
            for(int col = 0; col < NUM_COLS; col++){
                board[row][col] = ' ';
            }
        }
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
        int pos = 0;

        while (board[pos][c] != ' ') {
            pos++;
        }

        board[pos][c] = p;
    }

    /**
     * whatsAtPos returns whatever character is currently at a given
     * BoardPosition pos from cpsc2150.extendedConnectX.models.BoardPosition
     *
     * @param pos is a cpsc2150.extendedConnectX.models.BoardPosition
     * @return The character that at pos (cpsc2150.extendedConnectX.models.BoardPosition)
     *
     * @pre 0 {@code <=} pos row {@code <=} 8 AND 0 {@code <=} pos column {@code <=} 6
     * @post return the character that at pos (cpsc2150.extendedConnectX.models.BoardPosition)
     *       pos = #pos AND numRows = #numRows AND numCols = #numCols AND board = #board
     */
    public char whatsAtPos(BoardPosition pos) {
        //create and get row and column. assign that to player and return the player
        int row = pos.getRow();
        int col = pos.getCol();

        char player = board[row][col];
        
        return player;
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
        return (whatsAtPos(pos) == player);
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
    public int getNumRows(){
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
    public int getNumToWin(){
        return NUM_WIN;
    }
}
