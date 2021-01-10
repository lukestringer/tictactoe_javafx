package gui;

/**
 * The model for tic tac toe
 */
public class TicTacToeModel {
    private final int rows = 3;
    private final int columns = rows;
    private Boolean[] cells; //current state of cells
    private boolean xTurn = true;//tracks if it is cross's turn (naught's if not)

    public int[] getWinningLine() {
        return winningLine;
    }

    private int[] winningLine = null;

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
        }
    }



    /**
     * Checks if crosses is the winner or loser (naughts is winner).
     * Only notices first winning line (e.g. if a column and a line win, will notice the 'first')
     *
     * @return
     *      true if crosses wins, false if naughts wins, null if no one has won yet
     */
    public Boolean xWins() {
        /*
        groups of indexes (lines on board) to check
        0 1 2, 3 4 5, 6 7 8
        0 3 6, 1 4 7, 2 5 8
        0 4 8
        2 4 6
         */
        //if all cells in line are true, return true
        //if all cells in line are false, return false

        // check rows and columns
        for (int i = 0; i < rows; i++) {
            //'try' stops NullPointerExceptions (couldn't have winner on this line anyway)
            try {
                //check each row
                //noinspection ConstantConditions
                if (checkLine(columns*i, columns*i + 1, columns*i + 2)) {
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            } catch (NullPointerException ignored) {}

            try {
                //check each column
                //noinspection ConstantConditions
                if (checkLine(i, columns + i, 2*columns + i)) {
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }

            } catch (NullPointerException ignored) {}
        }

        //check diagonals
        try {
            //noinspection ConstantConditions
            if (checkLine(0, 4, 8)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (NullPointerException ignored) {}
        try {
            //noinspection ConstantConditions
            if (checkLine(2, 4, 6)) {
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        } catch (NullPointerException ignored) {}
        //no winners
        return null;
    }

    /**
     * Helper method to check line of cells.
     * Return true if all cells in line are true.
     * Return false if all cells in line are false.
     * Return null if NullPointerException (empty cells in line).
     *
     * @param index0
     *          index of the first cell in the line
     * @param index1
     *          index of the second cell in the line
     * @param index2
     *          index of the third cell in the line
     * @return
     *          Boolean object true if x wins, false if o wins, null if no winner
     */
    private Boolean checkLine(int index0, int index1, int index2) {
        try {
            if (cells[index0] && cells[index1] && cells[index2]) {
                winningLine = new int[] {index0, index1, index2};
                return Boolean.TRUE;
            }
        } catch (NullPointerException e) {
            //line is not full
            return null;
        }
        try {
            if (!cells[index0] && !cells[index1] && !cells[index2]) {
                winningLine = new int[] {index0, index1, index2};
                return Boolean.FALSE;
            }
        } catch (NullPointerException e) {
            //line is not full
            return null;
        }
        // line is full, but no winner
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
        xTurn = true;
    }
}
