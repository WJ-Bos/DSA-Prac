import node.Node;
import org.w3c.dom.css.CSSStyleRule;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[10000];
        for(int i = 0; i < nums.length; i++){
            nums[i] = i;
        }

        List<String> words = new ArrayList<>(){{
            add("test");
            add("estt");
            add("stet");
            add("bat");
            add("tab");
        }};

        System.out.println(binarySearch(nums,607));
        System.out.println(groupAnagrams(words));

        Node a = new Node("1");
        Node b = new Node("22");
        Node c = new Node("5");
        Node d = new Node("24");
        Node e = new Node("2");
        Node f = new Node("12");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);

        System.out.println("Max Sum Recursive-> " + getMaxSumRootToLeafRecursive(a));
        System.out.println("Total Sum Iterative-> " + totalSum(a));
        System.out.println("Is a Palindrome -> " + "racecar -> " + isPalindrome("racecar"));
        System.out.println("Is a Palindrome -> " + "notapalindrome -> "+ isPalindrome("notapalindrome"));
        System.out.println(Arrays.toString(sortColors(new int[]{
                1,1,0,0,2,2,2,1,0,1,2
        })));
    }

    //Implement Binary Search to find a Value in a Sorted Array of Integers
    //and return the Number if iterations

    private static Integer binarySearch(int[] nums, int target){
        //Binary search == Divide and Conquer start -> middle -> end
        int start = 0;
        int end = nums.length - 1;
        int numOfIterations = 0;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return numOfIterations;
            }else if(nums[mid] > target){
                end = mid - 1;
                numOfIterations++;
            }else{
                start = mid + 1;
                numOfIterations++;
            }
        }
        return -1;
    }


    //Given a List of string return all Anagrams grouped together
    private static List<List<String>> groupAnagrams(List<String> words){
        Map<String,List<String>> map = new HashMap<>();

        for(String s : words){
            String fs = getFS(s);
            if(!map.containsKey(fs)){
                map.put(fs,new ArrayList<>(){{add(s);}});
            }else{
                map.get(fs).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String getFS(String s){
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for(int i : freq){
            sb.append(c);
            sb.append(i);
            c++;
        }
        return sb.toString();
    }

    //Implement a Method to calculate the max sum of a Binary tree recursively
    private static Integer getMaxSumRootToLeafRecursive(Node root){
        if(root == null) return 0;
        return Integer.decode(root.getVal()) + Math.max(getMaxSumRootToLeafRecursive(root.getLeft()),getMaxSumRootToLeafRecursive(root.getRight()));
    }

    //implement total sum DFS of a Binary tree
    private static Integer totalSum(Node root){
        if(root == null) return 0;

        int totalSum = 0;
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            Node current = stack.pop();
            totalSum += Integer.decode(current.getVal());

            if(current.getRight() != null) stack.push(current.getRight());
            if(current.getLeft() != null) stack.push(current.getLeft());

        }
        return totalSum;
    }

    //given a String determine if its a Palindrome
    private static Boolean isPalindrome(String s){
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length -1;

        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end --;
            start++;
        }

        return s.equalsIgnoreCase(String.valueOf(chars));
    }

    //Sort colors from 0 - 2 representing black white and red  [1,2,2,1,1,0,0,1] -> [0,0,1,1,1,1,2,2]
    private static int[] sortColors(int[] nums){
        int start = 0; int i = 0;
        int end = nums.length - 1;

        while(i < end){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start ++;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i]= nums[end];
                nums[end]= temp;
                end--;
            }else{
                i++;
            }
        }
        return nums;
    }


}
