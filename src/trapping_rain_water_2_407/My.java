package trapping_rain_water_2_407;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class My {
    public int result(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        int water = 0;
        Cell[][] cells = new Cell[n][m];
        PriorityQueue<Cell> queue = new PriorityQueue<>((a,b)-> a.height-b.height);

        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                cells[row][col] = new Cell(row,col,heightMap[row][col]);
                if (row == 0 || row == n-1 || col == 0 || col == m-1) {
                    queue.add(cells[row][col]);
                    cells[row][col].visited = true;
                }
            }
        }

        while (!queue.isEmpty()){
            Cell node = queue.poll();
            int row = node.row;
            int col = node.col;

            int[] dRow = new int[]{0,-1,0,1};
            int[] dCol = new int[]{-1,0,1,0};

            for (int i = 0; i < 4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (newRow < 0 || newRow > n-1 || newCol < 0 || newCol > m-1
                || cells[newRow][newCol].visited)
                    continue;

                water += Math.max(0, node.height - cells[newRow][newCol].height);
                cells[newRow][newCol].visited = true;
                if (cells[newRow][newCol].height < node.height)
                    cells[newRow][newCol].height = node.height;
                queue.add(cells[newRow][newCol]);
            }
        }
        return water;
    }

    private class Cell {
        int row;
        int col;
        int height;
        boolean visited;

        public Cell (int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
            visited = false;
        }
    }
}

