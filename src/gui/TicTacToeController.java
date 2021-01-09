package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TicTacToeController {

    TicTacToeModel _model;
    TicTacToeView _view;

    /**
     * Creates a new controller for tic tac toe
     *
     * @param model
 *                  the game model
     * @param view
     *              the game view
     */
    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        _model = model;
        _view = view;

        for (int i = 0; i < _model.totalCells(); i++) {
            view.addCellClickedActionHandler(new CellClickedActionHandler(), i);
        }
        view.addResetActionHandler(new ResetActionHandler());
    }

    /**
     * EventHandler class for cell clicks
     */
    public class CellClickedActionHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            int column = GridPane.getColumnIndex((Button) event.getSource());
            int row = GridPane.getRowIndex((Button) event.getSource());
            _model.cellClicked(column, row);
            _view.cellClicked(column, row, _model.isxTurn());
            try {
                if (_model.xWins()) {
                    //todo do more than print to console when someone wins
                    System.out.println("X is winner");
                } else {
                    System.out.println("O is winner");
                }
            } catch (NullPointerException ignored){
                System.out.println("No winner");
            }


        }
    }

    public class ResetActionHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            _model.reset();
            _view.reset();
        }
    }
}
