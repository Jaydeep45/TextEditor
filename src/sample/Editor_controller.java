package sample;

/*
  Controller for the fxml
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;

public class Editor_controller {


    public Button reset;
    public TextArea editor;
    public Button save;
    public MenuItem exit;

    /**
     * For Reset button
      */
    public void Reset() {
        editor.clear();
    }

    /**
     * Creates a new Scene for saving the file.
     * Tech used:
     * Java IO
     */
    public void Save() {
        Stage stage = new Stage();
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(5);
        Label L = new Label("Do you want to save?");
        Button yes = new Button("Yes");
        Button no = new Button("No");
        hBox.getChildren().addAll(yes,no);
        vBox.getChildren().addAll(L,hBox);
        Scene scene = new Scene(vBox,200,200);
        stage.setScene(scene);
        stage.setTitle("Save");
        stage.show();
        no.setOnAction((ActionEvent e) -> stage.close());
        yes.setOnAction((ActionEvent e) ->{
            VBox v = new VBox(10);
            vBox.setAlignment(Pos.CENTER);
            HBox h = new HBox(10);
            Label label = new Label("Enter the name of file");
            TextField textArea = new TextField();
            Button btn = new Button("Save");
            btn.setAlignment(Pos.CENTER);
            btn.setOnAction(event -> {
                try {
                    String s = textArea.getText();
                    File file = new File(s);
                    String inp  = editor.getText();
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(inp);
                    fileWriter.close();
                    Platform.exit();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            });
            h.getChildren().addAll(label,textArea);
            v.getChildren().addAll(h,btn);
            stage.setScene(new Scene(v,400,120));
            stage.show();
        });
    }

    /**
     * this function close the application
     */
    public void exit() {
        Platform.exit();
    }

    /**
     * this function is used to open a saved file.
     */
    public void open() {
        Stage stage = new Stage();
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(5);
        Label label = new Label("Enter the file name");
        TextField textField = new TextField();
        Button btn = new Button("Open");
        btn.setOnAction(event -> {
            File file = new File(textField.getText());
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader br = new BufferedReader(fileReader);
                String st;
                while ((st = br.readLine()) != null){
                    editor.setText(st);
                }
                Stage stage1 = (Stage) btn.getScene().getWindow();
                stage1.show();
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
                stage.close();
            }
        });
        hBox.getChildren().addAll(label,textField);
        vBox.getChildren().addAll(hBox,btn);
        stage.setScene(new Scene(vBox,375,75));
        stage.show();
    }

    /**
     * this function gives details about the software.
     */
    public void help() {
        Stage stage = new Stage();
        VBox v = new VBox(25);
        v.setAlignment(Pos.CENTER);
        Label l = new Label("This is an Simple text editor!\n I think u have used notepad.\nRight?");
        l.setFont(Font.font("Roboto", FontWeight.BOLD,14));
        Button yes = new Button("Definitely yes!");
        yes.setFont(Font.font("Arial"));
        yes.setOnAction(event -> stage.close());
        v.getChildren().addAll(l,yes);
        stage.setScene(new Scene(v,200,150));
        stage.show();

    }

    /**
     * this are used for cut, copy, paste functions.
     */
    public void cut() {
        editor.cut();
    }

    public void copy() {
        editor.copy();
    }

    public void paste() {
        editor.paste();
    }
}
