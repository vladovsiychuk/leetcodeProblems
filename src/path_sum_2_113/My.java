package path_sum_2_113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class My {
    public static List<List<Integer>> result(TreeNode root, int targetSum){
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, targetSum, result, new LinkedList<Integer>());
        return result;
    }

    private static void dfs(TreeNode node, int pathSum, int sum, List<List<Integer>> result,
                            LinkedList<Integer> pathList) {
        if (node == null){
            pathList.add(1);
            return;
        }

        pathList.add(node.val);

        if (pathSum + node.val == sum) {
            result.add(new LinkedList<>(pathList));
            return;
        }

        dfs(node.left, pathSum + node.val, sum, result, pathList);
        pathList.removeLast();
        dfs(node.right, pathSum + node.val, sum, result, pathList);
        pathList.removeLast();
    }
}

