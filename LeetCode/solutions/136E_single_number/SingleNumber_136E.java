// 136. Single Number
//
// Given a non-empty array of integers, every element appears twice except for one. 
// Find that single one.
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it 
// without using extra memory?
//
// Example 1:
//
// Input: [2,2,1]
// Output: 1
//
// Example 2:
//
// Input: [4,1,2,1,2]
// Output: 4

import java.util.HashMap;
import java.util.Set;

class SingleNumber_136E {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> numDict = new HashMap<Integer, Boolean>();

        for (int i = 0; i < nums.length; i++) {
            if (numDict.containsKey(nums[i]) == true) {
                numDict.remove(nums[i]);
            } else {
                numDict.put(nums[i], true);
            }
        }

        Set<Integer> keys = numDict.keySet();
        Integer[] keysArray = new Integer[]{};
        keysArray = keys.toArray(keysArray);
        return keysArray[0];
    }

    public int singleNumber_usingXOR(int[]  nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result^nums[i];            // Calc XOR
        }

        return result;                          // A^B^C^A^B = C, therefore result contains the single number in nums[]
    }

    public void test() {
        System.out.println("Testing singleNumber(int[] nums)...\n");

        int[] nums;
        int result;

        nums = new int[]{2,2,1};
        result = singleNumber(nums);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{4,1,2,1,2};
        result = singleNumber(nums);
        System.out.println("Expected:  4");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_usingXOR() {
        System.out.println("Testing singleNumber_usingXOR(int[] nums)...\n");

        int[] nums;
        int result;

        nums = new int[]{2,2,1};
        result = singleNumber_usingXOR(nums);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{4,1,2,1,2};
        result = singleNumber_usingXOR(nums);
        System.out.println("Expected:  4");
        System.out.println("Output:    " + result + "\n");
    }

    public static void main(String[] args) {
        SingleNumber_136E solution = new SingleNumber_136E();
        solution.test();
        solution.test_usingXOR();
    }
}