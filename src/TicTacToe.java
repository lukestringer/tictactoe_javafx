import gui.TicTacToeController;
import gui.TicTacToeModel;
import gui.TicTacToeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class TicTacToe extends Application {


    public static void main(String[] args) {
        //launch works because TicTacToe extends Application
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView(model);
        new TicTacToeController(model, view);

        stage.setScene(new Scene(view.getRootNode(), 300, 300));
        stage.setTitle("Tic Tac Toe");
        stage.show();
    }
}


/*
Useful resources:
https://docs.oracle.com/javafx/2/get_started/hello_world.htm
 */