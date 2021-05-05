package plus_one_66;

public class Solution {
    public static int[] plusOne(int[] digits) {
        int i = digits.length-1;
        while(i>=0) {
            if(digits[i]==9) {
                digits[i]=0;
                i--;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}
