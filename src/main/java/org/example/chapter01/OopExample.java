package org.example.chapter01;

public class OopExample {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService(new Addition(), new Division());
        final int additionResult = calculatorService.calculate(11, 1);
        System.out.println("additionResult = " + additionResult);

        final int subtractionResult = calculatorService.calculate(11, 1);
        System.out.println("subtractionResult = " + subtractionResult);

        final int multiplicationResult = calculatorService.calculate(11, 1);
        System.out.println("multiplicationResult = " + multiplicationResult);

        final int divisionResult = calculatorService.calculate(20, 4);
        System.out.println("divisionResult = " + divisionResult);
    }
}

// Strategy 패턴
class CalculatorService {

    private final Calculation calculation1;
    private final Calculation calculation2;

    public CalculatorService(Calculation calculation1, Calculation calculation2) {
        this.calculation1 = calculation1;
        this.calculation2 = calculation2;
    }

    public int calculate(int num1, int num2) {
        if (num1 > 10 && num1 > num2) {
            return calculation1.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }

    public int compute(int num1, int num2) {
        if (num1 > 10 && num1 > num2) {
            return calculation2.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }
}

class Addition implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class Division implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}