package com.example.cs3318_assigment3;

import com.example.cs3318_assigment3.Exceptions.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.regex.Pattern;

public class View extends Application {

    /* Creates View */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Model.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Sign Up Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /* Finished Creating View */
    /* View Creates Presenter*/
    Presenter presenter = new Presenter();

    @FXML
    private Button button;

    @FXML
    public Label errorText;

    @FXML
    private TextField email;

    @FXML
    private TextField password;


    @FXML
    protected void handleButton1Action()
    {
        String emailString = email.getText();
        String passwordString = password.getText();
        errorText.setText(emailString);
        errorText.setText(passwordString);
    }

}