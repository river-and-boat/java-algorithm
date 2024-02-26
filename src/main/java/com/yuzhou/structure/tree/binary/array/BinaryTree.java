package com.yuzhou.structure.tree.binary.array;

import java.lang.reflect.Array;

public class BinaryTree<T extends Comparable<T>> {
    private static final int DEFAULT_SIZE = 100;

    int count = 0;

    int capacity;

    private T[] data;

    public BinaryTree() {
        this(Integer.class, DEFAULT_SIZE);
    }

    public BinaryTree(Class clazz, int capacity) {
        this.data = (T[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
    }

    public void insert(T data) throws Exception {
        if (count >= capacity) {
            throw new Exception("array limitation");
        }
        int index = 1;
        while (index <= capacity) {
            T current = this.data[index];
            if (current == null) {
                this.data[index] = data;
                count++;
                return;
            }
            if (compare(current, data) < 0) {
                // 左子树
                index = 2 * index;
            } else {
                // 右子树
                index = 2 * index + 1;
            }
        }
    }

    public T search(T data) {
        int index = 1;
        while (index <= capacity) {
            T current = this.data[index];
            if (current == null) {
                return null;
            }
            if (compare(current, data) == 0) {
                return current;
            }
            if (compare(current, data) < 0) {
                // 左子树
                index = 2 * index;
            }
            else {
                // 右子树
                index = 2 * index + 1;
            }
        }
        return null;
    }

    public void delete(T data) {
        
    }

    public String string() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < capacity; i++) {
            if (data[i] != null) {
                builder.append(data[i]);
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    private int compare(T node, T value) {
        return value.compareTo(node);
    }
}
