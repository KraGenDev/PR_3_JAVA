package org.example;

public class SquareRoot extends ArithmeticOperation {

    public SquareRoot(char actionSymbol) {
        OperationSymbol = actionSymbol;
    }

    @Override
    public double Calculate(double a, double b) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("Неможливо взяти квадратний корінь з від'ємного числа.");
        }
        return Math.sqrt(a);
    }
}
