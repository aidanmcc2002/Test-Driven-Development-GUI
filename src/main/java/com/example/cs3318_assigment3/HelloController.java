package com.example.cs3318_assigment3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Button button;

    @FXML
    private Label errorText;

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

    public boolean verifyPassword(String password){
        return false;
    }

    public boolean verifyEmail(String email){
        return false;
    }
}