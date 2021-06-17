package valid_palindrome_2_680;

public class My {
    public boolean result(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right){
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            return isPalindrome(left, right-1,s) || isPalindrome(left+1,right,s);
        }
        return true;
    }

    private boolean isPalindrome(int left, int right, String s) {

        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

