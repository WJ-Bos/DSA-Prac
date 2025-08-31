package classes;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 0;
        nums[3] = 2;
        nums[4] = 1;

        System.out.println("Unsorted nums -> "+ Arrays.toString(nums));
        System.out.println("Sorted nums -> "+ Arrays.toString(twoPointerSortColors(nums)));
    }

    private static int[] twoPointerSortColors(int[]nums){
        int left = 0; int i = 0;
        int right = nums.length - 1;

        while(i < right ){

            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i++;
                left++;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }else{
                i++;
            }
        }
        return nums;
    }
}
