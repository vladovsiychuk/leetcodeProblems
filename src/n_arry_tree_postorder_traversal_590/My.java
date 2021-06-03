package n_arry_tree_postorder_traversal_590;

import java.util.ArrayList;
import java.util.List;

public class My {
    public static List<Integer> result(Node root){
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private static void helper(Node node, List<Integer> res) {
        if (node == null) return;

        for (Node n: node.children) {
            helper(n,res);
            res.add(n.val);
        }
    }
}

