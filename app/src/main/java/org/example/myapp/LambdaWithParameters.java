package org.example.myapp;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class LambdaWithParameters {
    
    public static void main(String[] args) {
        // 덧셈
        MathOperation add = (a, b) -> a + b;
        /*
         * MathOperation add = new MathOperation() {
         * 
         * @Override
         * public int operate(int a, int b) {
         * return a + b;
         * }
         * };
         */
        // 뺄셈
        MathOperation subtract = (a, b) -> a - b;
        // 곱셈
        MathOperation multiply = (a, b) -> a * b;
        // 나눗셈 (0으로 나눔 방지)
        MathOperation divide = (a, b) -> b != 0 ? a / b : 0;
        // 테스트
        int x = 10, y = 2;
        System.out.println("덧셈: " + add.operate(x, y));
        System.out.println("뺄셈: " + subtract.operate(x, y));
        System.out.println("곱셈: " + multiply.operate(x, y));
        System.out.println("나눗셈: " + divide.operate(x, y));
    }
}