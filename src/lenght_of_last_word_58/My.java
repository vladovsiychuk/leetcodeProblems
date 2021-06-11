package lenght_of_last_word_58;

public class My {
    public int result(String s){
        String[] words = s.split("\\s+");
        if (words.length == 0)
            return 0;

        return words[words.length - 1].length();
    }
}

