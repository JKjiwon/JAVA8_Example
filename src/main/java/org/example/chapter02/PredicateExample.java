package org.example.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);

        Predicate<Integer> isPositive = i -> i > 0;
        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (isPositive.test(num)) {
                positiveNumbers.add(num);
            }
        }
        System.out.println("positive integers = " + positiveNumbers);


        Predicate<Integer> lessThan3 = i -> i < 3;
        List<Integer> numbersLessThan3 = new ArrayList<>();
        for (Integer num : numbers) {
            if (lessThan3.test(num)) {
                numbersLessThan3.add(num);
            }
        }
        System.out.println("less than 3 = " + numbersLessThan3);


        // filter 함수 이용
        System.out.println("positive integers = " + filter(numbers, isPositive));
        System.out.println("less than 3 = " + filter(numbers, lessThan3));

        System.out.println("less than 3 = " + filter(numbers, i -> i < 3));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if (filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }
}