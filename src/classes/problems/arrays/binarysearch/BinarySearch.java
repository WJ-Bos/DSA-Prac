package classes.problems.arrays.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = new int[100000000];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = i;
        }

        System.out.println("Index of val = " + binarySearch(arr,668753) );
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int numOfI = 0;

        while(low <= high){
            int midIndex = low + (high - low) / 2;
            int midVal = nums[midIndex];

            System.out.println("middle = "+midVal);

            if(midVal < target){
                low = midIndex + 1;
            }else if(midVal > target){
                high = midIndex - 1;
            }else{
                System.out.println("Num of Iteration -- > " + numOfI);
                return midIndex;
            }
            numOfI++;
        }

        return -1;
    }
}
