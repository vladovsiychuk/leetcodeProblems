package majority_element_169;

import java.util.Arrays;

public class My {
    public int result(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

