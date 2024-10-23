package org.example;

public abstract class ArithmeticOperation {
    public char OperationSymbol;

    public abstract double Calculate(double a, double b) throws InvalidInputException;
}
