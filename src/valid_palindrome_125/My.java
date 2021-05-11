package valid_palindrome_125;

import java.util.ArrayList;
import java.util.List;

public class My {
    public static boolean result(String s){

        String str = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
        if(str.length()== 1) return true;

        str = str.toLowerCase();
        int i, j;

        if(str.length() % 2 == 0){
            i = str.length()/2 - 1;
            j = str.length()/2;
        }else {
            i = str.length()/2 - 1;
            j = str.length()/2 + 1;
        }

        while(i >= 0) {
            if(str.charAt(i) == str.charAt(j)){
                i--;
                j++;
                continue;
            }
            return false;
        }
        return true;
    }
}

