package com.yuzhou.jvm;

import java.lang.ref.WeakReference;

public class WeakReferenceMain {

    private static WeakReference<String> weakReference;

    public static void main(String[] args) {
        partialVariableStringReference();
        System.out.println("gc stop: " + weakReference.get());

        // 局部变量随着方法结束而被清理，因此弱引用会在此时被清理
        System.gc();

        System.out.println("gc processing: " + weakReference.get());
    }

    private static void partialVariableStringReference() {
        String hi = "Hi World";
        weakReference = new WeakReference<>(hi);
        // 由于hi这个字符串局部变量此时不仅被弱引用了，还有强引用，因此此时gc不会清除
        System.gc();
        System.out.println("gc processing: " + weakReference.get());
    }
}
