package classes.problems.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1,12,-5,-6,50,50,50,50,12,45};
        int k = 4;

        System.out.println(longestSubstringNoDupes("abcdeaa"));
        System.out.println(longestSubstringNoDupes("abcdeeeffab"));
        System.out.println(maximumAvgSubarray(nums,k));
    }


    //NOTE -> When the word subarray or substring is used it most likely
    //Sliding window approach

    //Variable Size Sliding Window
    private static int longestSubstringNoDupes(String string) {
        int longest = 0;
        int left = 0;
        Set<Character> sett = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            while (sett.contains(c)) {
                sett.remove(string.charAt(left));
                left++;
            }

            sett.add(c);
            int current = i - left + 1;
            longest = Math.max(longest, current);
        }

        return longest;
    }



    //Fixed Sized Sliding window
    private static Double maximumAvgSubarray(int[] nums, int k){
      Double maxAvg = Double.NEGATIVE_INFINITY;
      int left = 0;
      Double windowSum = 0D;

      for(int i = 0; i < nums.length; i++){
          windowSum += nums[i];

          if((i - left) + 1 == k){
              double curAvg = windowSum / k;
              windowSum -= nums[left];
              left++;
              maxAvg = Math.max(maxAvg,curAvg);
          }
      }

      return maxAvg;
    }


}
