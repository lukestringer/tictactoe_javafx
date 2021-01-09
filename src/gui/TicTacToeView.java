package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.*;

/**
 * The view for tic tac toe.
 */
public class TicTacToeView {

    TicTacToeModel _model; //tic tac toe model
    GridPane gridPane; //The root node for the view
    private Button[] cells; //the cells for the game
    Button reset; //the button to reset the board to empty cells
    // the font type for all the text on the buttons
    private Font font = Font.font("SanSerif", FontWeight.BOLD, 25);

    /**
     * Creates a new tic tac toe view with the given model
     *
     * @param model
     *              the tic tac toe model
     */
    public TicTacToeView(TicTacToeModel model) {
        _model = model;
        gridPane = new GridPane();
        addCells();
        addResetButton();
        setGridConstraints();
    }

    private void addResetButton() {
        reset = new Button("Reset board");
        setupButtonAsCell(reset);
        gridPane.add(reset, 0, _model.rows(), _model.columns(), 1);
    }

    /**
     * Add the cells to the gridPane
     */
    private void addCells() {
        cells = new Button[9];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Button();
            int row = i / _model.columns();
            int column = i % _model.columns();
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
        button.setFont(font);
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
        for (int i = 0; i < _model.columns(); i++) {
            gridPane.getColumnConstraints().add(columnConstraint);
        }

        // row to always extend when window is resized
        RowConstraints rowConstraint = new RowConstraints();
        rowConstraint.setVgrow(Priority.ALWAYS);
        rowConstraint.setPrefHeight(50);
        for (int i = 0; i < _model.rows(); i++) {
            gridPane.getRowConstraints().add(rowConstraint);
        }
    }

    public void addCellClickedActionHandler(EventHandler<ActionEvent> handler, int cell) {
        cells[cell].setOnAction(handler);
    }

    public void addResetActionHandler(EventHandler<ActionEvent> handler) {
        reset.setOnAction(handler);
    }

    /**
     * Fills the clicked cell with a naught or cross, depending on if it is cross's turn.
     *
     * @param column
     *          the column of the cell clicked
     * @param row
     *          the row of the cell clicked
     * @param xTurn
     *          true if it is cross's turn
     */
    public void cellClicked(int column, int row, Boolean xTurn) {
        String text = xTurn ? "X" : "O";
        Button cell = cells[row * _model.columns() + column];
        cell.setText(text);
        cell.setDisable(true);
        cell.setOpacity(1);
        //todo replace button with naught or cross instead of just disabling it
    }

    public void reset() {
        for (int i = 0; i < _model.totalCells(); i++) {
            cells[i].setText("");
            cells[i].setDisable(false);
        }
    }
}
