package island_perimeter_463;

public class My {
    public int result(int[][] grid){
        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        int perimeter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++){
                for (int[] dir : dirs){
                    if (grid[row][col] == 1
                            &&(dir[1] == -1 && col == 0
                            || dir[0] == -1 && row == 0
                            || dir[1] == 1 && col == grid[0].length - 1
                            || dir[0] == 1 && row == grid.length - 1
                            || grid[row + dir[0]][col + dir[1]] == 0))
                        perimeter++;
                }
            }
        }
        return perimeter;
    }
}

