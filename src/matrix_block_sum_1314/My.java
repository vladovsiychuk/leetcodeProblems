package matrix_block_sum_1314;

public class My {
    public int[][] result(int[][] mat, int k){
        int[][] result = new int[mat.length][mat[0].length];
        for (int row = 0; row < mat.length; row++){
            for (int col = 1; col < mat[0].length; col++) {
                mat[row][col] += mat[row][col-1];
            }
        }

        for (int row = 1; row < mat.length; row++){
            for (int col = 0; col < mat[0].length; col++) {
                mat[row][col] += mat[row-1][col];
            }
        }

        for (int row = 0; row < mat.length; row++){
            for (int col = 0; col < mat[0].length; col++) {
                int row_down = Math.max(row - k, 0);
                int col_down = Math.max(col - k, 0);
                int row_up = Math.min(row + k, mat.length - 1);
                int col_up = Math.min(col+k, mat[0].length-1);

                if (row_down == 0 && col_down == 0)
                    result[row][col] = mat[row_up][col_up];
                else if (row_down == 0)
                    result[row][col] = mat[row_up][col_up] - mat[row_up][col_down-1];
                else if (col_down == 0)
                    result[row][col] = mat[row_up][col_up] - mat[row_down-1][col_up];
                else
                    result[row][col] = mat[row_up][col_up]
                            - mat[row_up][col_down-1]
                            - mat[row_down-1][col_up]
                            + mat[row_down-1][col_down-1];
            }
        }
        return result;
    }
}

