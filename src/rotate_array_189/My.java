package rotate_array_189;

import java.util.Arrays;

public class My {
    public String result(int[] nums, int k){
        int count = 0;
        for (int i = 0; count < nums.length - 1; i++){
            int tmp = nums[i];
            int nextIndex = (i + k)%nums.length;

            while (nextIndex != i) {
                int tmp2 = nums[nextIndex];
                nums[nextIndex] = tmp;
                tmp = tmp2;
                nextIndex = (nextIndex + k)%nums.length;
                count++;
            }
            nums[i] = tmp;
            count++;
        }

        return "done";
    }
}


