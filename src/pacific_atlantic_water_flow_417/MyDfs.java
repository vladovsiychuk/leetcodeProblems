package pacific_atlantic_water_flow_417;

import java.util.*;

public class MyDfs {
    public List<List<Integer>> result(int[][] heights){
        int n = heights.length;
        int m = heights[0].length;
        CellData[][] cellData = new CellData[n][m];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                cellData[i][j] = new CellData(false, false);
            }
        }

        for (int i = 0; i < m; i++){
            cellData[0][i].is_pacific = true;
            cellData[n-1][i].is_atlantic = true;
        }
        for (int i = 0; i < n; i++){
            cellData[i][0].is_pacific = true;
            cellData[i][m-1].is_atlantic = true;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(cellData[i][j].is_pacific)
                    dfsPacific(cellData, i, j, heights);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(cellData[i][j].is_atlantic)
                    dfsAtlantic(cellData, i, j, result, heights);
            }
        }
        return result;
    }

    private void dfsAtlantic(CellData[][] cellData, int row, int col, List<List<Integer>> result,
                             int[][] heights) {
        int n = cellData.length;
        int m = cellData[0].length;
        int[] dRow = new int[]{0,-1,0,1};
        int[] dCol = new int[]{-1,0,1,0};

        if(cellData[row][col].is_pacific && !cellData[row][col].visited) {
            result.add(Arrays.asList(row, col));
            cellData[row][col].visited = true;
        }

        cellData[row][col].is_atlantic = true;

        for (int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow<0 || newRow>n-1 || newCol<0 || newCol>m-1
                    || cellData[newRow][newCol].is_atlantic
                    || heights[newRow][newCol] < heights[row][col])
                continue;

            dfsAtlantic(cellData, newRow, newCol, result,heights);
        }
    }

    private void dfsPacific(CellData[][] cellData, int row, int col, int[][] heights) {
        int n = cellData.length;
        int m = cellData[0].length;
        int[] dRow = new int[]{0,-1,0,1};
        int[] dCol = new int[]{-1,0,1,0};

        cellData[row][col].is_pacific = true;

        for (int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow<0 || newRow>n-1 || newCol<0 || newCol>m-1
                    || cellData[newRow][newCol].is_pacific
                    || heights[newRow][newCol] < heights[row][col])
                continue;

            dfsPacific(cellData, newRow, newCol, heights);
        }
    }

    private class CellData {
        boolean is_pacific;
        boolean is_atlantic;
        boolean visited;

        public CellData(boolean is_p, boolean is_a) {
            is_pacific = is_p;
            is_atlantic = is_a;
            visited = false;
        }
    }
}

/*
[[1,1],
 [1,1],
 [1,1]]


 */

