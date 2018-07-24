# 263. Ugly Number
# 
# Write a program to check whether a given number is an ugly number.
# 
# Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
# 
# Example 1:
# 
# Input: 6
# Output: true
# Explanation: 6 = 2 × 3
# 
# Example 2:
# 
# Input: 8
# Output: true
# Explanation: 8 = 2 × 2 × 2
# 
# Example 3:
# 
# Input: 14
# Output: false 
# Explanation: 14 is not ugly since it includes another prime factor 7.
# 
# Note:
# 
#   - 1 is typically treated as an ugly number.
#   - Input is within the 32-bit signed integer range: [−2^31,  2^31 − 1].

class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False

        while num % 5 == 0:
            num /= 5

        while num % 3 == 0:
            num /= 3

        while num % 2 == 0:
            num /= 2

        if num == 1:
            return True
        else:
            return False
    
def test():
    print('Testing isUgly(self, num)...\n')

    s = Solution()

    num = 6
    result = s.isUgly(num)
    print('Expected:  True')
    print('Output:    ' + str(result) + '\n')

    num = 8
    result = s.isUgly(num)
    print('Expected:  True')
    print('Output:    ' + str(result) + '\n')

    num = 14
    result = s.isUgly(num)
    print('Expected:  False')
    print('Output:    ' + str(result) + '\n')

    num = -2147483648
    result = s.isUgly(num)
    print('Expected:  False')
    print('Output:    ' + str(result) + '\n')
    
test()