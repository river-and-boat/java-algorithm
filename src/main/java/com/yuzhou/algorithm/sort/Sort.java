package com.yuzhou.algorithm.sort;

public interface Sort<T extends Comparable<T>> {
    T[] sort(T[] source);
    String algorithmName();
}
