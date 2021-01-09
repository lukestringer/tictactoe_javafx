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
    public void start(Stage primaryStage) throws Exception {
        // set up primary stage
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);

        Rectangle rect = new Rectangle(10, 10, 50, 50);
        rect.setFill(Paint.valueOf("red"));

        GridPane root = new GridPane();

        root.getChildren().addAll(rect);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);



        primaryStage.show();
    }
}


/*
Useful resources:
https://docs.oracle.com/javafx/2/get_started/hello_world.htm
 */