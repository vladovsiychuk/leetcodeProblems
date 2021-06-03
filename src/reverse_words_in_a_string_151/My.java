package reverse_words_in_a_string_151;

public class My {
    public String result(String s){
        StringBuilder tmp = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (int i = s.length()-1; i >=0 ; i--){
            if (s.charAt(i) != ' ')
                tmp.append(s.charAt(i));

            if ( (s.charAt(i) == ' ' && tmp.length() != 0) || i == 0 ) {
                tmp.reverse();
                if (res.length() != 0) res.append(' ');
                res.append(tmp);
                tmp.delete(0,tmp.length() - 1);
            }
        }
        if (res.charAt(res.length() - 1) == ' ') res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}

