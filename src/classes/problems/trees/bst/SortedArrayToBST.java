package classes.problems.trees.bst;

import classes.utilities.structures.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length -1);
    }

    private static TreeNode helper(int[] nums,int left, int right){
        if(left > right) return null;

        int mid = (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums,left, mid - 1);
        root.right = helper(nums ,mid + 1, right);

        return root;
    }
}
