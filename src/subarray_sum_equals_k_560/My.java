package subarray_sum_equals_k_560;

import java.util.HashMap;

public class My {
    public int result(int[] nums, int k){
        HashMap<Integer,Integer> sums = new HashMap<>();
        int sum = 0;
        int count = 0;

        sums.put(0,1);

        for (int n : nums){
            sum += n;
            if (sums.containsKey(sum-k)){
                count += sums.get(sum-k);
                sums.put(sum-k, sums.get(sum-k)+1);
            }
            sums.put(sum, 1);
        }
        return count;
    }
}

