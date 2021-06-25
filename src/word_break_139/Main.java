package word_break_139;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new My().result(s, wordDict));
//        System.out.println(new Solution().result());
    }
}
