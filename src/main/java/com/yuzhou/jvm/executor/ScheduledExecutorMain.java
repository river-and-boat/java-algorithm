package com.yuzhou.jvm.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorMain {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        service.schedule(() -> {
            System.out.println("schedule ===> task 1");
        }, 2, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(() -> {
            System.out.println("schedule ===> task 2");
        }, 2, 3, TimeUnit.SECONDS);

        service.scheduleWithFixedDelay(() -> {
            System.out.println("schedule ===> task 3");
        }, 2, 3, TimeUnit.SECONDS);
    }
}
