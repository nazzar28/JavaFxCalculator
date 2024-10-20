package org.example.calculatorapp;

public class Calculator {
    private double operand1;
    private double operand2;
    private char operator;
    private double result;
    private boolean isError;

    public void setOperand1(double operand) {
        this.operand1 = operand;
    }

    public void setOperand2(double operand) {
        this.operand2 = operand;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void calculate() {
        try {
            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    if (operand2 == 0) {
                        isError = true;
                    } else {
                        result = operand1 / operand2;
                    }
                    break;
                default:
                    isError = true;
            }
        } catch (Exception e) {
            isError = true;
        }
    }

    public double getResult() {
        return result;
    }

    public boolean isError() {
        return isError;
    }

    public void reset() {
        operand1 = 0;
        operand2 = 0;
        operator = '\0';
        result = 0;
        isError = false;
    }
}