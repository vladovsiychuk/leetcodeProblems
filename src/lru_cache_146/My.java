package lru_cache_146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//class LRUCache {
//
//    HashMap<Integer,Integer> cache = new HashMap<>();
//    int capacity;
//    List<Integer> leastRecents = new ArrayList<>();
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        System.out.println("list size: " + leastRecents.size());
//        if (!cache.containsKey(key))
//            return -1;
//
//        leastRecents.remove(Integer.valueOf(key));
//        leastRecents.add(0, Integer.valueOf(key));
//        return cache.get(key);
//    }
//
//    public void put(int key, int value) {
//        if (leastRecents.size() < capacity && !cache.containsKey(key)) {
//            cache.put(key, value);
//            leastRecents.add(0, Integer.valueOf(key));
//            return;
//        }
//
//        if (cache.containsKey(key)){
//            leastRecents.remove(Integer.valueOf(key));
//            leastRecents.add(0,key);
//            cache.put(key, value);
//            return;
//        }
//
//        int leastKey = leastRecents.get(leastRecents.size()-1);
//        cache.remove(leastKey);
//        leastRecents.remove(leastRecents.size()-1);
//        cache.put(key, value);
//        leastRecents.add(0,Integer.valueOf(key));
//    }
//}
