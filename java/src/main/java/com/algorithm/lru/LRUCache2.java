package com.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存类
 * 基于LinkedHashMap
 * @author liubf
 * @date 2024/1/23
 */
public class LRUCache2 extends LinkedHashMap {

    protected int maxSize;

    public LRUCache2(int maxSize) {
        super(maxSize,0.75F,true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest){
        return size() > this.maxSize;
    }
}
