package com.example.assignment1;

public class mathOperation {
    private double num1;
    private double num2;
    private String operation;


    public String[] operation() {
        String[] types = {"+", "-", "x", "/"};


        return types;
    }

    public double resultCalculate(double number1, double number2, String operation) {


        switch (operation) {
            case "+": {
                double num3 = number1 + number2;
                return num3;

            }
            case "x": {
                double num3 = (number1 * number2);
                return num3;


            }
            case "-": {
                double num3 = (number1 - number2);
                return num3;

            }
            case "/": {
                double num3 = 0;

                if (number1 != 0 && number2 == 0) {
                    num3 = 0;
                } else {
                    num3 = (number1 / number2);

                }
                return num3;

            }
            default:
            {

            }


        }
        return 0;
    }

}
