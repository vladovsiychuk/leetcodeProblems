package path_sum_2_113;


public class Main {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        System.out.println(My.result(root, 23));
    }
}
