package com.yuzhou.structure.tree.binary.linked;

class TreeNode<T extends Comparable<T>> {
    T data;

    TreeNode<T> leftChild;

    TreeNode<T> rightChild;

    TreeNode(T data) {
        this(null, null, data);
    }

    TreeNode(TreeNode<T> leftChild, TreeNode<T> rightChild, T data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }
}
