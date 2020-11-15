package sample;

/**
 * A simple task editor.
 * Task performed:
 * i) Open ii) Save iii) Reset
 * iv) Cut v) Copy vi) Paste
 *
 * It uses basic UI component no styling is done.
 *
 * @aurhor Jaydeep Ravat
 * @version 1.0.0
 * @since 15/10/2020
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Editor_Main extends Application {
    /**
     * Creating front stage and calls fxml
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Editor_fxml.fxml"));
        primaryStage.setTitle("TEXT EDITOR");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
