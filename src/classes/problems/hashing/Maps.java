package classes.problems.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
       int[] nums = new int[]{1,2,6,2,5,4,8,3,7};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }

    static int[] twoSum(int[] nums, int k){

        Map<Integer, Integer> values = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int comp = k - nums[i];
            if(values.containsKey(comp)){
                return new int[]{
                        values.get(comp),i
                };
            }else{
                values.put(nums[i],i);
            }
        }

        return new int[2];
    }
}
