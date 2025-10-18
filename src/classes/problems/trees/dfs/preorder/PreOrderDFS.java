package classes.problems.trees.dfs.preorder;

import classes.utilities.TreeBuilder;
import classes.utilities.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderDFS {
    public static void main(String[] args) {
        List<Integer> path = new ArrayList<>();
        TreeNode root = TreeBuilder.buildRandomTree(20);
        System.out.println(walk(root,path));
    }

    public static List<Integer> walk(TreeNode curr, List<Integer> path){
        if(curr == null){
            return path;
        }
        //Pre Step, Adding value
        path.add(curr.getValue());
        //recurse Step
        walk(curr.getLeft(),path);
        walk(curr.getRight(),path);

        //Post Step
        return path;
    }
}
