# 15. 3Sum
# 
# Given an array nums of n integers, are there elements a, b, c in nums such that 
# a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
# 
# Note:
# 
# The solution set must not contain duplicate triplets.
# 
# Example:
# 
# Given array nums = [-1, 0, 1, 2, -1, -4],
# 
# A solution set is:
# [
#   [-1, 0, 1],
#   [-1, -1, 2]
# ]

class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # Iterate through the array, putting each num into a dictionary along
        # with the count of the num
        numsDict = {}
        for num in nums:
            if num in numsDict:
                numsDict[num] += 1
            else:
                numsDict[num] = 1

        threeSumSet = set()

def test():
    print('Testing threeSum(self, nums)...\n')

    s = Solution()

    nums = [-1, 0, 1, 2, -1, -4]
    result = s.threeSum(nums)
    print('Expected:  [[-1, 0, 1],[-1, -1, 2]]')
    print('Output:    ' + result + '\n')

test()
