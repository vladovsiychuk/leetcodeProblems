package license_key_formatting_482;

import javax.xml.stream.events.Characters;

public class My {
    public String result(String s, int k){
        StringBuilder builder = new StringBuilder();
        int count = 0;

        s = s.toUpperCase();
        s = s.replaceAll("-", "");

        for (int i = s.length()-1; i >= 0; i--){
            if (count == 4)
                builder.insert(0,'-');
            builder.insert(0, s.charAt(i));
            count = (count+1)%4;
        }
        return builder.toString();
    }
}

