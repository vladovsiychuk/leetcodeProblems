package word_search_79;

import java.util.HashSet;
import java.util.Set;

public class My {
    public boolean result(char[][] board, String word){

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (word.charAt(0) == board[row][col]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, row, col, 0, word, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int wordIndex,
                        String word, boolean[][] visited) {
        if (wordIndex == word.length()-1){
            if (word.charAt(wordIndex) == board[row][col])
                return true;
            else
                return false;
        }

        visited[row][col] = true;

        int[] dirRow = new int[]{0, -1, 0, 1};
        int[] dirCol = new int[]{-1, 0, 1, 0};
        boolean exists = false;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            if (newRow < 0 || newRow > board.length-1
            || newCol < 0 || newCol > board[0].length-1)
                continue;

            if (!visited[newRow][newCol] && word.charAt(wordIndex+1) == board[newRow][newCol])
                exists = dfs(board,newRow, newCol, wordIndex + 1, word, visited);
            if (exists)
                return true;
        }

        visited[row][col] = false;

        return exists;
    }
}

