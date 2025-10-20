package classes.utilities;

import classes.utilities.structures.TreeNode;

import java.util.*;

public class TreeBuilder {

    public static TreeNode buildRandomTree(int numNodes) {
        if (numNodes <= 0) {
            return null;
        }

        Random random = new Random();

        TreeNode root = new TreeNode(random.nextInt(100));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int nodesCreated = 1;

        while (nodesCreated < numNodes && !queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (nodesCreated < numNodes) {
                current.left = new TreeNode(random.nextInt(100));
                queue.offer(current.left);
                nodesCreated++;
            }

            if (nodesCreated < numNodes) {
                current.right = new TreeNode(random.nextInt(100));
                queue.offer(current.right);
                nodesCreated++;
            }
        }

        return root;
    }

    public static List<Integer> convertToList(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.value);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return result;
    }
}
