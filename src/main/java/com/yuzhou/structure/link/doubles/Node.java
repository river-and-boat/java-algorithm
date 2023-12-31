package com.yuzhou.structure.link.doubles;

class Node<T> {
    Node<T> previous;

    Node<T> next;

    T data;

    Node() {

    }

    Node(T data) {
        this.data = data;
    }

    Node(Node<T> previous, Node<T> next, T data) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }
}
