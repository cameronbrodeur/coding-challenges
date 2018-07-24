// 88. Merge Sorted Array
//
// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one 
// sorted array.
//
// Note:
//
// The number of elements initialized in nums1 and nums2 are m and n respectively.
// You may assume that nums1 has enough space (size that is greater or equal 
// to m + n) to hold additional elements from nums2.
//
// Example:
//
// Input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3
//
// Output: [1,2,2,3,5,6]

import java.util.Arrays;
import java.util.String;

class MergeSortedArray_088E {
    // This solution starts at the first element of each array and merges the arrays
    // moving forward. This approach is straightforward but is inefficient due to
    // multiple array shifts that are necessary during the merge.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        int indexNums1 = 0;
        int indexNums2 = 0;

        while ((indexNums1 < m) && (indexNums2 < n)) {
            if (nums2[indexNums2] <= nums1[indexNums1]) {   // Shift elements at nums1[indexNums1] to the right one element
                for (int i = m; i > indexNums1; i--) {
                    nums1[i] = nums1[i - 1];
                }
                nums1[indexNums1] = nums2[indexNums2];      // Insert element from nums2 into empty slot
                indexNums1++;
                indexNums2++;
                m++;
            } else {
                indexNums1++;
            }
        }
        if (indexNums1 == m) {                              // Copy remaining elements in nums2 to nums1
            while (indexNums2 < n) {
                nums1[indexNums1] = nums2[indexNums2];
                indexNums1++;
                indexNums2++;
            }
        }
    }

    // This solution starts at the last element of each array and merges the arrays as
    // we move to the front of the arrays. (i.e. the direction of the merge is towards 
    // the smaller array index numbers.)
    public void merge_improved(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1)
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        while (j > -1)
            nums1[k--] = nums2[j--];
    }

    public void test() {
        System.out.println("Testing merge(int[] nums1, int m, int[] nums2, int n)...\n");

        int[] nums1, nums2;
        int m, n;

        nums1 = new int[]{1,2,3,0,0,0};
        m = 3;
        nums2 = new int[]{2,5,6};
        n = 3;
        merge(nums1, m, nums2, n);
        System.out.println("Expected:  [1, 2, 2, 3, 5, 6]");
        System.out.println("Output:    " + Arrays.toString(nums1) + "\n");

        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        merge(nums1, m, nums2, n);
        System.out.println("Expected:  [1]");
        System.out.println("Output:    " + Arrays.toString(nums1) + "\n");

        nums1 = new int[]{2,0};
        m = 1;
        nums2 = new int[]{1};
        n = 1;
        merge(nums1, m, nums2, n);
        System.out.println("Expected:  [1, 2]");
        System.out.println("Output:    " + Arrays.toString(nums1) + "\n");
    }

    public void test_improved() {
        System.out.println("Testing merge_improved(int[] nums1, int m, int[] nums2, int n)...\n");

        int[] nums1, nums2;
        int m, n;

        nums1 = new int[]{1,2,3,0,0,0};
        m = 3;
        nums2 = new int[]{2,5,6};
        n = 3;
        merge_improved(nums1, m, nums2, n);
        System.out.println("Expected:  [1, 2, 2, 3, 5, 6]");
        System.out.println("Output:    " + Arrays.toString(nums1) + "\n");

        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        merge_improved(nums1, m, nums2, n);
        System.out.println("Expected:  [1]");
        System.out.println("Output:    " + Arrays.toString(nums1) + "\n");

        nums1 = new int[]{2,0};
        m = 1;
        nums2 = new int[]{1};
        n = 1;
        merge_improved(nums1, m, nums2, n);
        System.out.println("Expected:  [1, 2]");
        System.out.println("Output:    " + Arrays.toString(nums1) + "\n");
    }

    public static void main(String[] args) {
        MergeSortedArray_088E solution = new MergeSortedArray_088E();
        solution.test();
        solution.test_improved();
    }
}