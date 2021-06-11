package word_search_79;

import java.util.HashSet;
import java.util.Set;

public class My {
    public boolean result(char[][] board, String word){
        word = word.toLowerCase();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char currChar = board[i][j];
                currChar = Character.toLowerCase(currChar);
                if (currChar != word.charAt(0))
                    continue;

                if(word.length() == 1)
                    return true;

                if(searchNextChar(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchNextChar(char[][] board, int i, int j, int wordIndex, String word, boolean[][] visited) {
        if (wordIndex == word.length())
            return true;

        if (Character.toLowerCase(board[i][j]) != word.charAt(wordIndex))
            return false;

        if(Character.toLowerCase(board[i][j]) == word.charAt(wordIndex) && wordIndex == word.length()-1)
            return true;

        int[] di = new int[]{0, -1, 0, 1};
        int[] dj = new int[]{-1, 0, 1, 0};

        visited[i][j] = true;

        for (int dir = 0; dir < 4; dir++){
            int newRow = i + di[dir];
            int newCol = j + dj[dir];
            if (newRow < 0 || newRow > board.length-1
            || newCol < 0 || newCol > board[0].length-1)
                continue;
            if (visited[newRow][newCol])
                continue;

            if(searchNextChar(board, newRow, newCol, wordIndex + 1, word, visited)) {
                visited[newRow][newCol] = true;
                return true;
            }
        }
        return false;
    }
}

