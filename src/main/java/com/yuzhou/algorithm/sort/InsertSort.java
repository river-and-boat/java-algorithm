package com.yuzhou.algorithm.sort;

public class InsertSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public T[] sort(T[] source) {
        for (int i = 0; i < source.length; i++) {
            T indexValue = source[i];
            for (int j = i; j > 0; j--) {
                if (compare(indexValue, source[j - 1]) < 0) {
                    source[j] = source[j - 1];
                    continue;
                }
                source[j] = indexValue;
                break;
            }
        }
        return source;
    }

    @Override
    public String algorithmName() {
        return "insert-sort";
    }
}
