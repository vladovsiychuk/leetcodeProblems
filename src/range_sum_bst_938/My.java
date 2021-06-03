package range_sum_bst_938;

public class My {
    private  int sum = 0;
    private  int low;
    private  int high;

    public int result(TreeNode root, int low, int high){
        this.low = low;
        this.high = high;
        func(root);
        return sum;
    }

    private void func(TreeNode root) {
        if (root == null) return;

        func(root.left);

        if (root.val >= low && root.val <= high)
            sum += root.val;

        func(root.right);
    }
}

