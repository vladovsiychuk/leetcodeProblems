package lfu_cache_460;

import java.util.*;

class LFUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    TreeSet<Node> counts = new TreeSet<>((a,b)->a.count-b.count);
    Node head = new Node();
    Node tail = new Node();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        join(head, tail);
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        int result = map.get(key).value;
        delete(node);
        node.count++;
        putNode(node);
        return result;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = new Node();
        if (!map.containsKey(key) && map.keySet().size() < capacity){
            node = new Node(key,value);
        } else if (!map.containsKey(key)) {
            delete(head.next);
            node = new Node(key, value);
        } else{
            node = map.get(key);
            delete(node);
            node.value = value;
        }
        node.count++;
        putNode(node);
    }

    private void join (Node a, Node b){
        a.next = b;
        b.previous = a;
    }

    private void delete(Node node){
        map.remove(node.key);
        if (node.previous == head || node.count != node.previous.count) {
            counts.remove(node);
            if (node.next != tail)
                counts.add(node.next);
        }
        join(node.previous, node.next);
    }

    private void putNode (Node node){
        map.put(node.key, node);
        Node pointer = counts.higher(node);

        if (pointer == null)
            pointer = tail;

        putBetween(pointer.previous, node, pointer);
        updateCounters(node);
    }

    private void updateCounters(Node node) {
        if (node.previous == head || node.previous.count != node.count)
            counts.add(node);
    }

    private void putBetween (Node a, Node x, Node b){
        x.next = b;
        b.previous = x;
        x.previous = a;
        a.next = x;
    }

    class Node{
        int key;
        int value;
        int count = 0;
        Node previous;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", count=" + count +
                    '}';
        }

        Node (int key, int value){
            this.value = value;
            this.key = key;
        }
        Node (){};
    }
}


