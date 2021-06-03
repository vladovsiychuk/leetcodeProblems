package numbers_of_island_200;

public class My {
    public int result(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int lands = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    lands++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return lands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

        visited[i][j] = true;

        for(int[] dir : dirs){
            if(dir[0] == -1 && i == 0
            || dir[0] == 1 && i == grid.length - 1
            || dir[1] == -1 && j == 0
            || dir[1] == 1 && j == grid[0].length - 1)
                continue;

            if(!visited[i + dir[0]][j + dir[1]] && grid[i + dir[0]][j + dir[1]] == '1')
                dfs(grid, visited, i + dir[0], j + dir[1]);
        }
    }
}

