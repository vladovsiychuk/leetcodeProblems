package count_and_say_38;

import java.util.Arrays;

public class My {
    private String res;

    public String countAndSay(int n){
        if (n == 1) return "1";
        res = countAndSay(n - 1);

        char[] charsOfRes = res.toCharArray();
        StringBuilder say = new StringBuilder();
        int count = 1;

        if(charsOfRes.length == 1)
            return say.append("1"+charsOfRes[0]).toString();

        for (int i = 1; i < charsOfRes.length; i++) {
            if (charsOfRes[i - 1] == charsOfRes[i]){
                count++;
                continue;
            }

            say.append(Integer.toString(count) + charsOfRes[i - 1]);
            count = 1;
        }

        if (charsOfRes[charsOfRes.length - 1] == charsOfRes[charsOfRes.length - 2])
            say.append(Integer.toString(count)+charsOfRes[charsOfRes.length - 1]);
        else
            say.append("1"+ charsOfRes[charsOfRes.length - 1]);

        return say.toString();
    }
}

