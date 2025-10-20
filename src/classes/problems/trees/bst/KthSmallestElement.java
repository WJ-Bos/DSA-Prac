package classes.problems.trees.bst;

import classes.utilities.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        if(k == 0) return 0;
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null) return;

        inOrder(root.left, list);
        list.add(root.value);
        inOrder(root.right,list);
    }
}
