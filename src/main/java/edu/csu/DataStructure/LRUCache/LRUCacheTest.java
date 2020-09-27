package edu.csu.DataStructure.LRUCache;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);

        System.out.println(lruCache);
    }
}
