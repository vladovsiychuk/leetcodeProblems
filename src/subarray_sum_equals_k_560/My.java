package subarray_sum_equals_k_560;

import java.util.HashMap;

public class My {
    public int result(int[] nums, int k){
        HashMap<Integer, Integer> sums = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int count = 0;

        sums.put(0,1);

        for (int i = 0; i < n; i++){
            sum += nums[i];
            if (sums.containsKey(sum - k))
                count += sums.get(sum - k);
            sums.put(sum, sums.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}

