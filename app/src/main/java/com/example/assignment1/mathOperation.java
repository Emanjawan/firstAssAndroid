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
    public String resultCalculatePrint(double number1, double number2, String operation){
        if(operation.equals("+")){

            return "*) Sum =\nNumber 1 + Number 2.\n\n  = "+number1+" + "+number2+"\n\n  = "+(number1+number2)+"\n\n";



        }
        else if(operation.equals("-")){

            return "*) Minus =\nNumber 1 - Number 2.\n\n  = "+number1+" - "+number2+"\n\n  = "+(number1-number2)+"\n\n";



        }

       else if(operation.equals("x")){

            return "*) Cross =\nNumber 1 x Number 2.\n\n  = "+number1+" x "+number2+"\n\n  = "+(number1*number2)+"\n\n";



        }
       else if(operation.equals("/")){

            return "*) Div =\nNumber 1 / Number 2.\n\n  = "+number1+" / "+number2+"\n\n  = "+(number1/number2)+"\n\n";



        }
else{

    return null;
        }

    }

}
