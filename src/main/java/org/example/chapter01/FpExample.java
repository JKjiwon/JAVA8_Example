package org.example.chapter01;

public class FpExample {
    public static void main(String[] args) {
        FpCalculatorService fpCalculatorService = new FpCalculatorService();
        Calculation addition = (i1, i2) -> i1 + i2;
        System.out.println("Addition = " + fpCalculatorService.calculate(addition, 11, 1));
        System.out.println("Subtraction = " + fpCalculatorService.calculate((i1, i2) -> i1 - i2, 11, 1));
        System.out.println("Multiplication = " + fpCalculatorService.calculate((i1, i2) -> i1 * i2, 11, 1));
        System.out.println("Division = " + fpCalculatorService.calculate((i1, i2) -> i1 / i2, 20, 5));
        System.out.println("Custom Cal = " + fpCalculatorService.calculate((i1, i2) -> ((i1 + i2) * 2) / i2, 20, 4));
    }
}

class FpCalculatorService {
    public int calculate(Calculation calculation, int num1, int num2) {
        if (num1 > 10 && num1 > num2) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);
        }
    }
}