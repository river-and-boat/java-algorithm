package com.yuzhou.thread;

import java.util.Scanner;

public class ReentrantLockMain {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程启动");
            while (Counter.count == 0) {

            }
            System.out.println(Thread.currentThread().getName() + "线程退出");
        }, "t1").start();

        Thread.sleep(1000);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程启动");
            Scanner sc = new Scanner(System.in);
            System.out.println("input a number: ");
            Counter.count = sc.nextInt();
            System.out.println(Thread.currentThread().getName() + "线程退出");
        }, "t2").start();
    }

    static class Counter {
        public volatile static int count = 0;
    }
}
