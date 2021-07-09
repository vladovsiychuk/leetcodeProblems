package max_sum_of_rectangle_no_longer_than_k;

import java.util.TreeSet;

public class My {
    int result = Integer.MIN_VALUE;
    public int result(int[][] matrix, int k){
        int n = matrix.length;
        int m = matrix[0].length;

        for (int row = 0; row < n; row++){
            int[] sums = new int[m];

            for(int i = row; i < n; i++) {
                for (int col = 0; col < m; col++)
                    sums[col] += matrix[i][col];

                updateResult(sums,k);
                if (result == k)
                    return result;
            }
        }
        return result;
    }

    private void updateResult(int[] sums, int k) {
        int m = sums.length;

        TreeSet<Integer> tree = new TreeSet<>();
        int sum = 0;

        tree.add(0);

        for (int col = 0; col < m; col++){
            sum += sums[col];
            Integer x = tree.ceiling(sum - k);

            if (x != null && sum - x > result)
                result = sum - x;

            tree.add(sum);
        }
    }
}

