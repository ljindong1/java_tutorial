package org.example.myapp;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunImmediately {
    String value() default "메서드 실행";
}
