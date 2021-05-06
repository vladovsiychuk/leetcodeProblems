package pascal_triangle_118;

import java.util.ArrayList;
import java.util.List;

public class My {
    public static List<List<Integer>> result(int numRows){

        List<List<Integer>> container = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        container.add(init);
        if(numRows == 1) return container;
        List<Integer> init1 = new ArrayList<>();
        init1.add(1);
        init1.add(1);
        container.add(init1);
        if(numRows == 2) return container;

        for(int i=1; i< numRows - 1; i++){
            List<Integer> currentList = container.get(i);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);

            for(int j = 0; j < currentList.size() - 1; j++){
                newList.add(currentList.get(j) + currentList.get(j + 1));
            }

            newList.add(1);
            container.add(newList);
        }

        return container;
    }
}

