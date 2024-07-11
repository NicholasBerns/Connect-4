package cpsc2150.extendedConnectX.models;
/**
 * This is the interface class for GameBoard and holds the secondary methods
 * as well as the prototypes for the other methods in GameBoard
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
public interface IGameBoard {

    /**
     * checkIfFree checks to see if a column is available to place a token in.
     *
     * @param c is the selected column
     * @return True if the column has empty spaces, false if it is full.
     *
     * @pre 0 {@code <=} c {@code <} numCols
     * @post return true if the column has empty spaces, false if it is full.
     *       numRows = #numRows AND numCols = #numCols AND c = #c AND board = #board
     */
    public default boolean checkIfFree(int c) {
        BoardPosition board = new BoardPosition(getNumRows()-1, c);
        if(whatsAtPos(board) == ' ') {
            return true;
        }
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
    public void placeToken(char p, int c);

    /**
     * checkIfWin checks to see if that last placed token results in 5 in a row, meaning there is a win
     *
     * @param c is a column on the board
     * @return True if the last token placed causes a continuous line of 5 "p" tokens, and return false if not.
     *
     * @pre 0 {@code <=} c {@code <=} 6 && [c is the col where the last token was placed]
     * @post return true if the last token placed causes a continuous line of 5 "p" tokens in either a diagonal, horizontal,
     *       or vertical direction. return false if not.
     *       c = #c AND numRows = #numRows AND numCols = #numCols AND board = #board
     */
    default public boolean checkForWin(int c) {
        int position = getNumRows()-1;
        BoardPosition winning = new BoardPosition(position, c);
        while(whatsAtPos(winning) == ' ') {
            position--;
            winning = new BoardPosition(position, c);
        }
        //uses whatsatpos to check for winning
        char player = whatsAtPos(winning);
        if((checkHorizWin(winning, player)) || (checkVertWin(winning, player)) || (checkDiagWin(winning, player))) {
            return true;
        }
        return false;
    }

    /**
     * checkTie checks if the board is full and checkForWin is false, if so, then checkTie is true.
     *
     * @return True if the board is full and checkForWin is false, otherwise checkTie is false.
     *
     * @pre checkForWin() = false
     * @post return true if the board is full and checkForWin is false, otherwise checkTie is false.
     *       numRows = #numRows AND numCols = #numCols AND board = #board
     */
    public default boolean checkTie() {
        for(int i = 0; i < getNumColumns(); i++) {

            if(checkIfFree(i)) {
                return false;
            }

        }
        return true;
    }

    /**
     * checkHorizWin checks to see if the last token placed results in 5 horizontal tokens in a row,
     * returns true if so.
     *
     * @param pos is a board position from cpsc2150.extendedConnectX.models.BoardPosition
     * @param p is a player token (either "X" or "O")
     * @return True if the last placed token results in 5 horizontal "p" tokens in a row, false if not.
     *
     * @pre p = 'X' or 'O' AND 0 {@code <=} pos row {@code <=} 8 AND 0 {@code <=} pos column {@code <=} 6
     *      pos = [the board position of the latest play therefore the marker at that position]
     * @post return true if last placed token results in 5 "p" tokens in a row horizontally
     *       pos = #pos AND p = #p AND numRows = #numRows AND numCols = #numCols AND board = #bound
     */
    public default boolean checkHorizWin(BoardPosition pos, char p) {
        int row = pos.getRow();
        int col = 0;
        int winCount = 0;
        BoardPosition tempPosition = new BoardPosition(row, col);
        //while col is less than get num cols, keep checking for horizontal wins
        while(col < getNumColumns()) {
            //if temp position = p, increase win count
            if(whatsAtPos(tempPosition) != p) winCount = 0;
            else winCount++;
            if(winCount >= getNumToWin()) return true;

            col++;
            tempPosition = new BoardPosition(row, col);
        }
        return false;
    }

    /**
     * checkVertWin checks to see if the last token placed results in 5 vertical tokens in a column,
     * returns true if so.
     *
     * @param pos is a board position from cpsc2150.extendedConnectX.models.BoardPosition
     * @param p is a player token (either "X" or "O")
     * @return True if the last placed token results in 5 vertical "p" tokens in a column, false if not.
     *
     * @pre p = 'X' or 'O' AND 0 {@code <=} pos row {@code <=} 8 AND 0 {@code <=} pos column {@code <=} 6
     *      pos = [the board position of the latest play therefore the marker at that position]
     * @post return true if the last placed token results in 5 vertical "p" tokens in a column, false if not.
     *       pos = #pos AND p = #p AND numRows = #numRows AND numCols = #numCols AND board = #board
     */
    public default boolean checkVertWin(BoardPosition pos, char p) {
        int row = 0;
        int col = pos.getCol();
        int winCount = 0;
        BoardPosition tempPosition = new BoardPosition(row, col);
        //while row is less than get num rows, keep looping, looking for vert win
        while(row < getNumRows()) {
            //if whats at pos for temp position = p, increase wincount
            if(whatsAtPos(tempPosition) != p) winCount = 0;
            else winCount++;
            if(winCount >= getNumToWin()) return true;

            row++;
            tempPosition = new BoardPosition(row, col);
        }
        return false;
    }

    /**
     * checkDiagWin checks to see if the last token placed results in 5 diagonal tokens in a diagonal left or right,
     * returns true if so, false if not.
     *
     * @param pos is a board position from cpsc2150.extendedConnectX.models.BoardPosition
     * @param p is a player token (either "X" or "O")
     * @return True if the last placed token results in 5 vertical "p" tokens in a column, false if not.
     *
     * @pre p = 'X' or 'O' AND 0 {@code <=} pos row {@code <=} 8 AND 0 {@code <=} pos column {@code <=} 6
     *      pos = [the board position of the latest play therefore the marker at that position]
     * @post True if the last placed token results in 5 diagonal "p" tokens in a diagonal left or right, false if not.
     *       pos = #pos AND p = #p AND numRows = #numRows AND numCols = #numCols AND board = #board
     */
    public default boolean checkDiagWin(BoardPosition pos, char p) {
        int winCount = 0;
        int col;
        int row;
        BoardPosition tempPosition = new BoardPosition(pos.getRow(), pos.getCol());
        for (col = pos.getCol(), row = pos.getRow(); col >= 0 && row >= 0; col--, row--){}
        //while col and row are less than the get nums, keep looking for diag win
        while((col < getNumColumns()) && (row < getNumRows())) {
            //if whats at pos for temp position is p, increase win count
            if(whatsAtPos(tempPosition) != p) winCount = 0;
            else winCount++;
            if(winCount > getNumToWin()) return true;

            col++;
            row++;
            tempPosition = new BoardPosition(row, col);
        }
        tempPosition = new BoardPosition(pos.getRow(), pos.getCol());
        winCount = 0;
        for (col = pos.getCol(), row = pos.getRow(); col < getNumColumns() && row >= 0; col++, row--){}
        while(col >= 0 && row < getNumRows()) {
            //if whats at pos for temp position is p, increase win count
            if(whatsAtPos(tempPosition) != p) winCount = 0;
            else winCount++;
            if(winCount > getNumToWin())return true;

            col--;
            row++;
            tempPosition = new BoardPosition(row, col);
        }
        return false;
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
    public char whatsAtPos(BoardPosition pos);
    
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
    public default boolean isPlayerAtPos(BoardPosition pos, char player) {
        return (whatsAtPos(pos) == player);
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
    public int getNumRows();

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
    public int getNumColumns();

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
    public int getNumToWin();
}