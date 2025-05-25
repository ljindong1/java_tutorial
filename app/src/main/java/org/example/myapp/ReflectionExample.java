package org.example.myapp;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // 클래스 로딩
        Class<?> clazz = Class.forName("org.example.myapp.UserReflection");

        // 객체 생성
        Object user = clazz.getDeclaredConstructor().newInstance();

        // 필드 접근 및 값 설정
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true); // private 접근 허용
        field.set(user, "홍길동");

        // 메서드 실행
        Method method = clazz.getDeclaredMethod("sayHello");
        method.invoke(user); // 출력: 안녕하세요, 홍길동
    }
}

class UserReflection {
    private String name;

    public UserReflection() {
        this.name = "기본값";
    }

    public void sayHello() {
        System.out.println("안녕하세요, " + name);
    }
}