package word_break_139;

import java.util.List;

public class My {
    public boolean result(String s, List<String> wordDict){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            builder.append(s.charAt(i));
            if(dfs(builder.toString(),i,s,wordDict))
                return true;
        }
        return false;
    }

    private boolean dfs(String toSearch, int pS, String s, List<String> wordDict) {
        if (!wordDict.contains(toSearch))
            return false;
        else if (pS == s.length()-1)
            return true;

        StringBuilder builder = new StringBuilder();
        for (int i = pS+1; i < s.length(); i++){
            builder.append(s.charAt(i));
            if (dfs(builder.toString(),i,s,wordDict))
                return true;
        }
        return false;
    }
}
/*
        v
"leetcode"
 t   t   t


 */

