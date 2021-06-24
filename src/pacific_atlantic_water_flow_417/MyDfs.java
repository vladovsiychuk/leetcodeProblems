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
            cellData[0][m].is_pacific = true;
            cellData[n-1][m].is_atlantic = true;
        }
        for (int i = 0; i < n; i++){
            cellData[i][0].is_pacific = true;
            cellData[i][m-1].is_atlantic = true;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(cellData[i][j].is_pacific)
                    dfsPacific(cellData, i, j);
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(cellData[i][j].is_atlantic)
                    dfsAtlantic(cellData, i, j, result);
            }
        }
        return result;
    }

    private void dfsAtlantic(CellData[][] cellData, int row, int col, List<List<Integer>> result) {
        int n = cellData.length;
        int m = cellData[0].length;
        int[] dRow = new int[]{0,-1,0,1};
        int[] dCol = new int[]{-1,0,1,0};

        if(cellData[row][col].is_pacific)
            result.add(Arrays.asList(row,col));

        cellData[row][col].is_atlantic = true;

        for (int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow<0 || newRow>n-1 || newCol<0 || newCol>n-1
                    || !cellData[newRow][newCol].is_atlantic)
                continue;

            dfsAtlantic(cellData, newRow, newCol, result);
        }
    }

    private void dfsPacific(CellData[][] cellData, int row, int col) {
        int n = cellData.length;
        int m = cellData[0].length;
        int[] dRow = new int[]{0,-1,0,1};
        int[] dCol = new int[]{-1,0,1,0};

        cellData[row][col].is_pacific = true;

        for (int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow<0 || newRow>n-1 || newCol<0 || newCol>n-1
                    || !cellData[newRow][newCol].is_pacific)
                continue;

            dfsPacific(cellData, newRow, newCol);
        }
    }

    private class CellData {
        boolean is_pacific;
        boolean is_atlantic;

        public CellData(boolean is_p, boolean is_a) {
            is_pacific = is_p;
            is_atlantic = is_a;
        }
    }
}

