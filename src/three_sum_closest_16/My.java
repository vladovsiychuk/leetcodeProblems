package three_sum_closest_16;

import java.util.Arrays;

public class My {
    public int result(int[] nums, int target){
        int closestSum = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n-2; i++){
            int left = i + 1;
            int right = n - 1;

            while (left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if ((long)Math.abs(target-sum) < Math.abs(target-(long)closestSum))
                    closestSum = sum;

                if (sum == target)
                    return target;
                if (target < sum)
                    right--;
                else
                        left++;
            }
        }
        return closestSum;
    }
}

