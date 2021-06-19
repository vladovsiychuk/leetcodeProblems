package construct_binaty_tree_from_inorder_and_postorder_traversal_106;

import java.util.HashMap;

public class My {
    public TreeNode result(int[] inorder, int[] postorder){
        HashMap<Integer,Integer> inorderIndexes = new HashMap<>();
        TreeNode root = new TreeNode();
        TreeNode tail = root;
        int n = inorder.length;
        for (int i = 0; i < n; i++)
            inorderIndexes.put(inorder[i],i);

        buildTree(tail,inorder,postorder,inorderIndexes);
        return root;
    }

    private void buildTree(TreeNode tail, int[] inorder, int[] postorder, HashMap<Integer, Integer> inorderIndexes) {
        int n = inorder.length;

        int iStartL = 0;
        int iEndL = inorderIndexes.get(postorder[n-1]);
        int iStartR = iEndL;
        int iEndR = n-1;

        int pStartL = 0;
        int pEndL = iEndL;
        int pStartR = iEndL;
        int pEndR = n-2;
    }
}

