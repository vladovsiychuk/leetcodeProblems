package binary_tree_level_order_traversal_two_107;

import java.util.*;

public class My {
    public static List<List<Integer>> result(TreeNode root){
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> newQueue = new ArrayDeque<>();

            while(!queue.isEmpty()){
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null)
                    newQueue.add(current.left);
                if (current.right != null)
                    newQueue.add(current.right);
            }

            queue = newQueue;
            result.addFirst(list);
        }
        return result;
    }
}

