package maximum_depth_of_binary_tree_104;

public class Solution {
    public static int result(TreeNode root){
        return max(root, 0);
    }
    private static int max(TreeNode root, int h){
        if(root == null) return h;
        return Math.max(max(root.left,h+1) , max(root.right,h+1));
    }
}

