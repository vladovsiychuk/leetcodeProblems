package toeplitx_matrix_766;

public class My {
    public boolean result(int[][] matrix){
        if (matrix.length == 1 || matrix[0].length == 1) return true;

        for (int i = 0; i < matrix.length - 1; i++){
            int tmp = i + 1;
            for (int j = 1; j < matrix.length - i; j++){
                if (matrix[i][0] != matrix[tmp][j])
                    return false;
                tmp++;
            }
        }

        for (int j = 1; j < matrix[0].length - 1; j++){
            int tmp = j + 1;
            for (int i = 1; i < matrix[0].length - j && i != matrix.length; i++ ){
                if (matrix[0][j] != matrix[i][tmp])
                    return false;
                tmp++;
            }
        }
        return true;
    }
}

