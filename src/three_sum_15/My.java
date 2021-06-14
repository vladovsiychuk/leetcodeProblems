package three_sum_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class My {
    public List<List<Integer>> result(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            HashMap<Integer, Integer> couples = new HashMap<>();

            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;

                int n = -target - nums[j];

                if(couples.containsKey(n))
                    couples.put(n, nums[j]);
                else
                    couples.put(nums[j], null);
            }

            for (int key : couples.keySet()){
                if (couples.get(key) == null)
                    continue;

                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                tmp.add(key);
                tmp.add(couples.get(key));
                result.add(tmp);
            }
        }

        return result;
    }
}

