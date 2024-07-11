package cpsc2150.extendedConnectX.models;
/**
 * This is the abstract class for GameBoard and holds toString
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
public abstract class AbsGameBoard implements IGameBoard {
    /**
     * ToString returns a string that shows the whole game board
     *
     * @return A string that of the whole board
     *
     * @pre NONE
     * @post returns game board content in string format 
     *       numRows = #numRows AND numCols = #numCols AND board = #board
     */
    @Override
    public String toString() {
        //using temp, get num of cols and rows and turn the game into a string
        String game = "|";
        for (int temp = 0; temp < getNumColumns(); temp++) {

            game = game + temp + "|";
        }

        game = game + "\n";

        for (int row = getNumRows()-1; row >= 0; row--) {

            game = game + "|";
            //for is for rows and cols
            for (int col = 0; col < getNumColumns(); col++) {
                game = game + whatsAtPos(new BoardPosition(row, col)) + "|";
            }

            game = game + "\n";
        }
        return game;
    }
}
