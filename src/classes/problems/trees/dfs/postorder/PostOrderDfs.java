package classes.problems.trees.dfs.postorder;

import classes.utilities.TreeBuilder;
import classes.utilities.TreeNode;

import java.util.List;

public class PostOrderDfs {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.buildRandomTree(20);
    }

    public List<Integer> walk(TreeNode curr, List<Integer> path) {
        if (curr == null) {
            return path;
        }
        //recurse Step
        walk(curr.getLeft(), path);
        walk(curr.getRight(),path);

        path.add(curr.getValue());
        //Post

        return path;
    }
}
