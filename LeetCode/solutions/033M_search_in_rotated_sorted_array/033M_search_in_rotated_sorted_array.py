# 33. Search in Rotated Sorted Array
# 
# Suppose an array sorted in ascending order is rotated at some pivot unknown to 
# you beforehand.
# 
# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
# 
# You are given a target value to search. If found in the array return its index, 
# otherwise return -1.
# 
# You may assume no duplicate exists in the array.
# 
# Your algorithm's runtime complexity must be in the order of O(log n).
# 
# Example 1:
# 
# Input: nums = [4,5,6,7,0,1,2], target = 0
# Output: 4
# 
# Example 2:
# 
# Input: nums = [4,5,6,7,0,1,2], target = 3
# Output: -1
#
# Companies asking this question: Facebook, Microsoft, Bloomberg, Uber, LinkedIn

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) == 0:
            return -1

        # Find the pivot point, which is the smallest value in array nums
        low = 0
        high = len(nums) - 1
        while low < high:
            mid  = low + (high - low) / 2                
            if nums[high] < nums[mid]:
                low = mid + 1
            else:
                high = mid

        rotation = low
            
        # Perform binary search on the array, taking into account the pivot point
        # when calculating the subarray to search
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid  = low + (high - low) / 2
            realMid = (mid + rotation) % len(nums)

            if nums[realMid] == target:
                return realMid

            if target < nums[realMid]:
                high = mid - 1
            else:
                low = mid + 1

        return -1

def test():
    print('Testing search(self, nums, target)...\n')

    s = Solution()

    nums = [0,1,2,4,5,6,7]
    target = 0
    result = s.search(nums, target)
    print('Expected:  0')
    print('Output:    ' + str(result) + '\n')

    nums = [0,1,2,4,5,6,7]
    target = 4
    result = s.search(nums, target)
    print('Expected:  3')
    print('Output:    ' + str(result) + '\n')

    nums = [0,1,2,4,5,6,7]
    target = 5
    result = s.search(nums, target)
    print('Expected:  4')
    print('Output:    ' + str(result) + '\n')

    nums = [0,1,2,4,5,6,7]
    target = 7
    result = s.search(nums, target)
    print('Expected:  6')
    print('Output:    ' + str(result) + '\n')

    nums = [0,1,2,4,5,6,7]
    target = 3
    result = s.search(nums, target)
    print('Expected:  -1')
    print('Output:    ' + str(result) + '\n')

    nums = [0,1,2,4,5,6,7]
    target = 8
    result = s.search(nums, target)
    print('Expected:  -1')
    print('Output:    ' + str(result) + '\n')

    nums = [0,1,2,4,5,6,7]
    target = -1
    result = s.search(nums, target)
    print('Expected:  -1')
    print('Output:    ' + str(result) + '\n')

    nums = [4,5,6,7,0,1,2]
    target = 0
    result = s.search(nums, target)
    print('Expected:  4')
    print('Output:    ' + str(result) + '\n')

    nums = [4,5,6,7,0,1,2]
    target = 4
    result = s.search(nums, target)
    print('Expected:  0')
    print('Output:    ' + str(result) + '\n')

    nums = [4,5,6,7,0,1,2]
    target = 5
    result = s.search(nums, target)
    print('Expected:  1')
    print('Output:    ' + str(result) + '\n')

    nums = [4,5,6,7,0,1,2]
    target = 2
    result = s.search(nums, target)
    print('Expected:  6')
    print('Output:    ' + str(result) + '\n')

    nums = [4,5,6,7,0,1,2]
    target = 3
    result = s.search(nums, target)
    print('Expected:  -1')
    print('Output:    ' + str(result) + '\n')

    nums = [4,5,6,7,0,1,2]
    target = 8
    result = s.search(nums, target)
    print('Expected:  -1')
    print('Output:    ' + str(result) + '\n')

    nums = [4,5,6,7,0,1,2]
    target = -1
    result = s.search(nums, target)
    print('Expected:  -1')
    print('Output:    ' + str(result) + '\n')

    nums = [3,1]
    target = 0
    result = s.search(nums, target)
    print('Expected:  -1')
    print('Output:    ' + str(result) + '\n')

    nums = [3,1]
    target = 3
    result = s.search(nums, target)
    print('Expected:  0')
    print('Output:    ' + str(result) + '\n')

    nums = [3,1]
    target = 1
    result = s.search(nums, target)
    print('Expected:  1')
    print('Output:    ' + str(result) + '\n')

test()