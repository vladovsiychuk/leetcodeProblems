package analize_user_visit_pattern;

public class Solution {
//    public static String result(){
//
//    }


        public boolean validPalindrome(String s) {
            if (s.length() == 1)
                return true;

            int left = 0; //a
            int right = s.length() - 1;//a
            boolean removedChar = false;


            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                    continue;
                }

                if (!removedChar) {
                    left++;
                    if (s.charAt(left) == s.charAt(right)) {
                        if (left == right) return true;
                        removedChar = true;
                        continue;
                    }
                    left--;
                    right--;
                    if (s.charAt(left) == s.charAt(right)) {
                        if (left == right) return true;
                        removedChar = true;
                        continue;
                    }
                    return false;
                }
            }
                return false;

        }
}

