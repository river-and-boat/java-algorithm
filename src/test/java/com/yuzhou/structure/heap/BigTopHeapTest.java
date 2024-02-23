package com.yuzhou.structure.heap;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BigTopHeapTest {
    private final BigTopHeap bigTopHeap = new BigTopHeap();

    @Test
    public void should_get_max_value_with_index_1() {
        bigTopHeap.insert(2);
        bigTopHeap.insert(4);
        bigTopHeap.insert(7);
        bigTopHeap.insert(7);
        bigTopHeap.insert(1);
        bigTopHeap.insert(10);

        assertEquals(10, bigTopHeap.max());
        System.out.println(bigTopHeap.string());
    }

    @Test
    public void should_delete_top_value_and_keep_heap_structure() {
        bigTopHeap.insert(2);
        bigTopHeap.insert(4);
        bigTopHeap.insert(7);
        bigTopHeap.insert(7);
        bigTopHeap.insert(1);
        bigTopHeap.insert(10);

        bigTopHeap.deleteTop();

        assertEquals(7, bigTopHeap.max());
        System.out.println(bigTopHeap.string());
    }

    @Test
    public void should_delete_special_position_value_and_keep_heap_structure() {
        bigTopHeap.insert(2);
        bigTopHeap.insert(4);
        bigTopHeap.insert(7);
        bigTopHeap.insert(7);
        bigTopHeap.insert(1);
        bigTopHeap.insert(10);

        bigTopHeap.delete(4);

        System.out.println(bigTopHeap.string());
    }

    @Test
    public void should_sort_aes() {
        bigTopHeap.insert(2);
        bigTopHeap.insert(4);
        bigTopHeap.insert(7);
        bigTopHeap.insert(7);
        bigTopHeap.insert(1);
        bigTopHeap.insert(10);

        System.out.println("before sort: " + bigTopHeap.string());
        bigTopHeap.sort();
        System.out.println("after sort: " + bigTopHeap.string());
    }
}