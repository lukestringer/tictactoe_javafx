package gui;

/**
 * The model for tic tac toe
 */
public class TicTacToeModel {
    private final int rows = 3;
    private final int columns = rows;
    boolean[] cells; //current state of cells

    public TicTacToeModel() {

    }

    /**
     * Returns number of rows in game grid
     * @return
     *      the number of rows in the game grid
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Returns number of columns in game grid
     * @return
     *      the number of columns in the game grid
     */
    public int getColumns() {
        return this.columns;
    }
}
