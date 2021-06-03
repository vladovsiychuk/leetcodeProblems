package number_of_islands_BFS_200;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class My {
    public int result(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        Queue<Integer[]> queue = new ArrayDeque<>();
        int[][] dirs = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (!visited[i][j] && grid[i][j] == '1'){
                    islands++;
                    queue.add(new Integer[]{i,j});

                    while(!queue.isEmpty()) {
                        Integer[] cell = queue.poll();
                        visited[cell[0]][cell[1]] = true;

                        for (int[] dir : dirs ) {
                            if (dir[0] == -1 && cell[0] == 0
                                    || dir[0] == 1 && cell[0] == grid.length - 1
                                    || dir[1] == -1 && cell[1] == 0
                                    || dir[1] == 1 && cell[1] == grid[0].length - 1)
                                continue;

                            int[] neighbord = new int[]{cell[0] + dir[0], cell[1] + dir[1]};
                            if(!visited[neighbord[0]][neighbord[1]]
                                    && grid[neighbord[0]][neighbord[1]] == '1') {
                                queue.add(new Integer[]{neighbord[0], neighbord[1]});
                                visited[neighbord[0]][neighbord[1]] = true;
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}

