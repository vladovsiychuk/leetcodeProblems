package license_key_formatting_482;

import javax.xml.stream.events.Characters;

public class My {
    public String result(String s, int k){
        boolean firstDash = true;
        StringBuilder result = new StringBuilder();
        int tmp = k;

        for (char c : s.toCharArray()){
            if(c=='-' && !firstDash)
                continue;
            if(firstDash)
                result.append(Character.toUpperCase(c));

            if (!firstDash){
                if (tmp > 0){
                    result.append(Character.toUpperCase(c));
                    tmp--;
                } else {
                    result.append('-');
                    tmp = k;
                }
            }

            if (c == '-' && firstDash)
                firstDash = false;

        }
        if (result.toString().charAt(result.length()-1) == '-')
            result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}

