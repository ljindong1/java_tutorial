package org.example.myapp;

import java.lang.reflect.*;

public class LogProcessor {
    public static void main(String[] args) throws Exception {
        TimedTask task = new TimedTask();
        Method[] methods = TimedTask.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.currentTimeMillis();
                method.invoke(task);
                long end = System.currentTimeMillis();
                System.out.println("실행 시간: " + (end - start) + "ms");
            }
        }
    }
}
