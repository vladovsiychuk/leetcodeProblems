package permutations_46;

import java.util.ArrayList;
import java.util.List;

public class My {
    public List<List<Integer>> result(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, result, used, new ArrayList<Integer>());
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, boolean[] used, ArrayList<Integer> currentPerm) {
        if (currentPerm.size() == nums.length) {
            result.add(new ArrayList<>(currentPerm));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            currentPerm.add(nums[i]);
            helper(nums,result,used,currentPerm);
            currentPerm.remove(currentPerm.size() - 1);
            used[i] = false;
        }
    }
}

