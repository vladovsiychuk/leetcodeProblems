package valid_parentheses_20;

import java.util.ArrayList;
import java.util.List;

public class My {
    public static boolean result(String s){

        if(!isOpenBracket(s.charAt(0)))
            return false;

        List<Character> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isOpenBracket(c))
                list.add(c);
            else {
                switch (c) {
                    case ')':
                        if(list.get(list.size()-1).equals('(')) {
                            list.remove(list.size()-1);
                            continue;
                        }
                        return false;
                    case ']':
                        if(list.get(list.size()-1).equals('[')) {
                            list.remove(list.size()-1);
                            continue;
                        }
                        return false;
                    case '}':
                        if(list.get(list.size()-1).equals('{')) {
                            list.remove(list.size()-1);
                            continue;
                        }
                        return false;
                }
            }
        }

        if(list.size() == 0)
            return true;

        return false;
    }

    private static boolean isOpenBracket(char c) {
        if(c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }
}

