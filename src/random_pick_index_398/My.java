package random_pick_index_398;

import java.util.*;

public class My {
    HashMap<Integer, List<Integer>> numsIndexies = new HashMap<>();
    public My(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (numsIndexies.containsKey(nums[i]))
                numsIndexies.get(nums[i]).add(i);
            else {
                numsIndexies.put(nums[i], new ArrayList<>());
                numsIndexies.get(nums[i]).add(i);
            }
        }
    }

    public int pick(int target) {
        if (!numsIndexies.containsKey(target))
            return -1;
        Random rand = new Random();
        int min = 0;
        int max = numsIndexies.get(target).size()-1;
        int randomIndex = rand.nextInt((max - min) + 1) + min;
        return numsIndexies.get(target).get(randomIndex);
    }
}

