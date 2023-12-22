package com.yuzhou.structure.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {
    @Test
    public void should_save_and_get_data_successful() {
        HashTable<Integer> table = new HashTable<>();

        table.put(1);
        table.put(2);
        table.put(3);
        table.put(4);
        table.put(5);
        table.put(1);

        var value = table.get(3);
        assertEquals(3, value);
    }
}