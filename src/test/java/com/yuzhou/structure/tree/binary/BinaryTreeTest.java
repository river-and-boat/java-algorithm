package com.yuzhou.structure.tree.binary;

import com.yuzhou.structure.tree.binary.linked.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {
    private final Integer[] arrays = new Integer[]{10, 8, 3, 12, 9, 4, 5, 7, 1,11, 17};

    private BinaryTree<Integer> tree;

    @BeforeEach
    public void setup() {
        tree = new BinaryTree<>();
        for (Integer item : arrays) {
            tree.insert(item);
        }
    }

    @Test
    public void should_get_previous_foreach_result() {
        String expected = "10 8 3 1 4 5 7 9 12 11 17";

        String result = tree.previous();

        assertEquals(expected, result);
    }

    @Test
    public void should_get_middle_foreach_result() {
        String expected = "1 3 4 5 7 8 9 10 11 12 17";

        String result = tree.middle();

        assertEquals(expected, result);
    }

    @Test
    public void should_get_after_foreach_result() {
        String expected = "1 7 5 4 3 9 8 11 17 12 10";

        String result = tree.after();

        assertEquals(expected, result);
    }
}