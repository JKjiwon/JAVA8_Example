package org.example.chapter01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    @Test
    void testCalculateAddition() {
        Calculation calculation = new Addition();

        final int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void testCalculateSubtraction() {
        Calculation calculation = new Subtraction();

        final int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void testCalculateMultiplication() {
        Calculation calculation = new Multiplication();

        final int actual = calculation.calculate(1, 1);

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void testCalculateDivision() {
        Calculation calculation = new Division();

        final int actual = calculation.calculate(8, 4);

        assertThat(actual).isEqualTo(2);
    }
}