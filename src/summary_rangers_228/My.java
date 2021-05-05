package summary_rangers_228;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class My {
    public static List<String> result(int[] nums){
        String[] result = new String[]{};
        result[0] = Integer.toString(nums[0]);

        int c = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] + 1)
                continue;
            if (!result[c].equals(Integer.toString(nums[i - 1]))){
                result[c] += "->" + Integer.toString(nums[i - 1]);
            }
            c++;
            result[c] = Integer.toString(nums[i]);
        }

        return Arrays.asList(result);
    }
}
