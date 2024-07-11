package cpsc2150.extendedConnectX.models;

/**
 * cpsc2150.extendedConnectX.models.BoardPosition class
 *
 * <p>This class keeps track of a cell on the connect four board.</p>
 * <p>cpsc2150.extendedConnectX.models.BoardPosition will have variables that hold the rows and columns.</p>
 * <p>A constructor will take in an int for row and an int for column as parameters.</p>
 * <p>There is only one constructor, and after is is called there will be no change</p>
 * <p>through modifier methods like setters.</p>
 *
 * @author Nicholas Berns
 * @version 1.0
 *
 * @invariant
 *      row {@code >=} 0 AND col {@code >=} 0
 */
public class BoardPosition {
    private int row;
    private int col;

    /**
     * Constructor for cpsc2150.extendedConnectX.models.BoardPosition that initializes row and col size
     * @param rowParam row value being passed in
     * @param colParam column value being passed in
     *
     * @pre rowParam {@code >=} 0 AND rowParam {@code <=} 8 AND
     *      colParam {@code >=} 0 AND colParam {@code <=} 6
     *
     * @post row = rowParam AND col = colParam
     */
    public BoardPosition (int rowParam, int colParam) {
        row = rowParam;
        col = colParam;
    }

    /**
     * getRow gets the row and returns it as an int
     *
     * @return row value
     *
     * @post row = #row
     *       col = #col 
     *       getRow = row
     */
    public int getRow(){
        return row;
    }

    /**
     * getCol gets the column and returns it as an int
     *
     * @return col value
     *
     * @post col = #col
     *       row = #row
     *       getCol = col
     */
    public int getCol(){
        return col;
    }

    /**
     * This method overwrites the .equals() method that is originally inherited from the Object class.
     * The new overridden method is true when two board positions have
     * the same row and column.
     *
     * @param board compares to another cpsc2150.extendedConnectX.models.BoardPosition to check if they're equal
     *
     * @return true if BoardPositions are equal, false if not
     *
     * @pre board.row {@code >=} 0 AND board.col {@code >=} 0
     *
     * @post true iff (board.row = #row AND board.col = #col) and false iff (board.row != #row OR board.col != #col).
     */
    @Override
    public boolean equals(Object board) {
        if (!(board instanceof BoardPosition))
        return false;
        BoardPosition temp = (BoardPosition) board;
        if (row == temp.getRow()){
            if(col == temp.getCol())
                return true;
        }
        return false;
    }

    /**
     * This method overwrites the .toString() method that is originally inherited from the Object class.
     * The new overridden method creates a string in the format: "<row>,<column>." Example provided: "3,5"
     *
     * @return String formatted "row, col"
     *
     * @post row = #row AND col = #col
     */
    @Override
     public String toString() {
        String temp = row + "," + col;
        return temp;
     }
}
