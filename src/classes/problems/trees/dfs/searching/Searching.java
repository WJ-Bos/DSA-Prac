package classes.problems.trees.dfs.searching;

import classes.utilities.TreeBuilder;
import classes.utilities.structures.TreeNode;

public class Searching {
    public static void main(String[] args) {
        Integer needle = 101;
        TreeNode root = TreeBuilder.buildRandomTree(100);
        System.out.println(TreeBuilder.convertToList(root));
        System.out.println("Has needle -> " + findBT(root,needle));
    }

    public static boolean findBST(TreeNode root , Integer needle){
        if(root == null) return false;

        if(root.getValue().equals(needle)) return true;
        if(needle > root.getValue()) return findBST(root.getRight(),needle);

        return findBST(root.getLeft(),needle);
    }

    public static boolean findBT(TreeNode root , Integer needle){
        if(root == null) return false;

        if(root.getValue().equals(needle)) return true;
        return findBT(root.getLeft(),needle) || findBT(root.getRight(),needle);
    }

    public static void insertBST(TreeNode root,TreeNode newNode){
        if(newNode.getValue() > root.getValue()){
            if(root.getRight() == null)root.setRight(newNode);
            else insertBST(root.getRight(),newNode);

        }else {
            if(root.getLeft() == null)root.setLeft(newNode);
            else insertBST(root.getLeft(),newNode);
        }
    }
}
