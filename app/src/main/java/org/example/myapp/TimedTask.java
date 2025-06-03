package org.example.myapp;

public class TimedTask {
    @LogExecutionTime
    public void heavyTask() throws InterruptedException {
        Thread.sleep(500); // 무거운 작업 시뮬레이션
        System.out.println("작업 완료");
    }
}
