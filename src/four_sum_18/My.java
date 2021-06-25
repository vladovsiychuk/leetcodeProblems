package four_sum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class My {
    public List<List<Integer>> result(int[] nums, int target){
        int n = nums.length;
        if(n < 4)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n-3; i++){
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < n-2; j++){
                if (j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int left = j + 1;
                int right = n - 1;

                while (left < right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        break;
                    }else if (target < sum)
                        right--;
                    else
                        left++;
                }
            }
        }
        return result;
    }
}

