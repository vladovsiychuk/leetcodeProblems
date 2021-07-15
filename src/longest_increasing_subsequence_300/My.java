package longest_increasing_subsequence_300;

public class My {
    public int result(int[] nums){

        int n = nums.length;
        int maxLenght = 0;
        int[] dp = new int[n];

        for (int i = n-1; i >= 0; i--){
            int max = 0;
            dp[i] = 1;
            for (int j = n-1; j > i; j--){
                if (nums[j] > nums[i])
                    max = Math.max(max, dp[j]);
            }
            dp[i] += max;
            maxLenght = Math.max(dp[i], maxLenght);
        }
        return maxLenght;
    }
}

