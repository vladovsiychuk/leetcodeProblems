package maximum_depth_of_binary_tree_104;

public class My {
    public int result(TreeNode root){
        return helper(root, 0);
    }

    private int helper(TreeNode root, int h) {
        if (root == null) return h;

        return Math.max(helper(root.left, h+1), helper(root.right, h+1));
    }
}

