package com.yuzhou.structure.tree.redblack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RBTreeTest {
    @Test
    public void should_add_node_in_rb_tree_successful() {
        RBTree<String> bst = new RBTree<>();
        bst.addNode("d");
        bst.addNode("d");
        bst.addNode("c");
        bst.addNode("c");
        bst.addNode("b");
        bst.addNode("f");

        bst.addNode("a");
        bst.addNode("e");

        bst.addNode("g");
        bst.addNode("h");

        bst.printTree(bst.getRoot());
    }

    @Test
    public void should_find_given_value_in_rb_tree() {
        RBTree<String> bst = new RBTree<>();
        bst.addNode("d");
        bst.addNode("d");
        bst.addNode("c");
        bst.addNode("c");
        bst.addNode("b");
        bst.addNode("f");

        bst.addNode("a");
        bst.addNode("e");

        bst.addNode("g");
        bst.addNode("h");

        String actual = bst.find("d");
        assertEquals("d", actual);
    }
}