package number_of_islands_BFS_200;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class My {
    public int result(char[][] grid){
        int islands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' &&!visited[i][j]){
                    islands++;
                    bfs(grid, visited, i, j);
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        int[] di = new int[]{0, -1, 0, 1};
        int[] dj = new int[]{-1, 0, 1, 0};

        visited[i][j] = true;
        queue.add(new Integer[]{i,j});

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();
            int nodpi = node[0];
            int nodejs = node[1];
            for (int index = 0; index < 4; index++) {
                int newRow = nodpi + di[index];
                int newCol = nodejs + dj[index];

                if (newRow < 0 || newRow > (grid.length - 1)
                || newCol < 0 || newCol > (grid[0].length - 1))
                    continue;

                if (grid[newRow][newCol] != '1' || visited[newRow][newCol])
                    continue;

                queue.add(new Integer[]{newRow,newCol});
                visited[newRow][newCol] = true;
            }
        }
    }
}

