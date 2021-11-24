package com.example.cs3318_assigment3;

import com.example.cs3318_assigment3.Exceptions.SpecialCharException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.example.cs3318_assigment3.Exceptions.LengthException;
import com.example.cs3318_assigment3.Exceptions.LetterException;
import com.example.cs3318_assigment3.Exceptions.DigitException;
import org.apache.commons.lang.StringUtils;

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

    private boolean ifContainsInt(String string,Integer n){
        for (int i =0; i < n; i++){
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }


    public boolean verifyPassword(String password1) throws LengthException, DigitException, LetterException, SpecialCharException {
        int length = password1.length();
        if (length < 7){
            throw new LengthException("Please Ensure Password is Longer than 7 Chars");
        }
        if(!ifContainsInt(password1, length)){
            throw new DigitException("Please Ensure Password Contains a Number");
        }
        if(!password1.matches(".*[a-z].*")){
            throw new LetterException("Please Ensure Password Contains a letter");
        }
        if(!StringUtils.containsAny(password1,".*[^&@!].*")){
            throw new SpecialCharException("Please Ensure Password Contains one of these chars ' ^ & @ ! ' ");
        }
        return true;
    }




    public boolean verifyEmail(String email){
        return false;
    }
}