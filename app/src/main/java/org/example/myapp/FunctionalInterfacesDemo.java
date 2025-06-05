/**
 * 이 클래스는 Java의 주요 함수형 인터페이스(Predicate, Function, Consumer,
 * Supplier, UnaryOperator, BinaryOperator)의 사용 예제를 포함합니다.
 * 각 예제는 별도의 정적 메서드로 제공됩니다.
 *
 * 함수형 인터페이스 요약:
 * Function<T, R>   → 입력을 받아 값을 반환
 * Consumer<T>      → 입력을 받아 동작을 수행하지만 반환은 없음 (void)
 * Supplier<T>      → 입력 없이 값만 반환
 * Predicate<T>     → 입력을 받아 boolean 반환
 *
 * @author GPT
 * @version 1.0
 */

package org.example.myapp;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        predicateExample();
        functionExample();
        consumerExample();
        supplierExample();
        unaryOperatorExample();
        binaryOperatorExample();
    }

    static void predicateExample() {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        System.out.println("Predicate Example:");
        System.out.println("'Hello': " + isLongerThan5.test("Hello"));
        System.out.println("'Functional': " + isLongerThan5.test("Functional"));
        System.out.println();
    }

    static void functionExample() {
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Function Example:");
        System.out.println("'Lambda' length: " + stringLength.apply("Lambda"));
        System.out.println();
    }

    static void consumerExample() {
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        System.out.println("Consumer Example:");
        printUpper.accept("java");
        System.out.println();
    }

    static void supplierExample() {
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Supplier Example:");
        System.out.println("Random value: " + randomSupplier.get());
        System.out.println();
    }

    static void unaryOperatorExample() {
        UnaryOperator<String> toUpperCase = str -> str.toUpperCase();
        System.out.println("UnaryOperator Example:");
        System.out.println("'java' -> " + toUpperCase.apply("java"));
        System.out.println();
    }

    static void binaryOperatorExample() {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("BinaryOperator Example:");
        System.out.println("10 + 20 = " + add.apply(10, 20));
        System.out.println();
    }    
}
