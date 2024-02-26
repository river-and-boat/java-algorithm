package com.yuzhou.structure.tree.binary.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinaryTreeTest {
    /**
     * input: 10 20 1 4 25
     * output: null 10 1 20 null 4 null 25
     * @throws Exception
     */
    @Test
    public void should_build_binary_tree_with_array() throws Exception {
        BinaryTree<Integer> array = new BinaryTree<>();
        array.insert(10);
        array.insert(20);
        array.insert(1);
        array.insert(4);
        array.insert(25);


        assertEquals("10 1 20 4 25", array.string());
    }

    @Test
    public void should_return_given_data_or_null() throws Exception {
        BinaryTree<Integer> array = new BinaryTree<>();
        array.insert(10);
        array.insert(20);
        array.insert(1);
        array.insert(4);
        array.insert(25);

        assertEquals(1, array.search(1));
        assertNull(array.search(30));
    }
}