package classes.problems.trees.bst;

import classes.utilities.structures.TreeNode;

public class LCA {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while(cur != null){
            if(cur.value < p.value && cur.value < q.value){
                cur = cur.right;
            }else if(cur.value > p.value && cur.value > q.value){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }
}
