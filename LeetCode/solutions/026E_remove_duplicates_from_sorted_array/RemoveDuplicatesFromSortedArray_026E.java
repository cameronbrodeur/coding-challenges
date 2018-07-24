// 26. Remove Duplicates from Sorted Array
//
// Given a sorted array nums, remove the duplicates in-place such that each element 
// appear only once and return the new length.
//
// Do not allocate extra space for another array, you must do this by modifying the 
// input array in-place with O(1) extra memory.
//
// Example 1:
//
// Given nums = [1,1,2],
//
// Your function should return length = 2, with the first two elements of nums being 
// 1 and 2 respectively.
//
// It doesn't matter what you leave beyond the returned length.
//
// Example 2:
//
// Given nums = [0,0,1,1,1,2,2,3,3,4],
//
// Your function should return length = 5, with the first five elements of nums being 
// modified to 0, 1, 2, 3, and 4 respectively.
//
// It doesn't matter what values are set beyond the returned length.
//
// Clarification:
//
// Confused why the returned value is an integer but your answer is an array?
//
// Note that the input array is passed in by reference, which means modification to 
// the input array will be known to the caller as well.
//
// Internally you can think of this:
//
//         // nums is passed in by reference. (i.e., without making a copy)
//         int len = removeDuplicates(nums);
//
//         // any modification to nums in your function would be known by the caller.
//         // using the length returned by your function, it prints the first len elements.
//         for (int i = 0; i < len; i++) {
//             print(nums[i]);
//         }

import java.util.Arrays;

class RemoveDuplicatesFromSortedArray_026E {
    public int removeDuplicates(Integer[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[insertIndex - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }

        return insertIndex;
    }

    public void test() {
        System.out.println("Testing removeDuplicates(int[] nums)...\n");

        Integer[] nums;
        int result;

        nums = new Integer[] {};
        result = removeDuplicates(nums);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result);
        System.out.println("nums:      " + Arrays.toString(nums) + "\n");

        nums = new Integer[] {1};
        result = removeDuplicates(nums);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result);
        System.out.println("nums:      " + Arrays.toString(nums) + "\n");

        nums = new Integer[] {1,1,2};
        result = removeDuplicates(nums);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result);
        System.out.println("nums:      " + Arrays.toString(nums) + "\n");

        nums = new Integer[] {-1,0,0,1,2,3,3,3,3,4,5,6,8,10,10,11,12,12};
        result = removeDuplicates(nums);
        System.out.println("Expected:  12");
        System.out.println("Output:    " + result);
        System.out.println("nums:      " + Arrays.toString(nums) + "\n");
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_026E solution = new RemoveDuplicatesFromSortedArray_026E();
        solution.test();
    }
}