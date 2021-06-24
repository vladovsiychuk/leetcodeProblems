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

        for (int col = 0; col < m; col++) {
            queue_pacific.add(new CellData(0, col, true, false));
            cellData[0][col] = new CellData(0, col, true, false);
            queue_atlantic.add(new CellData(n-1, col, false, true));
            cellData[n-1][col] = new CellData(n-1, col, true, false);
        }for (int row = 0; row < n; row++) {
            queue_pacific.add(new CellData(row, 0, true, false));
            cellData[row][0] = new CellData(row, 0, true, false);
            queue_atlantic.add(new CellData(row, m-1, false, true));
            cellData[row][m-1] = new CellData(row, m-1, true, false);
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
                if (newRow < 0 || newRow > n-1 || newCol < 0 || newCol > m-1)
                    continue;

                if ((cellData[newRow][newCol] == null ||
                        cellData[newRow][newCol].is_pacific == false) &&
                        heights[row][col] <= heights[newRow][newCol]) {
                    queue_pacific.add(new CellData(newRow, newCol, true, false));
                    cellData[newRow][newCol] = new CellData(newRow,newCol,true, false);
                }
            }
        }

        while (!queue_atlantic.isEmpty()){
            CellData node = queue_atlantic.poll();
            int row = node.row;
            int col = node.col;

            if(cellData[row][col] != null && cellData[row][col].is_pacific)
                result.add(Arrays.asList(row,col));

            for (int i = 0; i < 4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (newRow < 0 || newRow > n-1 || newCol < 0 || newCol > m-1)
                    continue;

                if ((cellData[newRow][newCol] == null &&
                        cellData[newRow][newCol].is_atlantic == false)
                        && heights[row][col] <= heights[newRow][newCol]) {
                    queue_pacific.add(new CellData(newRow, newCol, false, true));
                    if (cellData[newRow][newCol] != null)
                        cellData[newRow][newCol].is_atlantic = true;
                    else
                        cellData[newRow][newCol] = new CellData(newRow,newCol,false,true);
                }
            }
        }
        return result;
    }

    private class CellData {
        int row;
        int col;
        boolean is_pacific;
        boolean is_atlantic;

        public CellData(int r, int c, boolean is_p, boolean is_a) {
            row = r;
            col = c;
            is_pacific = is_p;
            is_atlantic = is_a;
        }
    }
}

