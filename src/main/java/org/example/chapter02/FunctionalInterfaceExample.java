package org.example.chpater02;

import java.util.function.Function;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        Function<String, Integer> toInt = value -> Integer.parseInt(value);

        Integer number = toInt.apply("100");
        System.out.println("number = " + number);

        Function<Integer, Integer> identity = t -> t;
        System.out.println("identity = " + identity.apply(999));
    }
}