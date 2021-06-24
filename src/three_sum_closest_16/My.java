package three_sum_closest_16;

import java.util.Arrays;

public class My {
    public int result(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            int left = i + 1;
            int right = n - 1;

            while (left < right){
                if (left != i+1 && nums[left] == nums[left-1])
                    left++;
                else if (right != n-1 && nums[right] == nums[right+1])
                    right--;

                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closestSum))
                    closestSum = sum;
                if (sum == target)
                    return target;

                if (sum < target)
                    left++;
                else
                    right--;
            }
        }
        return closestSum;
    }
}

