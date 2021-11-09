package xxl.algorithm.hash;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangliangbo
 * @since 2021/11/9
 **/


@Slf4j
public class LruCache {

    static class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode prev;

        public ListNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;
    private int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveToTail(node, node.value);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToTail(map.get(key), value);
        } else {
            if (map.size() == capacity) {
                ListNode toDelete = head.next;
                deleteNode(toDelete);

                map.remove(toDelete.key);
            }

            ListNode node = new ListNode(key, value);
            insertToTail(node);

            map.put(key, node);
        }
    }

    private void moveToTail(ListNode node, int newValue) {
        deleteNode(node);

        node.value = newValue;

        insertToTail(node);
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToTail(ListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(4);
        for (int i = 1; i <= 4; ++i) {
            lruCache.put(i, i);
        }
        System.err.println(lruCache.get(2));
        lruCache.put(1, 8);
        lruCache.put(5, 5);
        System.err.println(lruCache.map);
    }

}
