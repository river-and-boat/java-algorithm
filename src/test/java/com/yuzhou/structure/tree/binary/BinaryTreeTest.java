package com.yuzhou.structure.tree.binary;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    private Integer[] arrays = new Integer[]{10, 8, 3, 12, 9, 4, 5, 7, 1,11, 17};

    @Test
    public void test() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        for (Integer item : arrays) {
            tree.insert(item);
        }
        System.out.println(tree.previous());
    }
}