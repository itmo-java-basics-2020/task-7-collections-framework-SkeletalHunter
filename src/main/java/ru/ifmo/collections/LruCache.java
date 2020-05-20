package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {

    private static final float LOAD_FACTOR = 1.0f;

    private final int capacity;
    private Map<K, V> LRUCache;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.LRUCache = new LinkedHashMap<>(capacity + 1, LOAD_FACTOR, false);
    }

    public V get(K key) {
        if(LRUCache.containsKey(key)){
            V returnValue = LRUCache.get(key);
            LRUCache.remove(key);
            LRUCache.put(key, returnValue);
            return returnValue;
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        if(LRUCache.size() >= capacity){
            LRUCache.remove(LRUCache.keySet().iterator().next());
        }
        LRUCache.put(key, value);
    }

    public int elements() {
        return LRUCache.size();
    }
}