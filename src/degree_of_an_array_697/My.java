package degree_of_an_array_697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class My {
    public static int result(int nums[]){
        HashMap<Integer,Integer> counter = new HashMap<>();
        HashMap<Integer, int[]> distance = new HashMap<>();
        List<Integer> maxNums = new ArrayList<>();
        int n = nums.length;
        int max = 0;
        int minSub = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i], 0)+1);
            if (distance.containsKey(nums[i]))
                distance.get(nums[i])[1] = i;
            else
                distance.put(nums[i], new int[]{i,i});

            if (counter.get(nums[i]) > max){
                max = counter.get(nums[i]);
                maxNums.clear();
                maxNums.add(nums[i]);
            } else if (counter.get(nums[i]) == max)
                maxNums.add(nums[i]);
        }
        for (int val : maxNums){
            int[] tmp = distance.get(val);
            if (tmp[1] - tmp[0] + 1 < minSub)
                minSub = tmp[1] - tmp[0] + 1;
        }
        return minSub;
    }
}

