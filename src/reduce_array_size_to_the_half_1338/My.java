package reduce_array_size_to_the_half_1338;

import java.util.*;

public class My {
    public int result(int[] arr){
        int n = arr.length;
        int totalLenght = n;
        int count = 0;
        HashMap<Integer,Integer> counts = new HashMap<>();

        for (int i = 0; i < n; i++)
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);

        List<Integer> sortedNums = new ArrayList<>(counts.keySet());
        Collections.sort(sortedNums, (a, b) -> counts.get(b) - counts.get(a));

        int i = 0; //
        while (n > totalLenght/2){
            n -= counts.get(sortedNums.get(i)); // 1
            i++;
            count++; // 1
        }
        return count;
    }
}

