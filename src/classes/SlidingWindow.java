package classes;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println(longestSubstringNoDupes("abcabcadabcdefghiaffghadabcdefghijklmnopabcdef"));
        System.out.println(maximumAvgSubarray(nums,k));
    }


    //NOTE -> When the word subarray or substring is used it most likely
    //Sliding window approach

    //Variable Size Sliding Window
    private static Long longestSubstringNoDupes(String string){
       Long longest = 0L;
       Long left = 0L;
       Long right = 0L;
       Set<Character> sett = new HashSet<>();

       for(char c : string.toCharArray()){
           while(sett.contains(c)){
               sett.remove(c);
               left++;
           }

           Long windowLen = (right - left) + 1L;
           longest = Math.max(windowLen, longest);
           sett.add(c);
           right++;
       }
       return longest;
    }


    //Fixed Sized Sliding window
    private static Double maximumAvgSubarray(int[] nums, int k){
        Double maxAvg = Double.NEGATIVE_INFINITY;
        int start = 0;
        Double windowSum = 0D;

        for(int end = 0; end < nums.length; end++){
            windowSum += nums[end];

            if((end - start) + 1 == k){
                Double currAvg = windowSum / k;
                maxAvg = Math.max(currAvg,maxAvg);
                windowSum -= nums[start];
                start++;
            }
        }
        return maxAvg;
    }


















}
