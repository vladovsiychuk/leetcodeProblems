package spiral_matrix_54;

import java.util.ArrayList;
import java.util.List;

public class My {
    public List<Integer> result(int[][] matrix){
        List<Integer> result = new ArrayList<>();

        if (matrix[0].length == 0)
            return result;

        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int startRow = 0;
        int endRow = matrix.length - 1;

        while (startCol <= endCol && startRow <= endRow) {
            for (int col = startCol; col <= endCol; col++)
                result.add(matrix[startRow][col]);

            for (int row = startRow; row <= endRow; row++)
                result.add(matrix[row][endCol]);

            if (startRow < endRow) {
                for (int col = endCol; col >= startCol; col--)
                    result.add(matrix[endRow][col]);
            }

            if (startRow < endRow){
                for (int row = endRow; row > startRow; row--)
                    result.add(matrix[row][startCol]);
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }

        return result;
    }
}

