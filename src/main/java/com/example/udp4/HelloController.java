package com.example.udp4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    public HelloApplication main;
    public TextField inputA;
    public TextField inputB;
    public TextField inputC;
    public Text text;
    public Button buttonResult;

    @FXML
    public void getResult(ActionEvent actionEvent) {
        if(!inputA.getText().matches("^[0-9]+$") || !inputB.getText().matches("^[0-9]+$") || !inputC.getText().matches("^[0-9]+$")) {
            text.setText("Ошибка: не верный ввод");

        } else {
            main.a = Integer.parseInt(inputA.getText());
            main.b = Integer.parseInt(inputB.getText());
            main.c = Integer.parseInt(inputC.getText());
            main.clientStart();
        }

    }

    public TextField getInputA() {
        return inputA;
    }

    public void setInputA(TextField inputA) {
        this.inputA = inputA;
    }

    public TextField getInputB() {
        return inputB;
    }

    public void setInputB(TextField inputB) {
        this.inputB = inputB;
    }

    public TextField getInputC() {
        return inputC;
    }

    public void setInputC(TextField inputC) {
        this.inputC = inputC;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
