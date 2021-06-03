package range_sum_query_2d_immutable_304;

import javax.swing.text.StyleContext;

class NumMatrix {

    private final int[][] sums;

    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length][matrix[0].length + 1];
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++) {
                sums[row][col + 1] = matrix[row][col] + sums[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += sums[row][col2 + 1] - sums[row][col1];
        }
        return sum;
    }
}

