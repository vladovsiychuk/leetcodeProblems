package keyboard_row_500;

import java.util.ArrayList;
import java.util.List;

public class My {
    public String[] result(String[] words){
        int[] firstBoardRow = new int[26];
        int[] secondBoardRow = new int[26];
        int[] thirdBoardRow = new int [26];
        List<String> findedWords = new ArrayList<>();

        String firstBoardString = "qwertyuiop";
        String secondBoardString = "asdfghjkl";
        String thirdBoardString = "zxcvbnm";

        for (char c : firstBoardString.toCharArray())
            firstBoardRow[c - 'a'] = 1;

        for (char c : secondBoardString.toCharArray())
            secondBoardRow[c - 'a'] = 1;

        for (char c : thirdBoardString.toCharArray())
            thirdBoardRow[c - 'a'] = 1;

        for (String word : words) {
            String wordToLower = word.toLowerCase();
            char firstChar = wordToLower.charAt(0);
            if (firstBoardRow[firstChar - 'a'] == 1)
                searchIn(firstBoardRow,wordToLower,word,findedWords);
            else if (secondBoardRow[firstChar - 'a'] == 1)
                searchIn(secondBoardRow,wordToLower,word,findedWords);
            else
                searchIn(thirdBoardRow,wordToLower,word,findedWords);
        }

        String[] res = new String[findedWords.size()];
        for (int i = 0; i < findedWords.size(); i++)
            res[i] = findedWords.get(i);

        return res;
    }

    private void searchIn(int[] boardRow, String wordToLower,String word, List<String> findedWords) {
        for (char c : wordToLower.toCharArray()) {
            if (boardRow[c - 'a'] == 0) {
                return;
            }
        }
        findedWords.add(word);
    }
}

