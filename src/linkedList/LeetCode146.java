package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache 구현
 * node 추가, 삭제, 노드 이용시 맨 앞으로 이동 등의 연산이 O(1) 이 될수 있도록 이중링크드리스트를 활용한다.
 * */
class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
}

public class LeetCode146 {
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;
    private DLinkedNode head, tail;

    public void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);

    }

    public LeetCode146(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        //Double LinkedList head <-> tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            moveToHead(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            moveToHead(node);
        } else {
            DLinkedNode node = new DLinkedNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            addNode(node);
            size++;

            resizeCache();
        }
        System.out.println(cache);
    }

    public void resizeCache() {
        if (size > capacity) {
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
            size--;
        }
    }
}
