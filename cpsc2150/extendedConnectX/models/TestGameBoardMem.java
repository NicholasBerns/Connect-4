package cpsc2150.extendedConnectX.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameBoard {
    /*
    The first test case checks if the method
    returns true when a column is not full.
     */
    @Test
    public void checkIfFree_true_when_empty() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        int c = 2;
        boolean result = gb.checkIfFree(c);
        assertTrue(result);
    }


    /*
    The second test case checks if the method
    returns false when a column is full.
     */
    @Test
    public void checkIfFree_false_when_full() {
        IGameBoard gb = new GameBoard();
        for(int i = 0; i < 6; i++){
            gb.placeToken('X', 2);
        }
        int c = 2;
        boolean result = gb.checkIfFree(c);
        assertFalse(result);
    }

    /*
    The third test case checks if the method
    returns true when a column is partially full.
     */
    @Test
    public void checkIfFree_true_when_partially_full(){
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 3);
        int c = 3;
        boolean result = gb.checkIfFree(c);
        assertTrue(result);
    }

    /*
    The first test case checks if the method returns true when
    there are five 'X' tokens in a row horizontally.
     */
    @Test
    public void checkHorizWin_five_X_tokens_in_a_row() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        BoardPosition pos = new BoardPosition(4, 4);
        char p = 'X';
        boolean result = gb.checkHorizWin(pos, p);
        assertTrue(result);
    }

    /*
    The second test case checks if the method returns false when there are not
    enough 'X' tokens in a row horizontally.
     */
    @Test
    public void checkHorizWin_not_enough_X_tokens_in_a_row() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        BoardPosition pos = new BoardPosition(2, 3);
        char p = 'X';
        boolean result = gb.checkHorizWin(pos, p);
        assertFalse(result);
    }

    /*
    The third test case checks if the method returns false when the last token placed does
    not result in five horizontal tokens in a row.
     */
    @Test
    public void checkHorizWin_last_token_not_five_in_a_row() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        BoardPosition pos = new BoardPosition(4, 4);
        char p = 'X';
        boolean result = gb.checkHorizWin(pos, p);
        assertFalse(result);
    }

    /*
    The fourth test case checks if the method returns true when the last token placed
    results in exactly five horizontal tokens in a row.
     */
    @Test
    public void checkHorizWin_exactly_five_in_a_row() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 5);
        gb.placeToken('X', 5);
        BoardPosition pos = new BoardPosition(5, 5);
        char p = 'X';
        boolean result = gb.checkHorizWin(pos, p);
        assertTrue(result);
    }

    /*
    The first test case checks if the method returns true when the last token placed
    results in 5 vertical tokens in a column.
    */
    @Test
    public void checkVertWin_five_in_a_column() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 1);
        gb.placeToken('O', 3);
        gb.placeToken('X', 2);
        gb.placeToken('O', 5);
        gb.placeToken('X', 2);
        BoardPosition pos = new BoardPosition(5, 2);
        char p = 'X';
        boolean result = gb.checkVertWin(pos, p);
        assertTrue(result);
    }

    /*
    The second test case checks if the method returns false when the last token placed
    results in less than 5 vertical tokens in a column.
     */
    @Test
    public void checkVertWin_less_than_five_in_a_column() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        BoardPosition pos = new BoardPosition(2, 2);
        char p = 'O';
        boolean result = gb.checkVertWin(pos, p);
        assertFalse(result);
    }

    /*
    The third test case checks if the method returns false when the last token placed
    is not part of a vertical sequence.
     */
    @Test
    public void checkVertWin_not_part_of_sequence() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 5);
        gb.placeToken('X', 5);
        BoardPosition pos = new BoardPosition(5, 5);
        char p = 'O';
        boolean result = gb.checkVertWin(pos, p);
        assertFalse(result);
    }

    /*
    The fourth test case checks if the method returns true when the last token placed
    results in exactly five vertical tokens in a column.
     */
    @Test
    public void checkVertWin_exactly_five_in_a_column() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 1);
        gb.placeToken('O', 3);
        gb.placeToken('X', 2);
        gb.placeToken('O', 5);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        BoardPosition pos = new BoardPosition(4, 2);
        char p = 'O';
        boolean result = gb.checkVertWin(pos, p);
        assertTrue(result);
    }

    /*
    This test case checks if the method returns true when the last token placed
    results in exactly five diagonal tokens in a diagonal from bottom left to top right.
    */
    @Test
    public void checkDiagWin_bottom_left_to_top_right_X() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        BoardPosition pos = new BoardPosition(4, 4);
        char p = 'X';
        boolean result = gb.checkDiagWin(pos, p);
        assertTrue(result);
    }

    /*
    This test case checks if the method returns true when the last token placed
    results in exactly five diagonal tokens in a diagonal from top left to bottom right.
    */
    @Test
    public void checkDiagWin_top_left_to_bottom_right_O() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 5);
        gb.placeToken('X', 4);
        gb.placeToken('O', 6);
        gb.placeToken('X', 5);
        gb.placeToken('O', 6);
        gb.placeToken('X', 5);
        BoardPosition pos = new BoardPosition(5, 5);
        char p = 'O';
        boolean result = gb.checkDiagWin(pos, p);
        assertTrue(result);
    }

    /*
    This test case checks if the method returns true when the last token placed
    results in exactly five diagonal tokens in a diagonal from top left to bottom right.
    */
    @Test
    public void checkDiagWin_top_left_to_bottom_right_X() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 2);
        gb.placeToken('O', 4);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);
        gb.placeToken('X', 3);
        gb.placeToken('O', 5);
        gb.placeToken('X', 4);
        gb.placeToken('O', 5);
        gb.placeToken('X', 4);
        BoardPosition pos = new BoardPosition(4, 4);
        char p = 'X';
        boolean result = gb.checkDiagWin(pos, p);
        assertTrue(result);
    }

    /*
    The 4th test case checks if the method returns true when the last token placed
    results in exactly five tokens in a diagonal left.
    */
    @Test
    public void checkDiagWin_exactly_five_diagonal_left() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        BoardPosition pos = new BoardPosition(3, 3);
        char p = 'X';
        boolean result = gb.checkDiagWin(pos, p);
        assertTrue(result);
    }

    /*
    The 5th test case checks if the method returns true when the last token placed
    results in exactly five tokens in a diagonal right.
    */
    @Test
    public void checkDiagWin_exactly_five_diagonal_right() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('O', 6);
        gb.placeToken('X', 5);
        gb.placeToken('O', 5);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        BoardPosition pos = new BoardPosition(3, 3);
        char p = 'X';
        boolean result = gb.checkDiagWin(pos, p);
        assertTrue(result);
    }

    /*
    The 6th test case checks if the method returns true when the last token placed
    does not result in a diagonal win, but another token placed earlier did.
    */
    @Test
    public void checkDiagWin_another_token_wins() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 2);
        gb.placeToken('O', 3);
        gb.placeToken('X', 3);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 4);
        gb.placeToken('X', 4);
        gb.placeToken('O', 5);
        gb.placeToken('X', 5);
        gb.placeToken('O', 5);
        gb.placeToken('X', 5);
        char[][] testArray = {
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'X', 'O', '.', '.', '.'},
                {'.', '.', '.', 'X', 'O', '.', '.'},
                {'.', '.', '.', '.', 'X', 'O', '.'},
                {'.', '.', '.', '.', '.', 'X', 'O'}
        };
        char p = 'O';
        boolean result = checkDiagWin(testArray, 5, 5, p);
        assertEquals(true, result);
    }

    /*
    The 7th test case checks if the method returns false when the last token placed
    results in less than five diagonal tokens in a diagonal right from bottom to top.
    */
    @Test
    public void checkDiagWin_less_than_five_in_a_right_diagonal() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 5);
        gb.placeToken('O', 4);
        gb.placeToken('X', 6);
        gb.placeToken('O', 3);
        gb.placeToken('X', 6);
        gb.placeToken('O', 2);
        gb.placeToken('X', 5);
        gb.placeToken('O', 1);
        gb.placeToken('X', 4);
        gb.placeToken('O', 1);
        gb.placeToken('X', 5);
        char[][] testArray = {
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O', 'O'}
        };
        assertEquals(false, gb.checkDiagWin('X', testArray));
    }

    /*
    This test case checks if checkTie returns true when the board is
     full and there are no wins.
    */
    @Test
    public void checkTie_board_full_no_wins() {
        IGameBoard gb = createGameBoard(3, 3);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        gb.placeToken('O', 1);
        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('O', 2);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        boolean result = gb.checkTie();
        assertEquals(true, result);
    }

    /*
    This test case checks if checkTie returns false when the board is not full.
    */
    @Test
    public void checkTie_board_not_full() {
        IGameBoard gb = createGameBoard(3, 3);
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        boolean result = gb.checkTie();
        assertEquals(false, result);
    }

    /*
    This test case checks if checkTie returns false when the board is full but there is a win.
    */
    @Test
    public void checkTie_board_full_with_win() {
        IGameBoard gb = createGameBoard(3, 3);
        gb.placeToken('X', 0);
        gb.placeToken('X', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 0);
        gb.placeToken('O', 1);
        gb.placeToken('O', 2);
        boolean result = gb.checkTie();
        assertEquals(false, result);
    }

    /*
     * The test case checks if checkTie returns true when the board
     *  is full but there is a winner
     */
    @Test
    public void checkTie_board_full_with_winner() {
        IGameBoard gb = createEmptyGameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 1);
        gb.placeToken('O', 1);
        gb.placeToken('X', 2);
        gb.placeToken('O', 2);
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        gb.placeToken('X', 4);
        gb.placeToken('X', 5);
        gb.placeToken('X', 6);
        boolean result = gb.checkTie();
        assertEquals(true, result);
    }


    /*
    This test case checks if the method returns the correct character when a token is placed at
    the specified position.
    */
    @Test
    public void checkWhatsAtPos_returns_correct_character() {
        IGameBoard gb = new GameBoard(6,7,4);
        gb.placeToken('X', 2);
        assertEquals('X', gb.whatsAtPos(new BoardPosition(5, 2)));
    }

    /*
    This test case checks if the method returns the correct character when the specified position
    does not contain a token.
    */
    @Test
    public void checkWhatsAtPos_returns_empty_character() {
        IGameBoard gb = new GameBoard(6,7,4);
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(3, 3)));
    }

    /*
    This test case checks if the method throws an IndexOutOfBoundsException when a position outside
    of the game board is specified.
    */
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkWhatsAtPos_throws_exception_when_position_out_of_bounds() {
        IGameBoard gb = new GameBoard(6,7,4);
        gb.whatsAtPos(new BoardPosition(7, 5));
    }

    /*
    This test case checks if the method returns the correct character when the game board is empty.
    */
    @Test
    public void checkWhatsAtPos_returns_empty_board_character() {
        IGameBoard gb = new GameBoard(6,7,4);
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(0, 0)));
    }

    /*
    This test case checks if the method returns the correct character when a position on the edge of
    the game board is specified.
    */
    @Test
    public void checkWhatsAtPos_returns_correct_edge_character() {
        IGameBoard gb = new GameBoard(6,7,4);
        gb.placeToken('O', 0);
        gb.placeToken('X', 6);
        assertEquals('O', gb.whatsAtPos(new BoardPosition(0, 0)));
    }

    /*
The 1st test case checks if the method returns true when the last token placed is at the specified position and is the same character as the one passed in the method.
*/
    @Test
    public void isPlayerAtPos_token_at_specified_position() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        assertEquals(true, gb.isPlayerAtPos(new BoardPosition(5, 0), 'X'));
    }

    /*
    The 2nd test case checks if the method returns false when the last token placed is not at the specified position.
    */
    @Test
    public void isPlayerAtPos_token_not_at_specified_position() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('O', 4);
        assertEquals(false, gb.isPlayerAtPos(new BoardPosition(5, 0), 'O'));
    }

    /*
    The 3rd test case checks if the method returns true when the token at the specified position is the same as the one passed in the method.
    */
    @Test
    public void isPlayerAtPos_token_at_specified_position_same_as_player() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 3);
        gb.placeToken('O', 3);
        assertEquals(true, gb.isPlayerAtPos(new BoardPosition(5, 3), 'O'));
    }

    /*
    The 4th test case checks if the method returns false when the token at the specified position is not the same as the one passed in the method.
    */
    @Test
    public void isPlayerAtPos_token_at_specified_position_different_from_player() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('O', 2);
        gb.placeToken('X', 1);
        assertEquals(false, gb.isPlayerAtPos(new BoardPosition(5, 1), 'O'));
    }

    /*
    The 5th test case checks if the method returns false when the specified position is outside the board.
    */
    @Test
    public void isPlayerAtPos_outside_board() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        assertEquals(false, gb.isPlayerAtPos(new BoardPosition(10, 10), 'X'));
    }


    /*
    The first test case checks if the method places the token in the correct column and row.
    */
    @Test
    public void checkTokenPlacement_in_correct_column_and_row() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        char[][] expectedArray = {
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O'}
        };
        assertArrayEquals(expectedArray, gb.getGameBoard());
    }

    /*
    The second test case checks if the method places the token in the lowest available row in the column.
    */
    @Test
    public void checkTokenPlacement_lowest_available_row_in_column() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        gb.placeToken('O', 0);
        gb.placeToken('X', 0);
        char[][] expectedArray = {
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O'}
        };
        assertArrayEquals(expectedArray, gb.getGameBoard());
    }

    /*
    The third test case checks if the method throws an error when trying to place a token in a full column.
    */
    @Test(expected = GameboardFullException.class)
    public void checkTokenPlacement_throws_exception_when_column_is_full() {
        IGameBoard gb = new GameBoard();
        for (int i = 0; i < 6; i++) {
            gb.placeToken('X', 0);
            gb.placeToken('O', 1);
        }
        gb.placeToken('X', 0);
    }

    /*
    The first test case checks if the method returns true when the player
    token is at the specified position.
     */
    @Test
    public void testIsPlayerAtPos_PlayerAtPos_ReturnsTrue() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('X', 0);
        BoardPosition pos = new BoardPosition(5, 0);
        assertTrue(gb.isPlayerAtPos(pos, 'X'));
    }


    /*
    The second test case checks if the method returns false when the player
     token is not at the specified position.
     */
    @Test
    public void testIsPlayerAtPos_PlayerNotAtPos_ReturnsFalse() {
        IGameBoard gb = new GameBoard();
        gb.placeToken('O', 2);
        BoardPosition pos = new BoardPosition(4, 1);
        assertFalse(gb.isPlayerAtPos(pos, 'X'));
    }


}
