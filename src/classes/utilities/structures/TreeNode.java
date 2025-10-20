package classes.utilities.structures;

public class TreeNode {

  public String val;

  public Integer value;

  public TreeNode left;
  public TreeNode right;

  public TreeNode(String val) {
    this.val = val;
    left = null;
    right = null;
  }

  public TreeNode(Integer val) {
    this.value = val;
    left = null;
    right = null;
  }

  public String getVal() {
    return val;
  }

  public void setVal(String val) {
    this.val = val;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}
