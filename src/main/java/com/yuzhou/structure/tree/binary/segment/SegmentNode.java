package com.yuzhou.structure.tree.binary.segment;

public class SegmentNode {
    public int start;

    public int end;

    public int max;

    public SegmentNode() {
    }

    public SegmentNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public SegmentNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
    }
}
