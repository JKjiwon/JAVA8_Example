package org.example.chapter02;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

// Lazy evaluation -> 불필요한 계산을 줄인다.
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> helloSupplier = () -> "Hello";
        System.out.println(helloSupplier.get() + " World");

        long start = System.currentTimeMillis();
        printIfValidIndexV2(0, () -> getVeryExpensiveValue());
        printIfValidIndexV2(-1, () -> getVeryExpensiveValue());
        printIfValidIndexV2(-2, () -> getVeryExpensiveValue());

        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds.");

    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Let's just say it has very expensive calculation here!
        return "Jiwon";
    }

    private static void printIfValidIndexV1(int number, String value) {
        if (number >= 0) {
            System.out.println("The value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    private static void printIfValidIndexV2(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }
}
