package com.yuzhou.structure.tree.binary.segment;

/**
 * 线段树
 */
public class SegmentTree {

    private final SegmentNode[] segmentArray;

    public SegmentTree(int[] source) {
        segmentArray = new SegmentNode[source.length * 4];
        int start = 0;
        int end = source.length - 1;

        buildSegmentTree(source, start, end, 1);
    }

    private int buildSegmentTree(int[] source, int start, int end, int treeIndex) {
        if (start >= end) {
            int max = source[start];
            segmentArray[treeIndex] = new SegmentNode(start, end, max);
            return max;
        }
        int middle = (end + start) / 2;
        int leftMax = buildSegmentTree(source, start, middle, 2 * treeIndex);
        int rightMax = buildSegmentTree(source, middle + 1, end, 2 * treeIndex + 1);
        int max = Math.max(leftMax, rightMax);
        segmentArray[treeIndex] = new SegmentNode(start, end, max);
        return max;
    }

    public int searchMax(int start, int end) {
        return searchMax(start, end, 1);
    }

    private int searchMax(int start, int end, int treeIndex) {
        SegmentNode node = segmentArray[treeIndex];
        if (start <= node.start && node.end <= end) {
            return node.max;
        }
        int middle = (node.start + node.end) / 2;
        // 搜索左子树
        int max = Integer.MIN_VALUE;
        if (middle >= start) {
            max = Math.max(max, searchMax(start, end, 2 * treeIndex));
        }
        if (middle + 1 <= end) {
            max = Math.max(max, searchMax(start, end, 2 * treeIndex + 1));
        }
        return max;
    }

    public void toTreeString() {
        for (SegmentNode segment : segmentArray) {
            if (segment != null) {
                System.out.println("max value in segment: " + segment.start + " - " + segment.end + ":" + " " + segment.max);
            }
        }
    }
}
