package summary_rangers_228;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class My {
    public static List<String> result(int[] nums){

        if(nums.length == 0)
            return new ArrayList<String>();

        List result = new ArrayList<String>();
        int tmp = nums[0];
        String string;
        boolean isPreviousePlusOne = false;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1] + 1) {
                isPreviousePlusOne = true;
            }else{
                isPreviousePlusOne = false;
                string = Integer.toString(tmp);
                if(nums[i - 1] != tmp){
                    string += "->" + nums[i-1];
                }
                result.add(string);
                tmp = nums[i];
            }
        }

        if(isPreviousePlusOne)
            result.add(Integer.toString(tmp) + "->" + Integer.toString(nums[nums.length - 1]));
        else
            result.add(Integer.toString(tmp));

        return result;
    }
}
