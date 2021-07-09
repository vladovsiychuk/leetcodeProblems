package n_queens_51;

import java.util.*;

public class My {
    int[] dRow = {0,-1,-1,-1,0,1,1,1};
    int[] dCol = {-1,-1,0,1,1,1,0,-1};
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){
                boolean[][] occupied = new boolean[n][n];

                int[][] board = new int[n][n];

                putNextQueen(occupied, board, row, col, res, 1,set);
            }
        }
        return res;
    }

    private void putNextQueen (boolean[][] occupied, int[][] board,
                               int row, int col, List<List<String>> res, int count, Set set) {

        int n = board.length;

        if (count > n)
            return;

        boolean print = true;
        board[row][col] = 1;
        setOccupied(row,col,occupied);
        boolean[][] bakOccupied = new boolean[n][n];
        cloneMatrix(bakOccupied, occupied);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (!occupied[i][j]){
                    print = false;
                    putNextQueen(occupied, board, i, j, res, count + 1, set);
                    board[i][j] = 0;
                    cloneMatrix(occupied, bakOccupied);
                }
            }
        }

        if (print && count == n)
            addResult(board, res, set);
    }

    private void setOccupied(int row, int col, boolean[][] occupied){
        int n = occupied.length;
        occupied[row][col] = true;

        for (int i = 0; i < 8; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            while(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n){
                occupied[newRow][newCol] = true;
                newRow += dRow[i];
                newCol += dCol[i];
            }
        }
    }
    private void cloneMatrix(boolean[][] a, boolean[][] b){
        for (int row = 0; row < b.length; row++)
            a[row] = b[row].clone();
    }
    private void addResult(int[][] board, List<List<String>> res, Set set){
        int n = board.length;
        int pow = n-1;
        List<String> list = new ArrayList<>();
        int code = 0;
        for (int row = 0; row < n; row++){
            StringBuilder builder = new StringBuilder();

            for (int col = 0; col < n; col++){
                if (board[row][col] == 1) {
                    builder.append("Q");

                    if (pow > 1) {
                        code += Math.pow(col*n,pow);
                        pow--;
                    }else if (pow > 0){
                        code += col * n;
                        pow--;
                    }else{
                        code += col;
                        pow--;
                    }
                }else
                    builder.append(".");
            }
            list.add(builder.toString());
        }

        if (!set.contains(code)) {
            res.add(list);
            set.add(code);
        }
    }
}

