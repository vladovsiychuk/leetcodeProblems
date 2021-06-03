package number_of_islands_BFS_200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Pair{
        int ith;
        int jth;
        public Pair(int ith, int jth){
            this.ith = ith;
            this.jth = jth;
        }
    }
    public int numIslands(char[][] grid) {
        int numsOfIslands = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    numsOfIslands++;
                    isIsland(grid, i, j);
                }
            }
        }
        return numsOfIslands;
    }

    public void isIsland(char[][] grid, int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            i = pair.ith;
            j = pair.jth;
            grid[i][j] = '0';
            if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                queue.add(new Pair(i-1, j));
                grid[i-1][j] = '0';
            }
            if(i + 1 < grid.length && grid[i + 1][j] == '1'){
                queue.add(new Pair(i+1, j));
                grid[i+1][j] = '0';
            }
            if(j - 1 >= 0 && grid[i][j - 1] == '1'){
                queue.add(new Pair(i, j - 1));
                grid[i][j-1] = '0';
            }
            if(j + 1 < grid[i].length && grid[i][j + 1] == '1'){
                queue.add(new Pair(i, j + 1));
                grid[i][j+1] = '0';
            }
        }
    }
}

