package valid_anagram_242;

import java.util.HashMap;

public class My {
    public static boolean result(String s, String t){

        if(s.length() != t.length())
            return false;

        HashMap<Character,Integer> db = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            db.put(c,db.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!db.containsKey(c))
                return false;
            else {
                db.put(c, db.get(c) - 1);
                if(db.get(c) < 0)
                    return false;
            }
        }

        return true;
    }
}

