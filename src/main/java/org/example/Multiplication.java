package org.example;

public class Multiplication extends ArithmeticOperation
{
    public Multiplication(char actionSymbol){
        OperationSymbol = actionSymbol;
    }
    @Override
    public double Calculate(double a, double b) {
        return a*b;
    }
}
