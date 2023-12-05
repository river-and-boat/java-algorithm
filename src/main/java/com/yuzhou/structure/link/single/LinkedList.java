package com.yuzhou.structure.link.single;

public class LinkedList<T> {
    private Node<T> head;

    private Node<T> tail;

    public LinkedList() {
        this.head = new Node<>();
        this.tail = new Node<>();
        head.next = tail;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void deleteByValue(T data) throws Exception {
        Node<T> previous = head;
        Node<T> current = head.next;

        if (current == tail) {
            throw new Exception("no item exists in link");
        }

        while (current != tail) {
            if (current.data == data) {
                previous.next = current.next;
                current.next = null;
                break;
            }
            previous = current;
            current = current.next;
        }
    }

    public void deleteByIndex(int index) throws Exception {
        Node<T> previous = head;
        Node<T> current = head.next;

        if (current == tail) {
            throw new Exception("no item exists in link");
        }

        for (int i = 0; i < index; i++) {
            if (current.next == tail) {
                throw new Exception("out of index");
            }
            previous = current;
            current = current.next;
        }

        previous.next = current.next;
        current.next = null;
    }

    public void reverse() {
        Node<T> current = head;
        Node<T> next = current.next;

        if (current.next == tail) {
            return;
        }

        while (current != tail) {
            Node<T> newNext = next.next;
            next.next = current;
            current = next;
            next = newNext;
        }
        head.next = null;
        tail = head;
        head = current;
    }

    public Node<T> middleNode() {
        return new Node<>();
    }

    public Boolean isCycle() {
        return false;
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
