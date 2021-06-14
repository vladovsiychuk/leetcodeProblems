package triangle_120;

import java.util.List;

public class My {
    public int result(List<List<Integer>> triangle){
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        for (int row = triangle.size()-2; row >= 0; row--){
            for (int col = triangle.get(row).size()-1; col >= 0; col--) {
                int minSum = Math.min(triangle.get(row+1).get(col),
                                triangle.get(row+1).get(col+1));
                triangle.get(row).set(col, minSum+triangle.get(row).get(col));
            }
        }
        return triangle.get(0).get(0);
    }
}

