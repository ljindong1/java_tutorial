package org.example.myapp;

import java.lang.reflect.Method;

public class ManualAnnotationProcessor {
    public static void main(String[] args) throws Exception {
        AnnotationService service = new AnnotationService();

        for (Method method : AnnotationService.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.currentTimeMillis();

                method.invoke(service); // 메서드 실행

                long end = System.currentTimeMillis();
                System.out.println(method.getName() + " executed in " + (end - start) + "ms");
            } else {
                // 애노테이션이 없는 메서드는 그냥 호출
                method.invoke(service);
            }
        }
    }
}
