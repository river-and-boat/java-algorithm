package com.yuzhou.structure.tree.redblack;

public class RBTreeNode<T extends Comparable<T>> {
    public T value;
    public RBTreeNode<T> left;
    public RBTreeNode<T> right;
    public RBTreeNode<T> parent;
    public boolean red;

    public RBTreeNode() {}

    public RBTreeNode(T value) {
        this.value = value;
    }

    public RBTreeNode(T value, boolean isRed) {
        this.value = value;
        this.red = isRed;
    }
}
