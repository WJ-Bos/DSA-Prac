package classes.problems.trees.dfs.inorder;

import classes.utilities.TreeBuilder;
import classes.utilities.structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderDfs {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildRandomTree(30);
        System.out.println(walk(root,new ArrayList<>()));
    }

    public static List<Integer> walk(TreeNode curr, List<Integer> path) {
        if (curr == null) {
            return path;
        }

        walk(curr.getLeft(),path);
        path.add(curr.getValue());
        walk(curr.getRight(),path);
        return path;
    }
}
