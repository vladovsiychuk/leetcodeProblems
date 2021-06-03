package top_k_frequent_elements_347;

import java.util.HashMap;
import java.util.PriorityQueue;

public class My {
    public int[] result(int[] nums, int k){
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int[] mostFrequent = new int[k];

        for (int num : nums){
            if (numsMap.containsKey(num))
                numsMap.put(num, numsMap.get(num) + 1);
            else {
                numsMap.put(num, 1);
            }
        }

        PriorityQueue<Integer> numsQueue = new PriorityQueue<>((a,b) -> numsMap.get(b) - numsMap.get(a));
        for (int key : numsMap.keySet())
            numsQueue.add(key);

        for (int i = 0; i < k; i++) {
            mostFrequent[i] = numsQueue.peek();
            numsQueue.poll();
        }

        return mostFrequent;
    }
}

