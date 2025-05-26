package org.example.myapp;

public class GenericClassTutorial {
    public static void main(String[] args) {
        // 문자열을 담는 박스
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        String str = stringBox.get();
        System.out.println("String Box: " + str);

        // 정수를 담는 박스
        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        Integer num = intBox.get();
        System.out.println("Integer Box: " + num);
    }
}

// 제네릭 클래스 정의
class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}
