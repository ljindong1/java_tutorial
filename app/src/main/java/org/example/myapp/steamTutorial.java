package org.example.myapp;

import java.util.Arrays;
import java.util.List;

public class steamTutorial {
    public static void main(String[] args) {
                // ✅ 초급: 숫자 리스트 필터링 및 출력
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("[초급] 짝수 제곱 출력:");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .map(n -> n * n)
               .forEach(System.out::println);

        // ✅ 중급: 문자열 리스트 정렬 및 필터링
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        System.out.println("\n[중급] 이름 길이 4 이상 정렬 출력:");
        names.stream()
             .filter(name -> name.length() >= 4)
             .sorted()
             .forEach(System.out::println);

        // ✅ 고급: 객체 리스트에서 조건 필터링 및 매핑
        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 22),
            new Person("Diana", 28)
        );
        System.out.println("\n[고급] 나이 24 이상인 사람 이름:");
        people.stream()
              .filter(p -> p.getAge() >= 24)
              .map(Person::getName)
              .forEach(System.out::println);

    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    } 

}
