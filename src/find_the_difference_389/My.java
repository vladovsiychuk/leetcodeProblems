package find_the_difference_389;

import java.util.ArrayList;
import java.util.List;

public class My {
    public static char result(String s, String t){

        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        for(int i = 0; i < t.length(); i++){
            if (list.contains(t.charAt(i))) {
                list.remove(list.indexOf(t.charAt(i)));
                continue;
            } else {
                return t.charAt(i);
            }
        }

        return 'e';
    }
}

