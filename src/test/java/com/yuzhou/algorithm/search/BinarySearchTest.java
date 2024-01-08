package com.yuzhou.algorithm.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    @Test
    public void should_find_given_data() throws Exception {
        Integer[] source = new Integer[]{1, 4, 5, 2, 11, 6, 9, 7, 8, 21, 100};
        Integer givenData = 11;
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Integer result = binarySearch.find(source, givenData);
        assertEquals(11, result);
    }

    @Test
    public void should_throw_exception_if_item_not_exist() {
        Integer[] source = new Integer[]{1, 4, 5, 2, 11, 6, 9, 7, 8, 21, 100};
        Integer givenData = 99;
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        Exception ex = assertThrowsExactly(Exception.class, () -> binarySearch.find(source, givenData));
        assertEquals("Item does not exist", ex.getMessage());
    }
}