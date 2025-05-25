package org.example.myapp;

import java.lang.reflect.*;

public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        TaskRunner task = new TaskRunner();
        Method[] methods = TaskRunner.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately ann = method.getAnnotation(RunImmediately.class);
                System.out.println("[애노테이션 메시지] " + ann.value());
                method.invoke(task); // 해당 메서드 실행
            }
        }
    }
}
