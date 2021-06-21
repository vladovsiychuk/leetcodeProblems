package construct_binaty_tree_from_inorder_and_postorder_traversal_106;

import java.util.HashMap;

public class My {
    public TreeNode result(int[] inorder, int[] postorder){
        int n = inorder.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        TreeNode root = new TreeNode();
        root.val = postorder[n-1];

        for (int i = 0; i < n; i++)
            hm.put(inorder[i],i);

        int iIndex = hm.get(postorder[n-1]);
        int isL = 0;
        int ieL = iIndex-1;
        int isR = iIndex+1;
        int ieR = n-1;
        int psL = 0;
        int peL = psL + (ieL-isL);
        int psR = peL+1;
        int peR = n-2;

        root.left = new TreeNode();
        root.right = new TreeNode();

        buildTree(root.left,isL,ieL,psL,peL,inorder,postorder,hm);
        buildTree(root.right,isR,ieR,psR,peR,inorder,postorder,hm);
        return root;
    }
    private void buildTree(TreeNode node, int is, int ie, int ps, int pe,
                           int[] inorder, int[] postorder, HashMap<Integer,Integer> hm){
        if (ie < is)
            return;

        node.val = postorder[pe];

        if (is == ie)
        return;

        node.left = new TreeNode();
        node.right = new TreeNode();

        int iIndex = hm.get(postorder[pe]);
        int isL = is;
        int ieL = iIndex-1;
        int isR = iIndex+1;
        int ieR = ie;
        int psL = ps;
        int peL = ps+(ieL-isL);
        int psR = ps+(ieL-isL)+1;
        int peR = pe-1;
        buildTree(node.left,isL,ieL,psL,peL,inorder,postorder,hm);
        buildTree(node.right,isR,ieR,psR,peR,inorder,postorder,hm);
    }

}

