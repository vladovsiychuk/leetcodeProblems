package subarray_sum_equals_k_560;

public class My {
    public int result(int[] nums, int k){
        boolean[] visited = new boolean[nums.length];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            count++;
            searchSum(visited, nums, k, i);
        }
        return count;
    }

    private boolean searchSum(boolean[] visited, int[] nums, int k, int index) {
        visited[index] = true;

        int diff = k - nums[index];
        if (diff <= 0)
            return true;

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            if(searchSum(visited, nums, diff, i))
                return true;
        }
        return false;
    }
}

