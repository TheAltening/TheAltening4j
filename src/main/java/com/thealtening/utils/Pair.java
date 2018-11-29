package com.thealtening.utils;

/**
 * @author Trol
 * @since 1:04 PM, 11/29/18
 */

public class Pair<K, V> {

    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
