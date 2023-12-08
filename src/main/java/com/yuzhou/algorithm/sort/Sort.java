package com.yuzhou.algorithm.sort;

public interface Sort<T extends Comparable<T>> {
    T[] sort(T[] source);
    String algorithmName();

    /**
     * @param value1 待比较参数1
     * @param value2 待比较参数2
     *
     * @return 比较结果
     * result > 0 : value1 > value2
     * result = 0 : value1 = value2
     * result < 0 : value1 < value2
     */
    default int compare(T value1, T value2) {
        return value1.compareTo(value2);
    }
}
