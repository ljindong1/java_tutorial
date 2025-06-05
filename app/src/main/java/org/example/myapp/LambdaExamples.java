package org.example.myapp;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExamples {
    public static void main(String[] args) {
        // 🔹 1. 메서드 참조 (Method Reference)
        System.out.println("=== Method Reference ===");
        List<String> list = List.of("A", "B", "C");
        list.forEach(System.out::println); // == list.forEach(s -> System.out.println(s));

        // 🔹 2. 람다식과 함수형 인터페이스
        System.out.println("\n=== Functional Interfaces ===");
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Square of 5: " + square.apply(5)); // 25

        Consumer<String> printer = s -> System.out.println("Hello " + s);
        printer.accept("Lambda"); // Hello Lambda

        Predicate<String> startsWithA = s -> s.startsWith("A");
        System.out.println("Starts with A? " + startsWithA.test("Apple")); // true

        // 🔹 3. 로컬 변수 캡처 (Closure)
        System.out.println("\n=== Local Variable Capture ===");
        int base = 10; // effectively final
        Function<Integer, Integer> adder = x -> x + base;
        System.out.println("Add 5 + base(10): " + adder.apply(5)); // 15
    }    
}
