package three_sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class My {
    public List<List<Integer>> result(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                if ((left!=i+1 && nums[left] == nums[left-1])){
                    left++;
                    continue;
                }else if ((right != nums.length-1 && nums[right] == nums[right+1])){
                    right--;
                    continue;
                }
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}

