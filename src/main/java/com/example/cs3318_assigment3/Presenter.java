package com.example.cs3318_assigment3;

import com.example.cs3318_assigment3.Exceptions.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.regex.Pattern;

public class Presenter {

    private boolean ifContainsInt(String string, Integer n) {
        for (int i = 0; i < n; i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }


    public boolean verifyPassword(String password1) throws LengthException, DigitException, LetterException, SpecialCharException, EmptyFieldException {
        int length = password1.length();
        if (length == 0) {
            throw new EmptyFieldException("Please input something into password field");
        }
        if (length < 7) {
            throw new LengthException("Please Ensure Password is Longer than 7 Chars");
        }
        if (!ifContainsInt(password1, length)) {
            throw new DigitException("Please Ensure Password Contains a Number");
        }
        if (!password1.matches(".*[a-z].*")) {
            throw new LetterException("Please Ensure Password Contains a letter");
        }
        if (!StringUtils.containsAny(password1, ".*[^&@!].*")) {
            throw new SpecialCharException("Please Ensure Password Contains one of these chars ' ^ & @ ! ' ");
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    public boolean verifyEmail(String email) throws EmailException, EmptyFieldException {
        if (email.length() == 0) {
            throw new EmptyFieldException("Please input something into email field");
        }
        if (!isValidEmail(email)) {
            throw new EmailException("Please Ensure Valid Email Inputted");
        } else {
            return true;
        }

        }
    }
