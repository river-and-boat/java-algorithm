package com.yuzhou.algorithm.sort;

import java.util.ArrayList;

/**
 * 归并排序
 * 升序排列
 * [1, 3, 4, 6, 4, 2, 7, 2, 1, 6]
 *
 * [1,3,4,6,4,2,7,2,1,6]
 * [1,3,4,6,4] [2,7,2,1,6]
 * [1,3,4] [6,4] [2,7,2] [1,6]
 * [1,3] [4] [6] [4] [2,7] [2] [1] [6]
 * [1] [3] [4] [6] [4] [2] [7] [2] [1] [6]
 * [1,3] [4] [6] [4] [2] [7] [2] [1] [6]
 * [1,3,4] [6] [4] [2] [7] [2] [1] [6]
 * [1,3,4] [4,6] [2] [7] [2] [1] [6]
 * [1,3,4,4,6] [2] [7] [2] [1] [6]
 * [1,3,4,4,6] [2,7] [2] [1] [6]
 * [1,3,4,4,6] [2,2,7] [1] [6]
 * [1,3,4,4,6] [2,2,7] [1,6]
 * [1,3,4,4,6] [1,2,2,6,7]
 * [1,1,2,2,3,4,4,6,6,7]
 *
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public T[] sort(T[] source) {
        // 获取index开始
        int start = 0;
        // 获取index结束
        int end = source.length - 1;

        split(start, end, source);
        return source;
    }

    private void split(int start, int end, T[] source) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        split(start, middle, source);
        split(middle + 1, end, source);
        merge(start, middle, end, source);
    }

    private void merge(int start, int middle, int end, T[] source) {
        int index = 0;
        ArrayList<T> tempResult = new ArrayList<>(end - start + 1);

        int indexPrefix = start;
        int indexSuffix = middle + 1;

        while (indexPrefix <= middle && indexSuffix <= end) {
            if (compare(source[indexPrefix], source[indexSuffix]) <= 0) {
                tempResult.add(index, source[indexPrefix]);
                indexPrefix++;
            } else {
                tempResult.add(index, source[indexSuffix]);
                indexSuffix++;
            }
            index++;
        }

        while (indexPrefix <= middle) {
            tempResult.add(index++, source[indexPrefix++]);
        }

        while (indexSuffix <= end) {
            tempResult.add(index++, source[indexSuffix++]);
        }

        for (int t = 0; t < index; t++) {
            source[start + t] = tempResult.get(t);
        }
    }

    @Override
    public String algorithmName() {
        return "merge-sort";
    }

    /**
     * @param value1 待比较参数1
     * @param value2 待比较参数2
     *
     * @return 比较结果
     * result > 0 : value1 > value2
     * result = 0 : value1 = value2
     * result < 0 : value1 < value2
     */
    private int compare(T value1, T value2) {
        return value1.compareTo(value2);
    }
}
