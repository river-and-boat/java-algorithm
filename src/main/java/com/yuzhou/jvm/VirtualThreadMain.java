package com.yuzhou.jvm;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadMain {
    public static void main(String[] args) {
        var factory = Thread.ofVirtual().name("virtual-thread-test-", 1).factory();
        try(var executor = Executors.newCachedThreadPool(factory)) {
            IntStream.range(0, 10000).forEach(i -> {
                executor.submit(() -> {
                   Thread.sleep(Duration.ofSeconds(1));
                   return i;
                });
            });
        }
    }
}
