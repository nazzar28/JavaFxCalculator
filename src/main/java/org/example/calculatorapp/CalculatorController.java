package org.example.calculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    private Calculator calculator = new Calculator();
    private StringBuilder currentInput = new StringBuilder();

    @FXML
    private TextField display;

    @FXML
    private void handleDigit(ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();
        System.out.println("Нажата кнопка: " + digit);  // Вывод в консоль
        currentInput.append(digit);
        display.setText(currentInput.toString());
        System.out.println("Текущее значение: " + currentInput.toString());  // Проверка текущего значения
    }


    @FXML
    private void handleOperator(ActionEvent event) {
        String operator = ((Button) event.getSource()).getText();
        calculator.setOperand1(Double.parseDouble(currentInput.toString()));
        calculator.setOperator(operator.charAt(0));
        currentInput.setLength(0);
    }

    @FXML
    private void handleEqual(ActionEvent event) {
        calculator.setOperand2(Double.parseDouble(currentInput.toString()));
        calculator.calculate();
        if (calculator.isError()) {
            display.setText("Error");
        } else {
            display.setText(Double.toString(calculator.getResult()));
        }
        currentInput.setLength(0);
    }

    @FXML
    private void handleClear(ActionEvent event) {
        calculator.reset();
        currentInput.setLength(0);
        display.setText("");
    }

    @FXML
    public void initialize() {
        System.out.println("Контроллер инициализирован");
    }

}