package most_common_word_819;

import java.util.Collections;
import java.util.HashMap;

public class My {
    public String result(String paragraph, String[] banned){
        String result = paragraph.replaceAll("[^A-Za-z\\s]", "");
        result = result.toLowerCase();

        String[] wordsOfParagraph = result.split("\\s+");
        HashMap<String, Integer> counter = new HashMap<>();

        for (String word : wordsOfParagraph)
            counter.put(word, counter.getOrDefault(word, 0) + 1);

        for (String word : banned)
            counter.remove(word);

        String maxKey = Collections.max(counter.keySet(), (a,b) -> counter.get(a) - counter.get(b));
        return maxKey;
    }
}

