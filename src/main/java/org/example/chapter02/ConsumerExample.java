package org.example.chapter02;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> greetings = value -> System.out.println("Hello " + value);
        greetings.accept("World");
        greetings.accept("Jiwon");
    }
}
