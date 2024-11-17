package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest
{
    @Test
    public void TestAddition()
    {
        Calculator calculator = new Calculator();
        try
        {
            double result = calculator.Addition(2.0, 3.0);
            assertEquals(5.0, result,0.0001);
        }
        catch (InvalidInputException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TestSubtraction()
    {
        Calculator calculator = new Calculator();
        try
        {
            double result = calculator.Subtraction(5.0, 3.0);
            assertEquals(2.0, result, 0.0001);
        }
        catch (InvalidInputException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TestMultiplication()
    {
        Calculator calculator = new Calculator();
        try
        {
            double result = calculator.Multiplication(2.0, 3.0);
            assertEquals(6.0, result, 0.0001);
        }
        catch (InvalidInputException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TestDivision()
    {
        Calculator calculator = new Calculator();
        try
        {
            double result = calculator.Division(6.0, 3.0);
            assertEquals(2.0, result, 0.0001);
        }
        catch (ArithmeticException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = ArithmeticException.class)
    public void TestDivisionByZero()
    {
        Calculator calculator = new Calculator();
        calculator.Division(5.0, 0.0);
    }

    @Test
    public void TestSquareRoot() {
        Calculator calculator = new Calculator();
        try
        {
            double result = calculator.SquareRoot(4.0);
            assertEquals(2.0, result, 0.0001);
        }
        catch (InvalidInputException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = InvalidInputException.class)
    public void TestSquareRootOfNegative() throws InvalidInputException
    {
        Calculator calculator = new Calculator();
        calculator.SquareRoot(-4.0);
    }
}
