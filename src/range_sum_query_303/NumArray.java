package range_sum_query_303;

import java.util.HashMap;

class NumArray {

    private final int[] nums;
    private HashMap<String, Integer> cache = new HashMap<>();

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        String tmp = left + "-" + right;
        if (cache.containsKey(tmp))
            return cache.get(tmp);

        int sum = 0;

        for (int i = left; i <= right ; i++) {
            sum += nums[i];
        }

        cache.put(tmp,sum);
        return sum;
    }
}


