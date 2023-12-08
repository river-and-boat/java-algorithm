package com.yuzhou.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertSortTest {

    private final Integer[] source = new Integer[]{1, 3, 4, 6, 4, 2, 7, 2, 1, 6};

    @Test
    public void should_sort_aes() {
        Sort<Integer> insertSort = new InsertSort<>();
        Integer[] expected = new Integer[]{1, 1, 2, 2, 3, 4, 4, 6, 6, 7};

        Integer[] result = insertSort.sort(source);

        for (int index = 0; index < expected.length; index++) {
            assertEquals(expected[index], result[index]);
        }
    }
}