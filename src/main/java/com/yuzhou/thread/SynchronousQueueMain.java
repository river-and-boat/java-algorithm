package com.yuzhou.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueMain {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("开始设置第 " + i + "个元素");
                try {
                    TimeUnit.SECONDS.sleep(2);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("读取信息: " + queue.take() + "\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
