package decode_ways_91;

public class My {
    public int result(String s){
        int n = s.length();
        int[] dp = new int[n];

        decode(dp, s, 0,n);
        return dp[0];
    }

    private int decode(int[] dp, String s, int start, int n){
        if (start >= n)
            return 0;
        else if (dp[start] != 0){
            return dp[start];
        } else if (s.charAt(start) == '0') {
            return 0;
        }

        int num = Integer.valueOf(s.substring(start,n));

        int res = num <= 26 && num > 0 ? 1 : 0;
        dp[start] = res + decode(dp, s, start+1,n);
        if (start < n-1 && Integer.parseInt(s.substring(start,start+2)) <= 26)
            dp[start] += decode(dp,s,start+2,n);
        return dp[start];
    }
}

