package minimum_size_subarray_sum_209;

public class My {
    public int result(int[] nums, int target){
        int n = nums.length;

        for (int i = 1; i < n; i++)
            nums[i] += nums[i-1];

        for (int winSize = 1; winSize <= n; winSize++){
            if (nums[winSize-1]==target)
                return winSize;

            for (int i = winSize; i < n; i++){
                if (nums[i]-nums[i-winSize]==target)
                    return winSize;
            }
        }
        return 0;
    }
}

