package com.yuzhou.algorithm.sort;

/**
 * 冒泡排序
 * O(n^2)
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    /**
     * 顺序排序
     *
     * @param source [1, 3, 4, 6, 4, 2, 7, 2, 1, 6]
     * @return 排序后的数组
     */
    @Override
    public T[] sort(T[] source) {
        int length = source.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (compare(source[j], source[j + 1]) > 0) {
                    T temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
        return source;
    }

    @Override
    public String algorithm() {
        return null;
    }
}
