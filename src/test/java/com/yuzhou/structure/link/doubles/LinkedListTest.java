package com.yuzhou.structure.link.doubles;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    @Test
    public void should_add_data_successful() {
        LinkedList<Integer> source = new LinkedList<>();

        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);

        String result = source.string();

        assertEquals("5 4 3 2 1", result);
    }

    @Test
    public void should_delete_data_by_value() {
        LinkedList<Integer> source = new LinkedList<>();

        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);

        source.deleteByValue(5);
        source.deleteByValue(1);

        String result = source.string();

        assertEquals("4 3 2", result);
    }

    @Test
    public void should_delete_data_by_index() {
        LinkedList<Integer> source = new LinkedList<>();

        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);

        source.deleteByIndex(0);

        String result = source.string();

        assertEquals("4 3 2 1", result);
    }

    @Test
    public void should_reverse_the_link_list() {
        LinkedList<Integer> source = new LinkedList<>();

        source.add(1);
        source.add(2);
        source.add(3);
        source.add(4);
        source.add(5);

        // result: 5 4 3 2 1
        String result = source.string();

        source.reverse();
        String resultReverse = source.string();
        assertEquals(new StringBuilder(result).reverse().toString(), resultReverse);
    }
}