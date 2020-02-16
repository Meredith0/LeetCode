package 模拟面试1;

import java.util.HashMap;

/**
 * @author : Meredith
 * @date : 2019-08-19 00:12
 * @description :
 *     运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *     <p>
 *     获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *     写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *     <p>
 *     进阶:
 *     <p>
 *     你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *     <p>
 *     示例:
 *     <p>
 *     LRUCache cache = new LRUCache( 2 /* 缓存容量 )
 *     <p>
 *     cache.put(1, 1);
 *     cache.put(2, 2);
 *     cache.get(1);       // 返回  1
 *     cache.put(3, 3);    // 该操作会使得密钥 2 作废
 *     cache.get(2);       // 返回 -1 (未找到)
 *     cache.put(4, 4);    // 该操作会使得密钥 1 作废
 *     cache.get(1);       // 返回 -1 (未找到)
 *     cache.get(3);       // 返回  3
 *     cache.get(4);       // 返回  4
 */
public class q146_LRUCache {

    public static void main (String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // 返回  1
        cache.put(3, 3);    // 该操作会使得2移除
        System.out.println(cache.get(2));     // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得1移除
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        cache.put(2, 1);
        System.out.println(cache.get(2));
    }
    static class LRUCache {

        int key;
        int value;
        linkedList list;
        private int capacity;
        private HashMap<Integer, Node> map;

        public LRUCache (int capacity) {
            this.map = new HashMap<>();
            this.list = new linkedList();
            this.capacity = capacity;
        }

        public int get (int key) {
            if (map.containsKey(key)) {
                Node res = map.get(key);
                this.list.moveNode2Tail(res);
                return res.value;
            }
            return -1;
        }

        public void put (int key, int value) {

            if (map.containsKey(key)) {
                Node res = map.get(key);
                res.value = value;
                this.list.moveNode2Tail(res);
            } else {
                Node node = new Node(key, value);
                this.list.addNode(node);
                map.put(key, node);
                this.capacity--;
                if (this.capacity < 0) {
                    Node removed = this.list.removeHead();
                    map.remove(removed.key);
                    capacity++;
                }
            }
        }

    }

}

class Node {

    int key;
    int value;
    Node pre;
    Node next;

    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey () {
        return key;
    }

    public void setKey (int key) {
        this.key = key;
    }

    public int getValue () {
        return value;
    }

    public void setValue (int value) {
        this.value = value;
    }

}

class linkedList {

    Node head;
    Node tail;

    void addNode (Node node) {
        if (node == null) {
            return;
        }

        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.pre = this.tail;
            this.tail = node;
        }
    }

    void moveNode2Tail (Node node) {
        if (node == this.tail) {
            return;
        }

        if (this.head == node) {

            this.head = node.next;
            this.head.pre = null;

        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        node.pre = this.tail;
        node.next = null;
        this.tail.next = node;
        this.tail = node;

    }

    Node removeHead () {
        if (head == null) {
            return null;
        }
        Node old = this.head;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;

        } else {

            this.head = old.next;
            old.next = null;
            this.head.pre = null;
        }
        return old;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */