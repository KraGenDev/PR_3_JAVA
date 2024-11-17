package org.example;

import java.util.Scanner;

public class Calculator
{

    public void Start()
    {
        Scanner scanner = new Scanner(System.in);

        try
        {
            char operationSymbol = SelectValidOperation(scanner);;

            double num1 = GetValidDoubleInput(scanner, "Введіть перше число: ");
            double num2 = 0;

            if(operationSymbol != '^')
            {
                num2 = GetValidDoubleInput(scanner, "Введіть друге число: ");
            }

            double result = 0;

            switch (operationSymbol)
            {
                case '+':
                    result = Addition(num1, num2);
                    break;
                case '-':
                    result = Subtraction(num1, num2);
                    break;
                case '*':
                    result = Multiplication(num1, num2);
                    break;
                case '/':
                    try
                    {
                        result = Division(num1, num2);
                    }
                    catch (ArithmeticException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case '^':
                    try
                    {
                        result = SquareRoot(num1);
                    }
                    catch (InvalidInputException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            if(operationSymbol != '^')
            {
                System.out.println(num1 + " " + operationSymbol + " " +  num2 + " = " + result);
            }
            else
            {
                System.out.println(num1 + "" + operationSymbol +" = " + result);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            scanner.close();
        }
    }

    private double GetValidDoubleInput(Scanner scanner, String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            if (scanner.hasNextDouble())
            {
                return scanner.nextDouble();
            }
            else
            {
                System.out.println("Помилка: Будь ласка, введіть дійсне число.");
                scanner.next();
            }
        }
    }

    private char SelectValidOperation(Scanner scanner)
    {
        char operationSymbol;
        while (true)
        {
            System.out.println("Доступні операції: \n+ Додавання \n- Віднімання\n/ Ділення\n* Множення\n^ Зведення до кореня");
            System.out.print("Оберіть операцію: ");
            operationSymbol = scanner.next().charAt(0);

            if(operationSymbol == '+' || operationSymbol == '-' || operationSymbol == '*' || operationSymbol == '/' || operationSymbol == '^')
                break;
            else
            {
                System.out.println("\nНевірно вказаний символ операції");
            }
        }

        return operationSymbol;
    }

    public double Addition(double num1, double num2) throws InvalidInputException
    {
        if (Double.isInfinite(num1) || Double.isInfinite(num2))
        {
            throw new InvalidInputException("Один із вхідних параметрів є нескінченним");
        }

        return num1 + num2;
    }

    public double Subtraction(double num1, double num2) throws InvalidInputException
    {
        if (Double.isInfinite(num1) || Double.isInfinite(num2))
        {
            throw new InvalidInputException("Один із вхідних параметрів є нескінченним");
        }

        return num1 - num2;
    }

    public double Multiplication(double num1, double num2) throws InvalidInputException
    {
        if (Double.isInfinite(num1) || Double.isInfinite(num2))
        {
            throw new InvalidInputException("Один із вхідних параметрів є нескінченним");
        }

        return num1 * num2;
    }

    public double Division(double num1, double num2)
    {
        if (num2 == 0)
        {
            throw new ArithmeticException("Ділення на нуль неможливе!");
        }

        return num1 / num2;
    }

    public double SquareRoot(double num) throws InvalidInputException
    {
        if (num < 0)
        {
            throw new InvalidInputException("Неможливо взяти квадратний корінь з від'ємного числа!");
        }

        return Math.sqrt(num);
    }
}