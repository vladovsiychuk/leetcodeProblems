package maximum_product_of_three_numbers_628;

import java.util.*;

public class My {
    public static int result(int[] nums){

//        1,0,-4,2
//        -8
//        -4,0,1,2;

        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}

