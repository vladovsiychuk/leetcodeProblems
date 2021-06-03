package increasing_order_search_tree_897;

public class My {
    private TreeNode res = new TreeNode();
    private TreeNode tail = res;

    public TreeNode result(TreeNode root){

        helper(root);
        return res.right;
    }

    private void helper(TreeNode node) {
        if (node == null) return;

        helper(node.left);
        TreeNode tmp = new TreeNode(node.val);
        tail.right = tmp;
        tail = tail.right;
        helper(node.right);
    }
}

