package summary_rangers_228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int min=nums[0], max=nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]+1) { max = nums[i]; }
            else {
                if (min == max) { res.add(min + ""); }
                else { res.add(min + "->" + max); }
                min = nums[i];
                max = nums[i];
            }
        }
        if (min == max) { res.add(min + ""); }
        else { res.add(min + "->" + max); }
        return res;
    }
}
