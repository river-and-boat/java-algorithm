package com.yuzhou.structure.link.doubles;

public class LinkedList<T> {
    private Node<T> head;

    private Node<T> tail;

    public LinkedList() {
        // initialize sentinel node
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.previous = head;
    }

    /**
     * 向链表中添加元素
     *
     * @param data 给定植
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        head.next.previous = newNode;
        newNode.next = head.next;
        head.next = newNode;
        newNode.previous = head;
    }

    /**
     * 根据元素值删除元素
     *
     * @param value 给定植
     */
    public void deleteByValue(T value) {
        Node<T> current = head.next;
        while (current != tail) {
            if (current.data == value) {
                deleteNode(current);
                break;
            }
            current = current.next;
        }
    }

    /**
     * 根据Index删除元素
     *
     * @param index index
     */
    public void deleteByIndex(int index) {
        if (head.next == tail) {
            System.out.println("empty link");
        }
        Node<T> current = head.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        deleteNode(current);
    }

    /**
     * 链表逆序
     */
    public void reverse() {
        Node<T> newHead = new Node<>();
        Node<T> newTail = new Node<>();
        newHead.next = newTail;
        newTail.previous = newHead;

        Node<T> current = head.next;

        while (current != tail) {
            Node<T> newCurrent = new Node<>(current.data);

            newHead.next.previous = newCurrent;
            newCurrent.next = newHead.next;
            newHead.next = newCurrent;
            newCurrent.previous = newHead;

            current = current.next;
        }

        head = newHead;
        tail = newTail;
    }

    /**
     * 利用快慢指针法返回链表中间节点
     *
     * @return 中间节点
     */
    public Node<T> middleNode() {
        return new Node<>();
    }

    /**
     * 判断链表是否为环状链表
     */
    public void isCycle() {

    }


    private void deleteNode(Node<T> targetNode) {
        Node<T> previous = targetNode.previous;
        Node<T> next = targetNode.next;
        previous.next = targetNode.next;
        next.previous = targetNode.previous;
    }

    public String string() {
        StringBuilder builder = new StringBuilder();
        Node<T> current = head.next;
        while (current != tail) {
            builder.append(current.data);
            builder.append(" ");
            current = current.next;
        }
        return builder.toString().trim();
    }
}
