package pacific_atlantic_water_flow_417;

import java.util.*;

public class My {
    public List<List<Integer>> result(int[][] heights){
        int n = heights.length;
        int m = heights[0].length;
        CellData[][] cellData = new CellData[n][m];
        Queue<CellData> queue_pacific = new ArrayDeque<>();
        Queue<CellData> queue_atlantic = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                cellData[i][j] = new CellData(i,j);
            }
        }

        for (int col = 0; col < m; col++) {
            cellData[0][col].is_pacific=true;
            queue_pacific.add(cellData[0][col]);
            cellData[n-1][col].is_atlantic=true;
            queue_atlantic.add(cellData[n-1][col]);
        }for (int row = 0; row < n; row++) {
            cellData[row][0].is_pacific=true;
            queue_pacific.add(cellData[row][0]);
            cellData[row][m-1].is_atlantic=true;
            queue_atlantic.add(cellData[row][m-1]);
        }

        int[] dRow = new int[]{0,-1,0,1};
        int[] dCol = new int[]{-1,0,1,0};

        while (!queue_pacific.isEmpty()){
            CellData node = queue_pacific.poll();
            int row = node.row;
            int col = node.col;
            for (int i = 0; i < 4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];
                if (newRow < 0 || newRow > n-1 || newCol < 0 || newCol > m-1
                    || cellData[newRow][newCol].is_pacific
                    || heights[newRow][newCol] < heights[row][col])
                    continue;

                cellData[newRow][newCol].is_pacific=true;
                queue_pacific.add(cellData[newRow][newCol]);
            }
        }

        while (!queue_atlantic.isEmpty()){
            CellData node = queue_atlantic.poll();
            int row = node.row;
            int col = node.col;

            if(cellData[row][col].is_pacific && !cellData[row][col].visited) {
                result.add(Arrays.asList(row, col));
                cellData[row][col].visited = true;
            }

            for (int i = 0; i < 4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (newRow < 0 || newRow > n-1 || newCol < 0 || newCol > m-1
                        || cellData[newRow][newCol].is_atlantic
                        || heights[newRow][newCol] < heights[row][col])
                    continue;

                cellData[newRow][newCol].is_atlantic=true;
                queue_atlantic.add(cellData[newRow][newCol]);
            }
        }
        return result;
    }

    private class CellData {
        int row;
        int col;
        boolean is_pacific;
        boolean is_atlantic;
        boolean visited;

        public CellData(int r, int c) {
            row = r;
            col = c;
            is_pacific = false;
            is_atlantic = false;
            visited = false;
        }
    }
}

