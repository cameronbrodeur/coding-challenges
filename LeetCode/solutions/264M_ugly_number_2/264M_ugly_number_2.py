# 264. Ugly Number II
# 
# Write a program to find the n-th ugly number.
# 
# Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
# 
# Example:
# 
# Input: n = 10
# Output: 12
# Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly 
# numbers.
# 
# Note:  
# 
#   - 1 is typically treated as an ugly number.
#   - n does not exceed 1690.

import heapq

class Solution(object):
    def nthUglyNumber_usingHeap(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0:
            return None

        heap = []
        heapq.heappush(heap, 1)

        while n > 0:
            uglyNumber = heapq.heappop(heap)
            n -= 1

            for factor in [2, 3, 5]:
                if uglyNumber * factor not in heap:
                    heapq.heappush(heap, uglyNumber * factor)

        return uglyNumber

    def nthUglyNumber_using3Pointers(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 0:
            return None

        ugly = [1]
        i2, i3, i5 = 0, 0, 0
        while n > 1:
            u2, u3, u5 = 2 * ugly[i2], 3 * ugly[i3], 5 * ugly[i5]
            uMin = min(u2, u3, u5)
            if uMin == u2:
                i2 += 1
            if uMin == u3:
                i3 += 1
            if uMin == u5:
                i5 += 1
            ugly.append(uMin)
            n -= 1
        return ugly[-1]

def test_usingHeap():
    print('Testing nthUglyNumber_usingHeap(self, n)...\n')

    s = Solution()

    n = 0
    result = s.nthUglyNumber_usingHeap(n)
    print('Expected:  None')
    print('Output:    ' + str(result) + '\n')

    n = 1
    result = s.nthUglyNumber_usingHeap(n)
    print('Expected:  1')
    print('Output:    ' + str(result) + '\n')

    n = 10
    result = s.nthUglyNumber_usingHeap(n)
    print('Expected:  12')
    print('Output:    ' + str(result) + '\n')

    n = 11
    result = s.nthUglyNumber_usingHeap(n)
    print('Expected:  15')
    print('Output:    ' + str(result) + '\n')

    n = 1690
    result = s.nthUglyNumber_usingHeap(n)
    print('Expected:  2123366400')
    print('Output:    ' + str(result) + '\n')

    # n = 1691 (2^31-1) is largest ugly number that can be stored in a signed int on a
    # 32-bit platform. This solution is written in Python and does not have this
    # limitation.
    n = 1691
    result = s.nthUglyNumber_usingHeap(n)
    print('Expected:  2125764000')
    print('Output:    ' + str(result) + '\n')

    n = 5000
    result = s.nthUglyNumber_usingHeap(n)
    print('Expected:  50837316566580')
    print('Output:    ' + str(result) + '\n')

def test_using3Pointers():
    print('Testing nthUglyNumber_using3Pointers(self, n)...\n')

    s = Solution()
    
    n = 0
    result = s.nthUglyNumber_using3Pointers(n)
    print('Expected:  None')
    print('Output:    ' + str(result) + '\n')

    n = 1
    result = s.nthUglyNumber_using3Pointers(n)
    print('Expected:  1')
    print('Output:    ' + str(result) + '\n')

    n = 10
    result = s.nthUglyNumber_using3Pointers(n)
    print('Expected:  12')
    print('Output:    ' + str(result) + '\n')

    n = 11
    result = s.nthUglyNumber_using3Pointers(n)
    print('Expected:  15')
    print('Output:    ' + str(result) + '\n')

    n = 1690
    result = s.nthUglyNumber_using3Pointers(n)
    print('Expected:  2123366400')
    print('Output:    ' + str(result) + '\n')

    # n = 1691 (2^31-1) is largest ugly number that can be stored in a signed int on a
    # 32-bit platform. This solution is written in Python and does not have this
    # limitation.
    n = 1691
    result = s.nthUglyNumber_using3Pointers(n)
    print('Expected:  2125764000')
    print('Output:    ' + str(result) + '\n')

    n = 5000
    result = s.nthUglyNumber_using3Pointers(n)
    print('Expected:  50837316566580')
    print('Output:    ' + str(result) + '\n')

test_usingHeap()
test_using3Pointers()