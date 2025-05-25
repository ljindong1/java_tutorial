package org.example.myapp;

public class TaskRunner {
    @RunImmediately("시작 작업 실행")
    public void startTask() {
        System.out.println("startTask 실행됨");
    }

    public void noAnnotationMethod() {
        System.out.println("이 메서드는 애노테이션 없음");
    }
}