package backspace_string_compare_844;

import java.util.Stack;

public class My {
    public boolean result(String s, String t){
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!sStack.isEmpty())
                    sStack.pop();
            }else
                sStack.push(c);
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!tStack.isEmpty())
                    tStack.pop();
            }else
                tStack.push(c);
        }

        if (sStack.size() == tStack.size()){
            int size  = sStack.size();
            for (int i = 0; i < size; i++)
                if (sStack.pop() != tStack.pop())
                    return false;
        }else
            return false;
        return true;
    }
}

