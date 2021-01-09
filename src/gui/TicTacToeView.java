package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * The view for tic tac toe.
 */
public class TicTacToeView {

    TicTacToeModel model; //tic tac toe model
    GridPane gridPane; //The root node for the view
    private final int rows = 3; //number of rows in the grid
    private final int columns = rows; //number of columns in the grid
    private Button[] cells; //the cells for the game
    //todo naughts and crosses

    /**
     * Creates a new tic tac toe view with the given model
     *
     * @param model
     *              the tic tac toe model
     */
    public TicTacToeView(TicTacToeModel model) {
        addCells();
    }

    /**
     * Add the cells to the gridPane
     */
    private void addCells() {
        cells = new Button[10];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Button();
            int row = i / columns + 1;
            int column =i % columns;
            setupButtonAsCell(cells[i]);
            gridPane.add(cells[i], column, row);
        }
    }

    /**
     * Sets up the button to function as a tic tac toe cell
     *
     * @param button
     *              The button to set up as a cell
     */
    private void setupButtonAsCell(Button button) {
        ;//todo
    }
}
