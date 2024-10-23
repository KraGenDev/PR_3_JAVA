package org.example;

public class Division extends ArithmeticOperation {

    public Division(char actionSymbol) {
        OperationSymbol = actionSymbol;
    }

    @Override
    public double Calculate(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Ділення на нуль неможливе!");
            }
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
            return Double.NaN;
        }
    }
}
