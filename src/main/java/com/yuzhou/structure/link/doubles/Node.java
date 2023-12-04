package com.yuzhou.structure.link.doubles;

class Node<T> {
    public Node<T> previous;

    public Node<T> next;

    public T data;

    public Node() {

    }

    public Node(T data) {
        this.data = data;
    }

    public Node(Node<T> previous, Node<T> next, T data) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }
}
