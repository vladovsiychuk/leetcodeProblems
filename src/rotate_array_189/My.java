package rotate_array_189;

import java.util.Arrays;

public class My {
    public String result(int[] nums, int k){
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int next = (i + k)%nums.length;
            int currentVal = nums[i];
            int tmp = nums[next];

            while (i != next && count < nums.length){
                tmp = nums[next];
                nums[next] = currentVal;
                currentVal = tmp;
                next = (next + k)%nums.length;
                count++;
            }

            nums[i] = tmp;
            count++;
        }

        return "done";
    }
}


