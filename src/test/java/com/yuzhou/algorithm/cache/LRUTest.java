package com.yuzhou.algorithm.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUTest {
    @Test
    public void should_lru_add_node() {
        LRU lru = new LRU(5);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);

        assertEquals("5 4 3 2 1", lru.string());
    }

    @Test
    public void should_lru_update_node() {
        LRU lru = new LRU(5);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);

        int value = lru.get(3);

        assertEquals(3, value);
        assertEquals("3 5 4 2 1", lru.string());
    }

    @Test
    public void should_evi_last_item_if_size_is_reach_capacity() {
        LRU lru = new LRU(5);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);

        assertEquals("6 5 4 3 2", lru.string());
    }

    @Test
    public void should_replace_value_if_key_is_the_same() {
        LRU lru = new LRU(5);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);

        lru.put(3, 6);

        assertEquals("6 5 4 2 1", lru.string());
    }

    @Test
    public void should_remove_item() {
        LRU lru = new LRU(5);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);

        lru.remove(3);

        assertEquals("5 4 2 1", lru.string());
    }
}