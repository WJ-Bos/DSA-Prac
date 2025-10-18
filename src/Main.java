
import classes.utilities.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {

    int[] nums = new int[1000000];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }

    List<String> words =
        new ArrayList<>() {
          {
            add("test");
            add("estt");
            add("stet");
            add("bat");
            add("tab");
            // add("Allie");
          }
        };

    System.out.println(binarySearch(nums, 607463));
    System.out.println(groupAnagrams(words));

    TreeNode a = new TreeNode("1");
    TreeNode b = new TreeNode("22");

    TreeNode c = new TreeNode("5");
    TreeNode d = new TreeNode("24");
    TreeNode e = new TreeNode("2");
    TreeNode f = new TreeNode("12");

    a.setLeft(b);
    a.setRight(c);
    b.setLeft(d);
    b.setRight(e);
    c.setLeft(f);

    System.out.println("Max Sum Recursive-> " + getMaxSumRootToLeafRecursive(a));
    System.out.println("Total Sum Iterative-> " + totalSum(a));
    System.out.println("Is a Palindrome -> " + "racecar -> " + isPalindrome("racecar"));
    System.out.println(
        "Is a Palindrome -> " + "notapalindrome -> " + isPalindrome("notapalindrome"));
    System.out.println(Arrays.toString(sortColors(new int[] {1, 1, 0, 0, 2, 2, 2, 1, 0, 1, 2})));
  }

  // Implement Binary Search to find a Value in a Sorted Array of Integers
  // and return the Number if iterations

  private static Integer binarySearch(int[] nums, int target) {
    // Binary search == Divide and Conquer start -> middle -> end
    int start = 0;
    int end = nums.length - 1;
    int numOfIterations = 0;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] == target) {
        return numOfIterations;
      } else if (nums[mid] > target) {
        end = mid - 1;
        numOfIterations++;
      } else {
        start = mid + 1;
        numOfIterations++;
      }
    }
    return -1;
  }

  // Given a List of string return all Anagrams grouped together
  private static List<List<String>> groupAnagrams(List<String> words) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : words) {
      String fs = getFS(s);
      if (!map.containsKey(fs)) {
        map.put(
            fs,
            new ArrayList<>() {
              {
                add(s);
              }
            });
      } else {
        map.get(fs).add(s);
      }
    }
    return new ArrayList<>(map.values());
  }

  private static String getFS(String s) {
    int[] freq = new int[26];

    for (char c : s.toCharArray()) {
      freq[c - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    char c = 'a';
    for (int i : freq) {
      sb.append(c);
      sb.append(i);
      c++;
    }
    return sb.toString();
  }

  // Implement a Method to calculate the max sum of a Binary tree recursively
  private static Integer getMaxSumRootToLeafRecursive(TreeNode root) {
    if (root == null) return 0;
    return Integer.decode(root.getVal())
        + Math.max(
            getMaxSumRootToLeafRecursive(root.getLeft()),
            getMaxSumRootToLeafRecursive(root.getRight()));
  }

  // implement total sum DFS of a Binary tree
  private static Integer totalSum(TreeNode root) {
    if (root == null) return 0;

    int totalSum = 0;
    Stack<TreeNode> stack = new Stack<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode current = stack.pop();
      totalSum += Integer.decode(current.getVal());

      if (current.getRight() != null) stack.push(current.getRight());
      if (current.getLeft() != null) stack.push(current.getLeft());
    }
    return totalSum;
  }

  // given a String determine if its a Palindrome
  private static Boolean isPalindrome(String s) {
    char[] chars = s.toCharArray();
    int start = 0;
    int end = chars.length - 1;

    while (start < end) {
      char temp = chars[start];
      chars[start] = chars[end];
      chars[end] = temp;
      end--;
      start++;
    }

    return s.equalsIgnoreCase(String.valueOf(chars));
  }

  // Sort colors from 0 - 2 representing black white and red [1,2,2,1,1,0,0,1] ->
  // [0,0,1,1,1,1,2,2]
  private static int[] sortColors(int[] nums) {
    int start = 0;
    int i = 0;
    int end = nums.length - 1;

    while (i < end) {
      if (nums[i] == 0) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
        start++;
      } else if (nums[i] == 2) {
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
        end--;
      } else {
        i++;
      }
    }
    return nums;
  }

  private static class TwoPointer {

    public static void main(String[] args) {
      System.out.println(Arrays.toString(twoSumBruteForce(new int[] {1, 2, 5, 4, 1, 3}, 9)));
      System.out.println(
          Arrays.toString(twoSumSorted(new int[] {1, 4, 6, 7, 9, 13, 16, 20, 25}, 70)));
      System.out.println(Arrays.toString(twoSumMap(new int[] {3, 7, 4, 2, 7, 9, 23}, 9)));
    }

    /**
     * TWO SUM Given an Array of Integers, find two values in the Array that sum up to the Target
     * value
     *
     * <p>Array -> Traverse -> find Values This Could be done via a Brute force nested Loop for i in
     * and for j in Bad approach O(n²) Time complexity because for the length of n, j is doing n
     * many things
     *
     * <p>Better approach -> if Sorted -> two pointers left and right -> O(n) Or Map Approach ->
     * check if Complementary(target - val) exists in Map if not write val as key and Index as val
     * -> if complementary exists return index at val and val at key -> O(n)
     *
     * <p>Sorted [6,9,12,34,35,39] target = 56
     */
    private static int[] twoSumBruteForce(int[] nums, int target) {

      for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length; j++) {
          if (nums[j] + nums[i] == target) {
            return new int[] {i, j};
          }
        }
      }
      return new int[] {};
    }

    /**
     * @param nums
     * @param target
     * @return this Approach can be taken when We have certainty that the array is Always sorted
     *     This is a Big O(n) solution -> worst case we dont find the element and we iterate the
     *     full size of n testing email
     */
    private static int[] twoSumSorted(int[] nums, int target) {

      int left = 0;
      int right = nums.length - 1;

      while (left < right) {
        if (nums[left] + nums[right] == target) {
          return new int[] {left, right};
        }
        if (nums[left] + nums[right] < target) {
          left++;
        } else {
          right++;
        }
      }
      return new int[] {};
    }

    /**
     * [3,7,4,2,7,9,23] target = 9
     *
     * <p>i=0 → val=3 → comp=6 → not found → put(3,0) i=1 → val=7 → comp=2 → not found → put(7,1)
     * i=2 → val=4 → comp=5 → not found → put(4,2) i=3 → val=2 → comp=7 → found at index 1 → return
     * [3,1]
     *
     * <p>Safest Approach array does not have to be sorted Worst case Big O(n)
     */
    private static int[] twoSumMap(int[] nums, int target) {

      Map<Integer, Integer> valueMap = new HashMap<>();
      int complementary;

      for (int i = 0; i < nums.length; i++) {
        complementary = target - nums[i];
        if (valueMap.containsKey(complementary)) {
          return new int[] {i, valueMap.get(complementary)};
        } else {
          valueMap.put(nums[i], i);
        }
      }

      return new int[] {};
    }
  }
}
