package classes.problems.sorting;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] nums = new int[5];
        nums[0] = 5;
        nums[1] = 2;
        nums[2] = 0;
        nums[3] = 2;
        nums[4] = 1;

        int[] nums2 = new int[]{-1,4,5,-2,6,0,6,4,2,-4,-3,-3,-3,1};

        System.out.println("Unsorted nums Selection Sort-> " + Arrays.toString(nums));
        System.out.println("Sorted nums -> " + Arrays.toString(selectionSort(nums)));

        System.out.println("Unsorted nums Merge Sort-> " + Arrays.toString(nums));
        System.out.println("Sorted nums -> " + Arrays.toString(mergeSort(nums2)));
    }

    private static int[] twoPointerSortColors(int[] nums) {
        int left = 0;
        int i = 0;
        int right = nums.length - 1;

        while (i < right) {

            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                i++;
                left++;
            } else if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                i++;
            }
        }
        return nums;
    }

    private static int[] bubbleSort(int[] nums) {
        boolean notSorted = true;

        while (notSorted) {
            notSorted = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    notSorted = true;
                }
            }
        }
        return nums;
    }

    private static int[] insertionSort(int[] nums) {
        int i = 1;
        int j = 1;
        while (i < nums.length) {
            if (j > 0 && nums[j] < nums[j - 1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            } else {
                i++;
                j = i;
            }
        }
        return nums;
    }

    private static int[] selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    private static int[] mergeSort(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;

        int mid = n / 2;
        int[] L = Arrays.copyOfRange(nums, 0, mid);
        int[] R = Arrays.copyOfRange(nums, mid, n);

        L = mergeSort(L);
        R = mergeSort(R);
        int l = 0;
        int r = 0;

        int[] sorted = new int[n];
        int i = 0;

        while (l < L.length && r < R.length) {
            if (L[l] < R[r]) {
                sorted[i] = L[l];
                l++;
            } else {
                sorted[i] = R[r];
                r++;
            }
            i++;
        }

        while (l < L.length) {
            sorted[i] = L[l];
            i++;
            l++;
        }

        while (r < R.length) {
            sorted[i] = R[r];
            i++;
            r++;
        }
        return sorted;
    }
}
