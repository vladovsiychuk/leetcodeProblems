package maximum_subarray_53;

public class My {
    public static int result(int[] nums){
        int[] maximumAtIndex = new int[nums.length];
        int maxSum = Integer.MIN_VALUE;
        maximumAtIndex[0] = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > (maximumAtIndex[i - 1] + nums[i]) ) {
                maximumAtIndex[i] = nums[i];
                maxSum = nums[i];
            } else {
                maximumAtIndex[i] = maximumAtIndex[i - 1] + nums[i];
                maxSum = maximumAtIndex[i - 1] + nums[i];
            }
        }

        return maxSum;
    }
}

