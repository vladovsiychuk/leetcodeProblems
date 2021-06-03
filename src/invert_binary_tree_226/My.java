package invert_binary_tree_226;

public class My {
    public static TreeNode invertTree(TreeNode root){
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}

