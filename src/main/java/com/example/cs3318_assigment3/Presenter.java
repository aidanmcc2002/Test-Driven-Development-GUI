package com.example.cs3318_assigment3;

import com.example.cs3318_assigment3.Exceptions.*;
import javafx.scene.control.Label;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Pattern;

public class Presenter{
    Model model = new Model();

    private boolean ifContainsInt(String string, Integer n) {
        for (int i = 0; i < n; i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }


    public boolean verifyPassword(String password1, Label errorText) throws LengthException, DigitException, LetterException, SpecialCharException, EmptyFieldException {
        int length = password1.length();
        if (length == 0) {
            errorText.setText("Please input something into password field");
            model.setErrorText("Please input something into password field", errorText);
            throw new EmptyFieldException("Please input something into password field");
        } else if (length < 7) {
            model.setErrorText("Please Ensure Password is Longer than 7 Chars", errorText);
            throw new LengthException("Please Ensure Password is Longer than 7 Chars");
        } else if (!ifContainsInt(password1, length)) {
            model.setErrorText("Please Ensure Password Contains a Number", errorText);
            throw new DigitException("Please Ensure Password Contains a Number");
        } else if (!password1.matches(".*[a-z].*")) {
            model.setErrorText("Please Ensure Password Contains a letter", errorText);
            throw new LetterException("Please Ensure Password Contains a letter");
        } else if (!StringUtils.containsAny(password1, ".*[^&@!].*")) {
            model.setErrorText("Please Ensure Password Contains one of these chars ' ^ & @ ! ' ", errorText);
            throw new SpecialCharException("Please Ensure Password Contains one of these chars ' ^ & @ ! ' ");
        } else {
            model.setErrorText("Successfully Signed Up", errorText);
            return true;
        }
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


    public boolean verifyEmail(String email,Label errorText) throws EmailException, EmptyFieldException {
        if (email.length() == 0) {
            model.setErrorText("Please input something into email field",errorText);
            throw new EmptyFieldException("Please input something into email field");
        }
        else if (!isValidEmail(email)) {
            model.setErrorText("Please Ensure Valid Email Inputted",errorText);
            throw new EmailException("Please Ensure Valid Email Inputted");
        }
        else {
            return true;
        }
    }

}
