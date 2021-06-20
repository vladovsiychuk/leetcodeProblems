package longest_word_in_dictionary_720;

import java.util.HashSet;
import java.util.Set;

public class My {
    public String result(String[] words){
        Set<String> dic = new HashSet<> ();
        String biggest = "";

        for (String word : words){
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < word.length(); i++){
                string.append(word.charAt(i));
                if(dic.contains(string)){
                    if (string.length()>biggest.length())
                        biggest = string.toString();
                    else if (string.length()==biggest.length()){
                        int comp = string.toString().compareTo(biggest);
                        if (comp > 0)
                            biggest = string.toString();
                    }
                }else {
                    dic.add(string.toString());
                }
            }
        }
        return biggest;
    }
}

