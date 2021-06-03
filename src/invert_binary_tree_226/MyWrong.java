package invert_binary_tree_226;

public class MyWrong {
    public static TreeNode invertTree(TreeNode root){
        if (root == null) return null;

        invertTree(root.left);

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.right);

        return root;
    }
}

