package valid_palindrome_125;

public class Solution {
    public static boolean result(String s){
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int mid = str.length()/2;
        int index=str.length()-1;

        for (int i=0; i<mid;i++){
            if (str.charAt(i)==str.charAt(index--)){
                continue;
            } else{
                return false;
            }
        }
        return true;
    }
}

