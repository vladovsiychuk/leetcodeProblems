package lru_cache_146;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LRUCache {
    HashMap<Integer,Integer> cache = new HashMap<>();
    int capacity;
    List<Integer> leastRecents = new ArrayList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        int indKey = leastRecents.indexOf(key);
        int tmp = leastRecents.get(indKey);
        leastRecents.remove(indKey);
        leastRecents.add(0, tmp);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.keySet().size() < capacity) {
            cache.put(key, value);
            leastRecents.add(0, key);
            return;
        }

        if (cache.containsKey(key)){
            int indOfLeastKey = leastRecents.indexOf(key);
            int tmp = leastRecents.get(indOfLeastKey);
            leastRecents.remove(indOfLeastKey);
            leastRecents.add(0,tmp);
            cache.put(key, value);
        }

        int leastKey = leastRecents.get(leastRecents.size()-1);
        cache.remove(leastKey);
        int indOfLeastKey = leastRecents.indexOf(leastKey);
        leastRecents.remove(indOfLeastKey);
        cache.put(key, value);
        leastRecents.add(0,key);
    }
}

