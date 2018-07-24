# 287. Find the Duplicate Number
#
# Given an array nums containing n + 1 integers where each integer is between 
# 1 and n (inclusive), prove that at least one duplicate number must exist. 
# Assume that there is only one duplicate number, find the duplicate one.
#
# Example 1:
#
# Input: [1,3,4,2,2]
# Output: 2
#
# Example 2:
#
# Input: [3,1,3,4,2]
# Output: 3
#
# Note:
#
#   - You must not modify the array (assume the array is read only).
#   - You must use only constant, O(1) extra space.
#   - Your runtime complexity should be less than O(n2).
#   - There is only one duplicate number in the array, but it could be repeated more 
#       than once.

class Solution(object):
    # Naive solution which sorts the array and then iterates through the sorted
    # list to find the duplicate value.
    # Note: This solution does not satisfy the question prompts, as the array
    # is modified during sort.
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                return nums[i]

    # Solution which uses a set to track whether we have seen the current number
    # in the array.
    # Note: This solution does not satisfy the question prompts, as the set uses
    # O(n) additional space.
    def findDuplicate_usingSet(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        seen = set()
        for i in range(len(nums)):
            if nums[i] in seen:
                return nums[i]
            seen.add(nums[i])

    # Solution which uses cycle detection (Floyd's Tortise and Hare alg.) to find 
    # the duplicate number. This solution works because there is guaranteed to be 
    # a duplicate number in the array.
    # Note: This solution satisfies all of the problem requirements.
    def findDuplicate_cycleDetection(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Main phase of algorithm: finding the intersection of the two runners.
        # The hare moves twice as quickly as the tortoise and
        # the distance between them increases by 1 at each step.
        # Eventually they will both be inside the cycle.
        tortise = nums[0]
        hare = nums[0]
        while True:
            tortise = nums[tortise]
            hare = nums[nums[hare]]
            if tortise == hare:
                break

        # Find the entrance to the cycle. This is the duplicate value in the list.
        ptr1 = nums[0]
        ptr2 = tortise
        while ptr1 != ptr2:
            ptr1 = nums[ptr1]
            ptr2 = nums[ptr2]

        return ptr1

def test():
    print('Testing findDuplicate(self, nums)...\n')

    s = Solution()

    nums = [1,3,4,2,2]
    result = s.findDuplicate(nums)
    print('Expected:  2')
    print('Output:    ' + str(result))

    nums = [3,1,3,4,2]
    result = s.findDuplicate(nums)
    print('Expected:  3')
    print('Output:    ' + str(result) + '\n')

def test_usingSet():
    print('Testing findDuplicate_usingSet(self, nums)...\n')
    
    s = Solution()

    nums = [1,3,4,2,2]
    result = s.findDuplicate_usingSet(nums)
    print('Expected:  2')
    print('Output:    ' + str(result))

    nums = [3,1,3,4,2]
    result = s.findDuplicate_usingSet(nums)
    print('Expected:  3')
    print('Output:    ' + str(result) + '\n')

def test_usingCycleDetection():
    print('Testing findDuplicate_cycleDetection(self, nums)...\n')
    
    s = Solution()

    nums = [1,3,4,2,2]
    result = s.findDuplicate_cycleDetection(nums)
    print('Expected:  2')
    print('Output:    ' + str(result))

    nums = [3,1,3,4,2]
    result = s.findDuplicate_cycleDetection(nums)
    print('Expected:  3')
    print('Output:    ' + str(result) + '\n')

test()
test_usingSet()
test_usingCycleDetection()