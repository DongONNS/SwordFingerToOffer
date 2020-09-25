package edu.csu.DataStructure.LFUCache;

public class LFRCacheTest {
    public static void main(String[] args) {
        LFUCache4 cache = new LFUCache4(2);

        cache.put(1, 1);
        cache.put(2, 2);

        // 返回 1
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 去除 key 2

        // 返回 -1 (未找到key 2)
        System.out.println(cache.get(2));

        // 返回 3
        System.out.println(cache.get(3));

        cache.put(4, 4);    // 去除 key 1

        // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(1));

        // 返回 3
        System.out.println(cache.get(3));

        // 返回 4
        System.out.println(cache.get(4));
    }
}
