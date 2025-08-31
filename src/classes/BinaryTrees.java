package classes;

import java.util.*;

public class BinaryTrees {
    public static void main(String[] args) {

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        Node aa = new Node("5");
        Node bb = new Node("11");
        Node cc = new Node("3");
        Node dd = new Node("4");
        Node ee = new Node("2");
        Node ff = new Node("1");

        aa.setLeft(bb);
        aa.setRight(cc);
        bb.setLeft(dd);
        bb.setRight(ee);
        cc.setRight(ff);

        System.out.println(depthFirstRecursiveSearch(a));
        System.out.println(breadthFirstIterativeSearch(a));
        System.out.println(treeContainsDepthRecursion(a,"n"));
        System.out.println(treeContainsDepthRecursion(a,"a"));
        System.out.println(treeSumDepthRecursive(aa));
        System.out.println(minTreeValRecursive(aa));
        System.out.println(maxRootLeafPath(aa));

    }

    /**
     *  Traversal Methods will take in the Root and then
     *  recursively move through the nodes according to rules
     *
     *  Solve Depth first using a Stack
     *
     *  1 > Store root node
     *
     *      CHECK IF STACK IS EMPTY
     *
     *  2 > Pop The stack and mark as Current Node being explored and Add val of Mode to list of values
     *  3 > add Current Nodes Children to the stack, if left is added first
     *      right will be visited first.
     *
     *      Time Complexity
     *      n = number of node
     *      Time = O(n)
     *      Space = O(n)
     */

    private static List<String> depthFirstSearchNonRecursive(Node root){

        if (root == null) return new ArrayList<>();

        List<String> values = new ArrayList<String>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()){
            Node current = stack.pop();
            values.add(current.getVal());

            if(current.getRight() != null) stack.push(current.getRight());
            if(current.getLeft() != null) stack.push(current.getLeft());

        }
        return values;
    }

    private static List<String> depthFirstRecursiveSearch(Node root){
        if(root == null) return new ArrayList<>();

        List<String> rightValue = depthFirstRecursiveSearch(root.getRight());
        List<String> leftValue = depthFirstRecursiveSearch(root.getLeft());

        return new ArrayList<>(){{
            add(root.getVal());
            this.addAll(leftValue);
            this.addAll(rightValue);
        }};
    }

    /**
     *  Traversal Methods will take in the Root and then
     *  recursively move through the nodes according to rules
     *
     *  In a Breadth first traversal we will visit the root and then Both children of a Node
     *  before going deeper into the tree.
     *  Breadth first uses a QUEUE to solve. (FIFO)
     *
     *  1 > push root to Q
     *
     *  CHECK IF Q IS EMPTY
     *  2 > remove front of Q and mark as current = visited = add to values
     *  3 > add current Node Children to the Q left to right.
     *
     *  n = Number of nodes
     *  Time = O(N)
     *  Space = O(N)
     */

    private static List<String> breadthFirstIterativeSearch(Node root){
        if (root == null) return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<String> values = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            values.add(current.getVal());

            if(current.getLeft() != null) queue.add(current.getLeft());
            if(current.getRight() != null) queue.add(current.getRight());
        }
        return values;
    }

    private static boolean treeContainsDepthRecursion(Node root, String val){
        if(root == null) return false;
        if(root.getVal().equalsIgnoreCase(val)) return true;
        return treeContainsDepthRecursion(root.getLeft(), val) || treeContainsDepthRecursion(root.getRight(), val);
    }

    private static Integer treeSumDepthRecursive(Node root){
        if(root == null) return 0;
        return Integer.decode(root.val) + treeSumDepthRecursive(root.getLeft()) + treeSumDepthRecursive(root.getRight());
    }

    private static Integer treeSumBreadthIterative(Node root){
        if(root == null) return 0;
        int totalSum = 0;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.remove();
            totalSum += Integer.decode(current.getVal());
            if(current.getLeft() != null) queue.add(current.getLeft());
            if(current.getRight() != null) queue.add(current.getRight());
        }
        return totalSum;
    }

    private static Double minTreeValRecursive(Node root){
        if(root == null) return Double.POSITIVE_INFINITY;
        return Math.min(
                Double.parseDouble(root.val), Math.min(minTreeValRecursive(root.getLeft()), minTreeValRecursive(root.getRight()))
        );
    }

    private static Double maxRootLeafPath(Node root){
        if(root == null) return Double.NEGATIVE_INFINITY;
        if(root.getLeft() == null && root.getRight() == null){
            return Double.parseDouble(root.val);
        }
        return Double.parseDouble(root.val) + Math.max(
                maxRootLeafPath(root.getLeft()), maxRootLeafPath(root.getRight())
        );
    }
}
