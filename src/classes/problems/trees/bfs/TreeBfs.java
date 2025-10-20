package classes.problems.trees.bfs;

import classes.problems.trees.dfs.inorder.InOrderDfs;
import classes.utilities.TreeBuilder;
import classes.utilities.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBfs {
    public static void main(String[] args) {
        Integer needle = 24;
        TreeNode root = TreeBuilder.buildRandomTree(100);
        System.out.println("Inorder DFS -> " + InOrderDfs.walk(root,new ArrayList<>()));
        System.out.println("LevelOrder BFS -> " + walk(root,new ArrayList<>()));
        System.out.println("Has Value -> " + needle+ " " +bfs(root,needle));
    }

    public static List<Integer> walk(TreeNode root, List<Integer> path){
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()){
            TreeNode curr = q.poll();

            path.add(curr.getValue());
            if(curr.getLeft() != null) q.add(curr.getLeft());
            if(curr.getRight() != null) q.add(curr.getRight());
        }

        return path;
    }

    public static Boolean bfs(TreeNode root, Integer needle){
      Queue<TreeNode> q = new LinkedList<>();

      q.add(root);
      while(!q.isEmpty()){
          TreeNode curr = q.poll();

          if(curr.getValue().equals(needle)){
              return true;
          }

          if(curr.getLeft() != null) q.add(curr.getLeft());
          if(curr.getRight() != null) q.add(curr.getRight());

      }
      return false;
    }
}
