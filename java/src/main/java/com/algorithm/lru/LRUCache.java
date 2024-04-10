package com.algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存类
 * 基于哈希表和双向链表
 * @author liubf
 * @date 2024/1/23
 */
public class LRUCache<K, V> {

    private int capacity;    // 缓存容量
    private Map<K, Node<K, V>> map;    // 哈希表
    private Node<K, V> head;    // 双向链表头节点
    private Node<K, V> tail;    // 双向链表尾节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        // 初始化双向链表
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * 添加数据到缓存中
     */
    public void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            // 如果已经存在该节点，则将其移动到链表头部:在原位置上删除，在头部添加
            removeNode(node);
        } else {
            // 如果不存在该节点，则需要添加新节点
            node = new Node<>(key, value);
            map.put(key, node);
            if (map.size() > capacity) {
                // 如果缓存已满，则需要淘汰最近最少使用的节点
                Node<K, V> removedNode = removeLast();
                map.remove(removedNode.key);
            }
        }
        // 将新节点添加到链表头部
        addFirst(node);
    }

    /**
     * 从缓存中获取数据
     */
    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            // 如果存在该节点，则将其移动到链表头部，并返回其值
            removeNode(node);
            addFirst(node);
            return node.value;
        }
        return null;
    }

    /**
     * 获取当前缓存的大小
     */
    public int size() {
        return map.size();
    }

    /**
     * 清空缓存
     */
    public void clear() {
        map.clear();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 从双向链表中移除指定节点
     */
    private void removeNode(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将节点添加到双向链表头部
     */
    private void addFirst(Node<K, V> node) {
        node.prev = head;
        head.next.prev = node;

        node.next = head.next;
        head.next = node;
    }

    /**
     * 从双向链表尾部移除节点，并返回该节点
     */
    private Node<K, V> removeLast() {
        Node<K, V> node = tail.prev;
        if (node == head) {
            return null;
        }
        removeNode(node);
        return node;
    }
}

/**
 * 双向链表节点类
 * @author liubf
 * @date 2024/1/23 14:34
 */
class Node<K, V> {
    K key;
    V value;

    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
