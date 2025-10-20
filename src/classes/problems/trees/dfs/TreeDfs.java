package classes.problems.trees.dfs;

import classes.utilities.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeDfs {
  public static void main(String[] args) {

    TreeNode a = new TreeNode("a");
    TreeNode b = new TreeNode("b");
    TreeNode c = new TreeNode("c");
    TreeNode d = new TreeNode("d");
    TreeNode e = new TreeNode("e");
    TreeNode f = new TreeNode("f");

    a.setLeft(b);
    a.setRight(c);
    b.setLeft(d);
    b.setRight(e);
    c.setRight(f);
    // Hello World
    TreeNode aa = new TreeNode("5");
    TreeNode bb = new TreeNode("11");
    TreeNode cc = new TreeNode("3");
    TreeNode dd = new TreeNode("4");
    TreeNode ee = new TreeNode("2");
    TreeNode ff = new TreeNode("1");

    aa.setLeft(bb);
    aa.setRight(cc);
    bb.setLeft(dd);
    bb.setRight(ee);
    cc.setRight(ff);

    System.out.println(depthFirstRecursiveSearch(a));
    System.out.println(treeContainsDepthRecursion(a, "n"));
    System.out.println(treeContainsDepthRecursion(a, "a"));
    System.out.println(treeSumDepthRecursive(aa));
    System.out.println(minTreeValRecursive(aa));
    System.out.println(maxRootLeafPath(aa));
    System.out.println("This is a Test From Nvim");
  }

  /**
   * Traversal Methods will take in the Root and then recursively move through the
   * nodes according
   * to rules
   *
   * <p>
   * Solve Depth first using a Stack
   *
   * <p>
   * 1 > Store root node
   *
   * <p>
   * CHECK IF STACK IS EMPTY
   *
   * <p>
   * 2 > Pop The stack and mark as Current classes.utilities.structures.TreeNode being explored and Add val of Mode
   * to list of
   * values 3 > add Current Nodes Children to the stack, if left is added first
   * right will be
   * visited first.
   *
   * <p>
   * Time Complexity n = number of node Time = O(n) Space = O(n)
   */
  private static List<String> depthFirstSearchNonRecursive(TreeNode root) {

    if (root == null)
      return new ArrayList<>();

    List<String> values = new ArrayList<String>();
    Stack<TreeNode> stack = new Stack<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode current = stack.pop();
      values.add(current.getVal());

      if (current.getRight() != null)
        stack.push(current.getRight());
      if (current.getLeft() != null)
        stack.push(current.getLeft());
    }
    return values;
  }

  private static List<String> depthFirstRecursiveSearch(TreeNode root) {
    if (root == null)
      return new ArrayList<>();

    List<String> rightValue = depthFirstRecursiveSearch(root.getRight());
    List<String> leftValue = depthFirstRecursiveSearch(root.getLeft());

    return new ArrayList<>() {
      {
        add(root.getVal());
        this.addAll(leftValue);
        this.addAll(rightValue);
      }
    };
  }

  /**
   * Traversal Methods will take in the Root and then recursively move through the
   * nodes according
   * to rules
   *
   * <p>
   * In a Breadth first traversal we will visit the root and then Both children of
   * a classes.utilities.structures.TreeNode before
   * going deeper into the tree. Breadth first uses a QUEUE to solve. (FIFO)
   *
   * <p>
   * 1 > push root to Q
   *
   * <p>
   * CHECK IF Q IS EMPTY 2 > remove front of Q and mark as current = visited = add
   * to values 3 >
   * add current classes.utilities.structures.TreeNode Children to the Q left to right.
   *
   * <p>
   * n = Number of nodes Time = O(N) Space = O(N)
   */


  private static boolean treeContainsDepthRecursion(TreeNode root, String val) {
    if (root == null)
      return false;
    if (root.getVal().equalsIgnoreCase(val))
      return true;
    return treeContainsDepthRecursion(root.getLeft(), val)
        || treeContainsDepthRecursion(root.getRight(), val);
  }

  private static Integer treeSumDepthRecursive(TreeNode root) {
    if (root == null)
      return 0;
    return Integer.decode(root.getVal())
        + treeSumDepthRecursive(root.getLeft())
        + treeSumDepthRecursive(root.getRight());
  }

  private static Integer treeSumBreadthIterative(TreeNode root) {
    if (root == null)
      return 0;
    int totalSum = 0;
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode current = queue.remove();
      totalSum += Integer.decode(current.getVal());

      if (current.getLeft() != null) queue.add(current.getLeft());
      if (current.getRight() != null) queue.add(current.getRight());
    }
    return totalSum;
  }

  private static Double minTreeValRecursive(TreeNode root) {
    if (root == null)
      return Double.POSITIVE_INFINITY;
    return Math.min(
        Double.parseDouble(root.getVal()),
        Math.min(minTreeValRecursive(root.getLeft()), minTreeValRecursive(root.getRight())));
  }

  private static Double maxRootLeafPath(TreeNode root) {
    if (root == null)
      return Double.NEGATIVE_INFINITY;
    if (root.getLeft() == null && root.getRight() == null) {
      return Double.parseDouble(root.getVal());
    }
    return Double.parseDouble(root.getVal())
        + Math.max(maxRootLeafPath(root.getLeft()), maxRootLeafPath(root.getRight()));
  }
}
