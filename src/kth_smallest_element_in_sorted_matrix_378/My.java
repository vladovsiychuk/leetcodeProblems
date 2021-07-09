package kth_smallest_element_in_sorted_matrix_378;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class My {
    public int result(int[][] matrix, int k){
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> nums = new ArrayList<>();

        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                nums.add(matrix[row][col]);
            }
        }

        Collections.sort(nums);
        return nums.get(k);
    }
}

