package binary_tree_level_order_traversal_two_107;


import java.util.List;

public class Main {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = My.result(root);
        System.out.println(result);
    }
}
