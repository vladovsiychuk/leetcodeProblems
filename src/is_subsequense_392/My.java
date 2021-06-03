package is_subsequense_392;

import java.util.HashMap;

public class My {
    public Boolean result(String s, String t){
        HashMap<String, Boolean> cache = new HashMap<>();
        int j = 0;

        if (cache.containsKey(s))
            return cache.get(s);

        for (int i = 0; i < t.length(); i++) {
            if(j == s.length() ) {
                cache.put(s,true);
                return true;
            }
            if (t.charAt(i) == s.charAt(j))
                j++;
        }

        cache.put(s,false);
        return false;
    }
}

