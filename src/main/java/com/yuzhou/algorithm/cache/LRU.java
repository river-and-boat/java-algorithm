package com.yuzhou.algorithm.cache;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    private static class DLinkedNode {
        public int key;
        public int value;
        public DLinkedNode prev;
        public DLinkedNode next;
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;

    public LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode(-1, -1);
        this.tail = new DLinkedNode(-1, -1);
        this.head.prev = null;
        this.head.next = tail;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNodeAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            addNodeAtHead(node);
            return;
        }
        if (size == capacity) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
        DLinkedNode newNode = new DLinkedNode(key, value);
        addNodeAtHead(newNode);
        cache.put(key, newNode);
        size++;
    }

    public void remove(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            cache.remove(key);
            removeNode(node);
            size--;
        }
    }

    public String string() {
        StringBuilder builder = new StringBuilder();
        DLinkedNode current = head.next;
        while (current != tail) {
            builder.append(current.value);
            builder.append(" ");
            current = current.next;
        }
        return builder.toString().trim();
    }

    /**
     * 删除给定节点
     *
     * @param node 待删除节点
     */
    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    /**
     * 头部插入节点
     *
     * @param node 插入节点
     */
    private void addNodeAtHead(DLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
