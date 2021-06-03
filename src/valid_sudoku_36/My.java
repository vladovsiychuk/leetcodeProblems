package valid_sudoku_36;

import java.util.ArrayList;
import java.util.List;

public class My {
    public boolean result(char[][] board){
        //check rows
        for (int row = 0; row < board.length; row++) {
            List<Character> tmp = new ArrayList<>();
            for (int col = 0; col < board[0].length; col++){
                if (tmp.contains(board[row][col]))
                    return false;
                if (board[row][col] != '.')
                    tmp.add(board[row][col]);
            }
        }

        //check cols
        for (int col = 0; col < board[0].length; col++){
            List<Character> tmp = new ArrayList<>();
            for (int row = 0; row < board.length; row++){
                if (tmp.contains(board[row][col]))
                    return false;
                if (board[row][col] != '.')
                    tmp.add(board[row][col]);
            }
        }

        int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int[][] middlePoints = new int[][]{{1,1},{1,4},{1,7},{4,1},{4,4},{4,7},{7,1},{7,4},{7,7}};

        for (int[] middlePoint : middlePoints) {
            List<Character> tmp = new ArrayList<>();
            if (board[middlePoint[0]][middlePoint[1]] != '.')
                tmp.add(board[middlePoint[0]][middlePoint[1]]);
            for (int[] dir : dirs) {
                int row = middlePoint[0] + dir[0];
                int col = middlePoint[1] + dir[1];


                if (tmp.contains(board[row][col]))
                    return false;
                if (board[row][col] != '.')
                    tmp.add(board[row][col]);
            }
        }

        return true;
    }
}

