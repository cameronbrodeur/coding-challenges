// 53. Maximum Subarray
//
// Given an integer array nums, find the contiguous subarray (containing at least 
// one number) which has the largest sum and return its sum.
//
// Example:
//
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution using the 
// divide and conquer approach, which is more subtle.

class MaximumSubarray_053E {
    // Iterative O(n) solution
    public int maxSubArray(int[] nums) {
        int index = 1;
        int runningSum = nums[0];
        int maxSum = nums[0];

        while (index < nums.length) {
            runningSum += nums[index];
            if (runningSum < nums[index]) {
                runningSum = nums[index];
            }
            if (runningSum > maxSum) {
                maxSum = runningSum;
            }
            index++;
        }

        return maxSum;
    }

    // Naive iterative O(n^2) solution
    public int maxSubArray_naive(int[] nums) {
        int maxSum = nums[0];
        int runningSum;

        for (int i = 0; i < nums.length; i++) {
            runningSum = nums[i];
            maxSum = Math.max(maxSum, runningSum);

            for (int j = i + 1; j < nums.length; j++) {
                runningSum += nums[j];
                maxSum = Math.max(maxSum, runningSum);
            }
        }

        return maxSum;
    }

    public void test() {
        System.out.println("Testing maxSubArray(int[] nums)...\n");

        int[] nums;
        int result;

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        result = maxSubArray(nums);
        System.out.println("Expected:  6");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4,-3,4,5,8,-3,2};
        result = maxSubArray(nums);
        System.out.println("Expected:  19");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{1,2};
        result = maxSubArray(nums);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{-2,1};
        result = maxSubArray(nums);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_naive() {
        System.out.println("Testing maxSubArray(int[] nums)...\n");

        int[] nums;
        int result;

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        result = maxSubArray_naive(nums);
        System.out.println("Expected:  6");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4,-3,4,5,8,-3,2};
        result = maxSubArray_naive(nums);
        System.out.println("Expected:  19");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{1,2};
        result = maxSubArray_naive(nums);
        System.out.println("Expected:  3");
        System.out.println("Output:    " + result + "\n");

        nums = new int[]{-2,1};
        result = maxSubArray_naive(nums);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + result + "\n");

    }

    public static void main(String[] args) {
        MaximumSubarray_053E solution = new MaximumSubarray_053E();
        solution.test();
        solution.test_naive();

    }
}