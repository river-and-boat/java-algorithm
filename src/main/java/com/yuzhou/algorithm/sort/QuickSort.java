package com.yuzhou.algorithm.sort;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public T[] sort(T[] source) {
        int left = 0;
        int right = source.length - 1;
        doQuickSort(source, left, right);
        return source;
    }

    private void doQuickSort(T[] source, int left, int right) {
        if (right <= left) {
            return;
        }
        int first = left;
        int last = right;

        T pivot = source[left];

        while (left != right) {
            while (right > left) {
                if (compare(source[right], pivot) < 0) {
                    source[left] = source[right];
                    left++;
                    break;
                }
                right--;
            }
            while (right > left) {
                if (compare(pivot, source[left]) < 0) {
                    source[right] = source[left];
                    right--;
                    break;
                }
                left++;
            }
        }
        source[left] = pivot;

        doQuickSort(source, first, left - 1);
        doQuickSort(source, right + 1, last);
    }

    @Override
    public String algorithmName() {
        return "quick-sort";
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
