package classes.problems.twopointer;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[]{4,6,7,0,0,3};

        System.out.println(Arrays.toString(moveZeros(nums)));
    }

      static int[] moveZeros(int[] nums){
        int nonZero = 0;
        if(nums.length == 0){
            return new int[]{};
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[nonZero];
                nums[nonZero] = temp;
                nonZero++;
            }
        }
        return nums;
      }
}
