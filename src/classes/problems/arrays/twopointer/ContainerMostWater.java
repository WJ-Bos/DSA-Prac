package classes.problems.arrays.twopointer;


public class ContainerMostWater {

    public static void main(String[] args) {
        int [] nums = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(containerMostWater(nums));
    }

    static int containerMostWater(int[] nums){
        int maxArea = 0;
        int left = 0; int right = nums.length - 1;

        while(left < right){
            int current = Math.min(nums[left], nums[right]) * (right - left);
            maxArea = Math.max(maxArea,current);

            if(nums[left] > nums[right]) right --;
            else left ++;
        }

        return maxArea;
    }
}
