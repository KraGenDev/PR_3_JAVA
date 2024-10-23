package org.example;

public class Subtraction extends ArithmeticOperation
{
    public Subtraction(char actionSymbol){
        OperationSymbol = actionSymbol;
    }

    @Override
    public double Calculate(double a, double b) {
        return a - b;
    }
}
