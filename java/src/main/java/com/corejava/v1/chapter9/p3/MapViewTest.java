package com.corejava.v1.chapter9.p3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 方法：
 * 键集：Set<K> keySet()
 * 值集合（不是一个集）：Collection<V> values()
 * 键/值对集：Set<Map.Entry<K,V>> entrySet()
 *
 * @author liubf
 * @date 2024/3/29
 */
@Slf4j
public class MapViewTest {

    @Test
    public void testView(){
        Map<String,String> cache = new LinkedHashMap<String,String>(128,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 100;
            }
        };

        for (int i = 0; i < 1000; i++) {
            cache.put("k"+i,"v"+i);
        }
        cache.forEach((k,v)->{
            System.out.println(k+","+v);
        });
    }
}
