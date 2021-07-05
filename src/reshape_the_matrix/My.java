package reshape_the_matrix;

public class My {
    public int[][] result(int[][] mat, int r, int c){
        int n = mat.length;
        int m = mat[0].length;

        if (n*m != r*c)
            return mat;

        int rowRes = 0;
        int colRes = -1;
        int[][] res = new int[r][c];

        for (int rowMat = 0; rowMat < n; rowMat++){
            for (int colMat = 0; colMat < m; colMat++){
                if(colRes+1 > c-1){
                    colRes = 0;
                    rowRes++;
                }else
                    colRes++;

                res[rowRes][colRes] = mat[rowMat][colMat];
            }
        }
        return res;
    }
}

