package com.example.cs3318_assigment3;

import javafx.scene.control.Label;

public class Model {
    public String setErrorText(String stringy, Label errorText){
        if (errorText != null) {
            errorText.setText(stringy);
        }
        return stringy;
    }
}