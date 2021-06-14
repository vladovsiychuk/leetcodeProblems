package minimum_path_sum_64;

public class My {
    public int result(int[][] grid){
        if(grid[0].length == 0)
            return 0;

        for (int row = grid.length-1; row >= 0; row--) {
            for (int col = grid[0].length-1; col >= 0; col--){
                if (row+1 == grid.length && col+1==grid[0].length)
                    continue;

                if (row+1 == grid.length)
                    grid[row][col] += grid[row][col+1];
                else if (col+1 == grid[0].length)
                    grid[row][col] += grid[row+1][col];
                else
                    grid[row][col] += Math.min(grid[row+1][col], grid[row][col+1]);
            }
        }
        return grid[0][0];
    }
}

