package classes.utilities;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
}
