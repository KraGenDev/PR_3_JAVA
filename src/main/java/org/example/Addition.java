package org.example;

public class Addition extends ArithmeticOperation
{
    public Addition(char actionSymbol){
        OperationSymbol = actionSymbol;
    }

    @Override
    public double Calculate(double a, double b) {
        return a + b;
    }
}
