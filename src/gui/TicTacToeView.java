package gui;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * The view for tic tac toe.
 */
public class TicTacToeView {

    TicTacToeModel model; //tic tac toe model
    GridPane gridPane; //The root node for the view
    private Button[] cells; //the cells for the game
    //todo naughts and crosses

    /**
     * Creates a new tic tac toe view with the given model
     *
     * @param model
     *              the tic tac toe model
     */
    public TicTacToeView(TicTacToeModel model) {
        this.model = model;
        gridPane = new GridPane();
        addCells();
        setGridConstraints();
    }

    /**
     * Add the cells to the gridPane
     */
    private void addCells() {
        cells = new Button[9];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Button();
            int row = i / model.getColumns();
            int column = i % model.getColumns();
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
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setMinSize(Double.MIN_VALUE, Double.MIN_VALUE);
        // doesn't start with focus or stay focused
        button.setFocusTraversable(false);
    }

    /**
     * Get the root node of the scene graph.
     *
     * @return returns the root node in the scene graph for the view
     */
    public GridPane getRootNode() {
        return gridPane;
    }

    /**
     * Set the constraints of the gridPane.
     * (copied and pasted from Larissa Meinicke's calculator gui example csse2002 2017 sem 1)
     */
    private void setGridConstraints() {
        // columns to always extend when window is resized
        ColumnConstraints columnConstraint = new ColumnConstraints();
        columnConstraint.setHgrow(Priority.ALWAYS);
        columnConstraint.setPrefWidth(50);
        for (int i = 0; i < model.getColumns(); i++) {
            gridPane.getColumnConstraints().add(columnConstraint);
        }

        // row to always extend when window is resized
        RowConstraints rowConstraint = new RowConstraints();
        rowConstraint.setVgrow(Priority.ALWAYS);
        rowConstraint.setPrefHeight(50);
        for (int i = 0; i < model.getRows(); i++) {
            gridPane.getRowConstraints().add(rowConstraint);
        }
    }
}
