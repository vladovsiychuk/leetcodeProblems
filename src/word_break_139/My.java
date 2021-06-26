package word_break_139;

import java.util.List;

public class My {
    public boolean result(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int start = 0; start < n; start++){
            if (start!=0 && !dp[start-1]) continue;
            if (wordDict.contains(s.substring(start))) return true;
            for (int end = start+1; end < n; end++){
                if (wordDict.contains(s.substring(start,end)))
                    dp[end-1] = true;
            }
        }
        return false;
    }
}
/*
        v
"leetcode"
 t   t   t


 */

