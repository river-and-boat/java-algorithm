package com.yuzhou.structure.tree.binary;

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
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        sb.append(" ");

        doPrevious(root, sb);

        return sb.toString().trim();
    }

    private void doPrevious(TreeNode<T> node, StringBuilder sb) {
        doPreviousLeft(node, sb);
        doPreviousRight(node, sb);
    }

    private void doPreviousLeft(TreeNode<T> node, StringBuilder sb) {
        node = node.leftChild;
        if (node != null) {
            sb.append(node.data);
            sb.append(" ");
            doPrevious(node, sb);
        }
    }

    private void doPreviousRight(TreeNode<T> node, StringBuilder sb) {
        node = node.rightChild;
        if (node != null) {
            sb.append(node.data);
            sb.append(" ");
            doPrevious(node, sb);
        }
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
