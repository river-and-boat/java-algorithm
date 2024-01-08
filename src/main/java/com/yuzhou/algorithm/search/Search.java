package com.yuzhou.algorithm.search;

public interface Search<T extends Comparable<T>> {
    T find(T[] source,  T givenData) throws Exception;

    String algorithm();

    default int compare(T value1, T value2) {
        return value1.compareTo(value2);
    }
}
