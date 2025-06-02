
package org.example.myapp;

import java.util.Optional;


public class OptionalTutorial {
    public static void main(String[] args) {
        User userWithEmail = new User("Alice", "alice@example.com");
        User userWithoutEmail = new User("Bob", null);

        printEmail(userWithEmail);
        printEmail(userWithoutEmail);
    }

    public static void printEmail(User user) {
        String email = user.getEmail() // ✔️ Optional<String> 반환
                .orElse("이메일이 없습니다"); // ✔️ 값이 없으면 기본값 제공
        System.out.println("이메일: " + email);
    }
}

class User {
    @SuppressWarnings("unused")
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email); // ✔️ null을 Optional로 감쌈
    }
}