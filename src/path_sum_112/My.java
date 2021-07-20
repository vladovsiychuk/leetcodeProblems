package path_sum_112;

public class My {
    public boolean result(TreeNode root, int targetSum){
        if (root == null) return false;
        int sum = root.val;
        if (root.left == null && root.right == null && sum == targetSum)
            return true;
        boolean result = false;

        return helper(root.left, targetSum, sum)
                || helper(root.right, targetSum, sum);
    }

    private boolean helper (TreeNode node, int targetSum, int sum){
        if (node == null)
            return false;

        sum += node.val;
        if (sum == targetSum && node.left == null && node.right == null)
            return true;

        return helper(node.left, targetSum, sum)
                || helper (node.right, targetSum, sum);
    }

}

