package com.yuzhou.structure.hashtable;

import com.yuzhou.structure.link.single.LinkedList;

public class HashTable<T> {
    private final LinkedList[] source = new LinkedList[10];

    public void put(T value) {
        var hashKey = hash(value);
        var linked = source[hashKey];
        if (linked == null) {
            linked = new LinkedList<>();
            source[hashKey] = linked;
        }
        if (linked.get(value) == null) {
            linked.add(value);
        }
    }

    public T get(T value) {
        var hashKey = hash(value);
        var linked = source[hashKey];
        return (T) linked.get(value);
    }

    private int hash(Object object) {
        return object.hashCode() % source.length;
    }
}
