package decode_ways_91;

import java.util.HashMap;

public class My {
    public int result(String s){
        int n = s.length();

        if (s.charAt(0) == '0')
            return 0;
        else if (n == 1)
            return 1;

        HashMap<Integer, Integer> dp = new HashMap<>();
        String left = s.substring(1,n);
        String right = n > 2 ? s.substring(2,n) : "0";

        return Integer.valueOf(s) <= 26 && Integer.valueOf(s) >= 0 ?
                helper(left,dp) + helper(right,dp) + 1
                : helper(left, dp) + helper(right, dp);
    }

    private int helper(String s, HashMap<Integer, Integer> dp) {
        int n = s.length();
        if (s.charAt(0) == '0')
            return 0;
        else if (n == 1)
            return 1;
        else if (n <= 2 && dp.containsKey(Integer.valueOf(s)))
            return dp.get(Integer.valueOf(s));

        String left = s.substring(1,n);
        String right = n > 2 ? s.substring(2,n) : "0";

        return Integer.valueOf(s) <= 26 && Integer.valueOf(s) >= 0 ?
                helper(left,dp) + helper(right,dp) + 1
                : helper(left, dp) + helper(right, dp);
    }
}

