package org.example.myapp;

import java.lang.reflect.*;

public class ReflectionJsonExample {
    public static void main(String[] args) throws Exception {
        Person person = new Person("홍길동", 30);

        // 직렬화: 객체 → JSON 문자열
        String json = serializeToJson(person);
        System.out.println("직렬화 결과: " + json);

        // 역직렬화: JSON 문자열 → 객체
        Person deserialized = (Person) deserializeFromJson(json, Person.class);
        deserialized.sayHello();
    }

    // 객체를 JSON 문자열로 변환
    static String serializeToJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder("{");

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            sb.append("\"").append(field.getName()).append("\":");
            sb.append("\"").append(field.get(obj)).append("\",");
        }
        if (sb.charAt(sb.length() - 1) == ',')
            sb.setLength(sb.length() - 1); // 마지막 쉼표 제거
        sb.append("}");
        return sb.toString();
    }

    // JSON 문자열을 객체로 변환 (단순한 key-value만 처리)
    static Object deserializeFromJson(String json, Class<?> clazz) throws Exception {
        Object obj = clazz.getDeclaredConstructor().newInstance();
        json = json.replaceAll("[{}\"]", "");
        String[] pairs = json.split(",");

        for (String pair : pairs) {
            String[] kv = pair.split(":");
            Field field = clazz.getDeclaredField(kv[0].trim());
            field.setAccessible(true);

            if (field.getType() == int.class) {
                field.set(obj, Integer.parseInt(kv[1].trim()));
            } else {
                field.set(obj, kv[1].trim());
            }
        }

        return obj;
    }

    // 내부 클래스: 직렬화 대상
    static class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void sayHello() {
            System.out.println("안녕하세요, 저는 " + name + "이고 나이는 " + age + "살입니다.");
        }
    }
}
