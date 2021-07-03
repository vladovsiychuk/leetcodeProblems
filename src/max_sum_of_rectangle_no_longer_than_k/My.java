package max_sum_of_rectangle_no_longer_than_k;

public class My {
    public int result(int[][] matrix, int k){
        int n = matrix.length;
        int m = matrix[0].length;
        int best = Integer.MIN_VALUE;
        int[][] sums = new int[n][m];

        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                if (col == 0){
                    sums[row][col] = matrix[row][col];
                }else
                    sums[row][col] = sums[row][col-1]
                            + matrix[row][col];
                if (row == 0 && sums[row][col] <= k){
                    if (sums[row][col] == k)
                        return k;
                    else if (sums[row][col] > best)
                        best = sums[row][col];
                }
            }
        }

        for (int col = 0; col < m; col++){
            for (int row = 1; row < n; row++){
                sums[row][col] = sums[row-1][col] + sums[row][col];
                if (sums[row][col] <= k){
                    if (sums[row][col] == k)
                        return k;
                    else if (sums[row][col] > best)
                        best = sums[row][col];
                }
            }
        }


        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                if ((row == 0 && col == 0) || col == 0)
                    continue;

                for (int i = -1; i <= row; i++){
                    for (int j = -1; j < col; j++){
                        if (i == -1 && j == -1 || row == 0 && j == -1)
                            continue;

                        int sum;
                        if (row == 0 || i == -1)
                            sum = sums[row][col] - sums[row][j];
                        else if (j == -1)
                            sum = sums[row][col] - sums[i][col];
                        else
                            sum = sums[row][col] + sums[i][j]
                                - sums[row][j] - sums[i][col];

                        if (sum <= k){
                            if (sum == k)
                                return k;
                            else if (sum > best)
                                best = sum;
                        }
                    }
                }
            }
        }
        return best;
    }
}

