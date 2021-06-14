package zero_one_matrix_542;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class My {
    public String result(int[][] mat){
        int[][] result = new int[mat.length][mat[0].length];

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++){
                if (mat[row][col] == 0)
                    result[row][col] = 0;
                result[row][col] = Integer.MAX_VALUE;
            }
        }

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++){
                if (result[row][col] == 0)
                    bfs (result, row, col);
            }
        }

        return "ok";
    }

    private void bfs(int[][] result, int row, int col) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        int[] dirsRow = new int[]{0, -1, 0, 1};
        int[] dirsCol = new int[]{-1, 0, 1, 0};
        queue.add(new Integer[]{row,col});

        while (!queue.isEmpty()) {
            Integer[] nodeCoordinates = queue.poll();
            int nodeRow = nodeCoordinates[0];
            int nodeCol = nodeCoordinates[1];

            for (int i = 0; i < 4; i++){
                int newRow = nodeRow + dirsRow[i];
                int newCol = nodeCol + dirsCol[i];

                if (newRow < 0 || newRow > result.length - 1
                || newCol < 0 || newCol > result[0].length - 1)
                    continue;

                if (result[newRow][newCol] > result[nodeRow][nodeCol] + 1){
                    result[newRow][newCol] = result[nodeRow][nodeCol] + 1;
                    queue.add(new Integer[]{newRow, newCol});
                }
            }
        }
    }
}

