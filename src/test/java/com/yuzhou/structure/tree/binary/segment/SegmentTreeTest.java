package com.yuzhou.structure.tree.binary.segment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SegmentTreeTest {
    @Test
    public void should_build_segment_tree_successful() {
        int[] array = new int[]{1, 2, 3, 10, 6, 9, 20, 11, 7, 8};
        SegmentTree tree = new SegmentTree(array);
        tree.toTreeString();
    }

    @Test
    public void should_return_max_value_in_segment_tree() {
        int[] array = new int[]{1, 2, 3, 10, 6, 9, 20, 11, 7, 8};
        SegmentTree tree = new SegmentTree(array);

        int max0To4 = tree.searchMax(0, 4);
        assertEquals(10, max0To4);
        int max0To8 = tree.searchMax(0, 8);
        assertEquals(20, max0To8);
    }
}