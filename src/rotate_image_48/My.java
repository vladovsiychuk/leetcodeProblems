package rotate_image_48;

public class My {
    public void result(int[][] matrix){
        for (int i = 0; i < (matrix.length + 1)/2; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int[] leftBottom = new int[]{matrix.length - 1 - j, i};
                int[] leftUpper = new int[]{i,j};
                int[] rightUpper = new int[]{j , matrix.length - 1 - i};
                int[] rightBottom = new int[]{ matrix.length - 1 - i , matrix.length - 1 - j };

                int tmp = matrix[leftBottom[0]][leftBottom[1]];
                matrix[leftBottom[0]][leftBottom[1]] = matrix[rightBottom[0]][rightBottom[1]];

                matrix[rightBottom[0]][rightBottom[1]] = matrix[rightUpper[0]][rightUpper[1]];

                matrix[rightUpper[0]][rightUpper[1]] = matrix[leftUpper[0]][leftUpper[1]];
                matrix[leftUpper[0]][leftUpper[1]] = tmp;
            }
        }
    }
}

