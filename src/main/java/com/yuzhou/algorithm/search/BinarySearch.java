package com.yuzhou.algorithm.search;

import com.yuzhou.algorithm.sort.QuickSort;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {
    private final QuickSort<T> quickSort = new QuickSort<>();

    @Override
    public T find(T[] source, T givenData) throws Exception {
        T[] sortedSource = quickSort.sort(source);
        return doFind(0, sortedSource.length - 1, sortedSource, givenData);
    }

    private T doFind(int start, int end, T[] source,  T givenData) throws Exception {
        if (start > end) {
            throw new Exception("Item does not exist");
        }
        int middle = start + (end - start) / 2;
        if (compare(givenData, source[middle]) > 0) {
            return doFind(middle + 1, end, source, givenData);
        }
        if (compare(givenData, source[middle]) < 0) {
            return doFind(start, middle - 1, source, givenData);
        }
        return source[middle];
    }

    @Override
    public String algorithm() {
        return "binary-search";
    }
}
