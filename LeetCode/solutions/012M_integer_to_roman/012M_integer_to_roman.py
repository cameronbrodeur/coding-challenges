# 12. Integer to Roman
# 
# Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
# 
# Symbol       Value
# I             1
# V             5
# X             10
# L             50
# C             100
# D             500
# M             1000
# 
# For example, two is written as II in Roman numeral, just two one's added together. 
# Twelve is written as, XII, which is simply X + II. The number twenty seven is 
# written as XXVII, which is XX + V + II.
# 
# Roman numerals are usually written largest to smallest from left to right. However, 
# the numeral for four is not IIII. Instead, the number four is written as IV. 
# Because the one is before the five we subtract it making four. The same principle 
# applies to the number nine, which is written as IX. There are six instances where 
# subtraction is used:
# 
# I can be placed before V (5) and X (10) to make 4 and 9. 
# X can be placed before L (50) and C (100) to make 40 and 90. 
# C can be placed before D (500) and M (1000) to make 400 and 900.
# 
# Given an integer, convert it to a roman numeral. Input is guaranteed to be within 
# the range from 1 to 3999.
# 
# Example 1:
# 
# Input: 3
# Output: "III"
# 
# Example 2:
# 
# Input: 4
# Output: "IV"
# 
# Example 3:
# 
# Input: 9
# Output: "IX"
# 
# Example 4:
# 
# Input: 58
# Output: "LVIII"
# Explanation: C = 100, L = 50, XXX = 30 and III = 3.
# 
# Example 5:
# 
# Input: 1994
# Output: "MCMXCIV"
# Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
#
# Companies asking this question: Twitter

class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num < 1 or num > 3999:
            return 'Invalid input'

        romansList = [
            [1000, 'M'],
            [900, 'CM'],
            [500, 'D'],
            [400, 'CD'],
            [100, 'C'],
            [90, 'XC'],
            [50, 'L'],
            [40, 'XL'],
            [10, 'X'],
            [9, 'IX'],
            [5, 'V'],
            [4, 'IV'],
            [1, 'I']
        ]

        roman = ''
        it = (x for x in romansList)
        while num != 0:
            integerValue, romanDigit = next(it)
            placeValue = (num / integerValue) * integerValue
            while placeValue > 0:
                roman += romanDigit
                placeValue -= integerValue
            num -= (num / integerValue) * integerValue

        return roman

    def intToRoman_recursive(self, num):
        if(num >= 1000):
            return 'M' + self.intToRoman_recursive(num - 1000)
        if(num >= 900):
            return 'CM' + self.intToRoman_recursive(num - 900)
        if(num >= 500):
            return 'D' + self.intToRoman_recursive(num - 500)
        if(num >= 400):
            return 'CD' + self.intToRoman_recursive(num - 400)
        if(num >= 100):
            return 'C' + self.intToRoman_recursive(num - 100)
        if(num >= 90):
            return 'XC' + self.intToRoman_recursive(num - 90)
        if(num >= 50):
            return 'L' + self.intToRoman_recursive(num - 50)
        if(num >= 40):
            return 'XL' + self.intToRoman_recursive(num - 40)
        if(num >= 10):
            return 'X' + self.intToRoman_recursive(num - 10)
        if(num >= 9):
            return 'IX' + self.intToRoman_recursive(num - 9)
        if(num >= 5):
            return 'V' + self.intToRoman_recursive(num - 5)
        if(num >= 4):
            return 'IV' + self.intToRoman_recursive(num - 4)
        if(num >= 1):
            return 'I' + self.intToRoman_recursive(num - 1)
        return ''


def test():
    print('Testing intToRoman(self, num)...\n')

    s = Solution()

    num = 3003
    result = s.intToRoman(num)
    print('Expected:  MMMIII')
    print('Output:    ' + result + '\n')

    num = 3
    result = s.intToRoman(num)
    print('Expected:  III')
    print('Output:    ' + result + '\n')

    num = 4
    result = s.intToRoman(num)
    print('Expected:  IV')
    print('Output:    ' + result + '\n')

    num = 9
    result = s.intToRoman(num)
    print('Expected:  IX')
    print('Output:    ' + result + '\n')

    num = 58
    result = s.intToRoman(num)
    print('Expected:  LVIII')
    print('Output:    ' + result + '\n')

    num = 1994
    result = s.intToRoman(num)
    print('Expected:  MCMXCIV')
    print('Output:    ' + result + '\n')

def test_recursive():
    print('Testing intToRoman_recursive(self, num)...\n')

    s = Solution()

    num = 3003
    result = s.intToRoman_recursive(num)
    print('Expected:  MMMIII')
    print('Output:    ' + result + '\n')

    num = 3
    result = s.intToRoman_recursive(num)
    print('Expected:  III')
    print('Output:    ' + result + '\n')

    num = 4
    result = s.intToRoman_recursive(num)
    print('Expected:  IV')
    print('Output:    ' + result + '\n')

    num = 9
    result = s.intToRoman_recursive(num)
    print('Expected:  IX')
    print('Output:    ' + result + '\n')

    num = 58
    result = s.intToRoman_recursive(num)
    print('Expected:  LVIII')
    print('Output:    ' + result + '\n')

    num = 1994
    result = s.intToRoman_recursive(num)
    print('Expected:  MCMXCIV')
    print('Output:    ' + result + '\n')

test()
test_recursive()