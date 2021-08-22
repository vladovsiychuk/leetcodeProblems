package binary_tree_level_order_traversal_102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class My {
    public static List<List<Integer>> result(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Queue<TreeNode> newQueue = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null)
                    newQueue.add(current.left);
                if (current.right != null)
                    newQueue.add(current.right);
            }
            result.add(list);
            queue = newQueue;
        }
        return result;
    }
}

