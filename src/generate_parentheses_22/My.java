package generate_parentheses_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class My {
    public List<String> result(int n){
        List<String> result = new ArrayList<>();
        helper(n, result, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(int n, List<String> result, int open, int closed, StringBuilder currentGen) {
        if (currentGen.length() == n*2){
            result.add(new StringBuilder(currentGen).toString());
            return;
        }

        if (open <= closed){
            currentGen.append("(");
            helper(n, result, open + 1, closed, currentGen);
            currentGen.deleteCharAt(currentGen.length() - 1);
        }

        if (closed < open) {
            currentGen.append(")");
            helper(n, result, open, closed + 1, currentGen);
            currentGen.deleteCharAt(currentGen.length() - 1);
        }
    }
}

