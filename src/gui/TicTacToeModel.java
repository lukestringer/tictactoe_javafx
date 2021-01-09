package gui;

/**
 * The model for tic tac toe
 */
public class TicTacToeModel {
    private final int rows = 3;
    private final int columns = rows;
    private Boolean[] cells; //current state of cells
    private boolean xTurn = true;//tracks if it is cross's turn (naught's if not)

    public TicTacToeModel() {
        cells = new Boolean[totalCells()];
        int i = 0;
    }

    /**
     * Updates cell to true if x (cross's) turn or false if o (naught's) turn
     * Current turn changes player.
     *
     * @param column
     *              the column of the cell clicked
     * @param row
     *              the row of the cell clicked
     */
    public void cellClicked(int column, int row) {
        //only update empty cells
        if (cells[row * columns + column] == null) {
            cells[row * columns + column] = xTurn;
            xTurn = !xTurn;
            //todo check for winner
            //todo check for all cells filled
        }
    }



    /**
     * Checks if crosses is the winner.
     *
     * @return
     *      true if crosses wins, false if naughts wins, null if no one has won yet
     */
    public Boolean xWins() {
        /*
        index triplets to check for winner
        0 1 2, 3 4 5, 6 7 8
        0 3 6, 1 4 7, 2 5 8
        0 4 8
        2 4 6
         */

        //check each row
        for (int i = 0; i < rows; i++) {
            try {//'try' stops NullPointerExceptions (couldn't have winner on this line anyway)
                //if they're all true, return true
                if (cells[i] && cells[i + 1] && cells[i + 2]) {
                    return Boolean.TRUE;
                }
                //if they're all false, return false
                if (!cells[i] && !cells[i + 1] && !cells[i + 2]) {
                    return Boolean.FALSE;
                }
            } catch (NullPointerException ignored) {

            }
        }

        //

        return null;
    }

    /**
     * Returns number of rows in game grid
     * @return
     *      the number of rows in the game grid
     */
    public int rows() {
        return this.rows;
    }

    /**
     * Returns number of columns in game grid
     * @return
     *      the number of columns in the game grid
     */
    public int columns() {
        return this.columns;
    }

    /**
     * Returns if it is x (cross's) turn or not.
     * If it isn't, it's o (naught's) turn.
     *
     * @return
     *      true if cross's turn, false if naught's turn
     */
    public boolean isxTurn() {
        return xTurn;
    }

    public int totalCells() {
        return rows * columns;
    }

    public void reset() {
        cells = new Boolean[totalCells()];
    }
}
