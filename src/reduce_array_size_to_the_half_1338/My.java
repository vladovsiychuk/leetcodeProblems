package reduce_array_size_to_the_half_1338;

import java.util.HashMap;
import java.util.PriorityQueue;

public class My {
    public int result(int[] arr){
        int n = arr.length;

        HashMap<Integer, Integer> counter = new HashMap<>();
        PriorityQueue<Pair> sortedCounter = new
                PriorityQueue<>((a, b)->b.count-a.count);
        int count = 0;

        for (int i = 0; i < n; i++)
            counter.put(arr[i], counter.getOrDefault(arr[i], 0) + 1);

        for (int key : counter.keySet())
            sortedCounter.add(new Pair(key, counter.get(key)));

        while (n > arr.length/2){
            count++;
            n = n - sortedCounter.poll().count;
        }
        return count;

    }
    class Pair {
        int value;
        int count;

        Pair(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
}

