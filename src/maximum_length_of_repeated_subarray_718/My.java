package maximum_length_of_repeated_subarray_718;

public class My {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1][n2];

        for (int i = 0; i < n1; i++){
            for (int j = 0; j < n2; j++){
                int above = 0;
                int leftSide = 0;
                int previouseSeq = 0;
                int currMatch = nums1[i] == nums2[j] ? 1 : 0;
                if (i > 0)
                    above = dp[i-1][j];
                if (j > 0)
                    leftSide = dp[i][j-1];
                if (i > 0 && j > 0)
                    previouseSeq = dp[i-1][j-1];

                dp[i][j] = Math.max(Math.max(currMatch+previouseSeq ,above), leftSide);
            }
        }
        return dp[n1-1][n2-1];
    }
}

