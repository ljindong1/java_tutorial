package org.example.myapp;

public class AnnotationService {
    @LogExecutionTime
    public void serve() {
        try {
            Thread.sleep(300); // 일부러 지연
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Service logic executed.");
    }

    public void noAnnotationMethod() {
        System.out.println("This method has no annotation.");
    }
    
}
