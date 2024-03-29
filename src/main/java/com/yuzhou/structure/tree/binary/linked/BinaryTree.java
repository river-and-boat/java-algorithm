package com.yuzhou.structure.tree.binary.linked;

public class BinaryTree<T extends Comparable<T>> {
    private TreeNode<T> root = null;

    public void insert(T value) {
        if (value == null) {
            return;
        }
        root = insert(root, value);
    }

    /**
     * 先序遍历
     * root - left - right
     *
     * @return 先序遍历结果
     */
    public String previous() {
        StringBuilder sb = new StringBuilder();
        doPrevious(root, sb);

        return sb.toString().trim();
    }

    private void doPrevious(TreeNode<T> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.data).append(" ");
        doPrevious(node.leftChild, sb);
        doPrevious(node.rightChild, sb);
    }

    /**
     * 中序遍历
     * left - root - right
     *
     * @return 中序遍历结果
     */
    public String middle() {
        StringBuilder sb = new StringBuilder();
        doMiddle(root, sb);
        return sb.toString().trim();
    }

    private void doMiddle(TreeNode<T> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        doMiddle(node.leftChild, sb);
        sb.append(node.data).append(" ");
        doMiddle(node.rightChild, sb);
    }

    /**
     * 后序遍历
     * left - right - middle
     *
     * @return 后序遍历结果
     */
    public String after() {
        StringBuilder sb = new StringBuilder();
        doAfter(root, sb);
        return sb.toString().trim();
    }

    private void doAfter(TreeNode<T> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        doAfter(node.leftChild, sb);
        doAfter(node.rightChild, sb);
        sb.append(node.data).append(" ");
    }

    private TreeNode<T> insert(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }
        // value小于node中存储的值，向左子树存储
        if (compare(node, value) < 0) {
            node.leftChild = insert(node.leftChild, value);
        } else {
            node.rightChild = insert(node.rightChild, value);
        }
        return node;
    }

    private int compare(TreeNode<T> node, T value) {
        return value.compareTo(node.data);
    }
}
