package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private List<ArithmeticOperation> _actions;

    public Calculator() {
        Addition addition = new Addition('+');
        Subtraction subtraction = new Subtraction('-');
        Division division = new Division('/');
        Multiplication multiplication = new Multiplication('*');
        SquareRoot squareRoot = new SquareRoot('^');

        _actions = new ArrayList<>();
        _actions.add(addition);
        _actions.add(subtraction);
        _actions.add(division);
        _actions.add(multiplication);
        _actions.add(squareRoot);
    }

    public void Start() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);

        double a = GetValidDoubleInput(scanner, "Введіть перше число: ");
        double b = GetValidDoubleInput(scanner, "Введіть друге число: ");

        StringBuilder actions = new StringBuilder();
        for (ArithmeticOperation action : _actions) {
            actions.append(action.OperationSymbol).append(" ");
        }

        while (true) {
            System.out.println("Доступні дії: " + actions);
            System.out.print("Яку дію виконати?: ");
            char actionSymbol = scanner.next().charAt(0);

            ArithmeticOperation selectedAction = null;

            for (ArithmeticOperation action : _actions) {
                if (action.OperationSymbol == actionSymbol) {
                    selectedAction = action;
                    break;
                }
            }

            if (selectedAction != null) {
                double result = selectedAction.Calculate(a, b);
                System.out.println("Результат: " + result);
                break;
            } else {
                System.out.println("Невірний символ дії! Спробуйте знову.");
            }
        }

        scanner.close();
    }


    private double GetValidDoubleInput(Scanner scanner, String prompt) {
        double input = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                break;
            } else {
                System.out.println("Помилка: Будь ласка введіть число");
                scanner.next();
            }
        }
        return input;
    }
}
