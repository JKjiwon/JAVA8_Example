package org.example.chapter02;

import java.math.BigDecimal;

@FunctionalInterface
interface InvalidFunctionalInterface {
    <T> String mkString(T value);
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

public class MyFunctionalInterface2 {
    public static void main(String[] args) {
        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));

        InvalidFunctionalInterface anonymousClass = new InvalidFunctionalInterface() {
            @Override
            public <T> String mkString(T value) {
                return value.toString();
            }
        };
        System.out.println("anonymous class: " + anonymousClass.mkString(123));

//        InvalidFunctionalInterface invalidFunctionalInterface = value -> value.toString();
//        System.out.println(invalidFunctionalInterface.mkString(123));
    }
}
