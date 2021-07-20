package maximum_length_of_repeated_subarray_718;

public class My {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int max = 0;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(nums1[i] == nums2[j]){
                    dp[i][j] = 1;
                    if (j-1 >= 0 && i-1 >= 0
                            && dp[i-1][j-1] > 0)
                        dp[i][j] += dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}

