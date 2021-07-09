package word_search_2;

import java.util.*;

public class My {
    public List<String> result(char[][] board, String[] words){
        int n = board.length;
        int m = board[0].length;

        HashMap<Character, List<Integer[]>> letterMap = new HashMap<>();
        HashSet<String> result = new HashSet<>();

        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                List<Integer[]> list = letterMap.getOrDefault(board[row][col], new ArrayList<>());
                list.add(new Integer[]{row,col});
                letterMap.put(board[row][col], list);
            }
        }

        for (String word : words){
            boolean[][] visited = new boolean[n][m];
            if (!letterMap.containsKey(word.charAt(0)))
                continue;

            for (Integer[] coordinates : letterMap.get(word.charAt(0))) {
                visited = new boolean[n][m];
                dfs(word, 0, coordinates[0], coordinates[1], result, board, visited);
            }
        }
        List<String> res = new ArrayList<>(result);
        return res;
    }

    private void dfs(String word, int index, int row, int col
            , HashSet<String> result, char[][] board, boolean[][] visited) {

        if (index == word.length()-1){
            result.add(word);
            return;
        }
        visited[row][col] = true;

        int n = board.length;
        int m = board[0].length;

        int[] dRow = new int[]{0,-1,0,1};
        int[] dCol = new int[]{-1,0,1,0};

        for (int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow < 0 || newRow > n-1 || newCol < 0 || newCol > m-1 || visited[newRow][newCol])
                continue;

            if (board[newRow][newCol] == word.charAt(index + 1))
                dfs(word, index+1, newRow, newCol, result, board, visited);
            visited[newRow][newCol] = false;
        }
    }
}














