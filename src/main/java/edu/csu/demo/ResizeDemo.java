package edu.csu.demo;

public class ResizeDemo {

    private static int MAXIMUM_CAPACITY = Integer.MAX_VALUE;

    // HashMap的扩容机制
    static final int tableSizeForHashMap(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static final int tableSizeForConcurrentHashMap(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        int resH = tableSizeForHashMap(100);
        int resC = tableSizeForConcurrentHashMap(100);
        System.out.println("resH : " + resH);
        System.out.println("resC : " + resH);
    }
}
