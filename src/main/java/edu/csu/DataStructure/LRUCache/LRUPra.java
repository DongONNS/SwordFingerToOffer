package edu.csu.DataStructure.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUPra extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUPra(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
