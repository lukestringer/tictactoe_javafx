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
                //currently doesn't matter who wins, will throw exception if no winners
                if (_model.xWins()) System.out.println("X wins");
                else {
                    System.out.println("O wins");
                }
                //can ONLY run this because above will throw a NullPointerException if there's
                //no winner, which would skip it
                _view.winner(_model.getWinningLine());
            } catch (NullPointerException ignored) {}


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
