package jewels_and_stones_771;

import java.util.HashSet;
import java.util.Set;

public class My {
    public int result(String J, String S){
        Set<Character> jewels = new HashSet<>();
        int count = 0;

        for (int i = 0; i < J.length(); i++)
            jewels.add(J.charAt(i));

        for (int i = 0; i < S.length(); i++){
            if (jewels.contains(S.charAt(i)))
                count++;
        }

        return count;
    }
}

