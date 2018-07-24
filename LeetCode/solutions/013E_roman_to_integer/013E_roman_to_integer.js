// 13. Roman to Integer
//
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
//
// For example, two is written as II in Roman numeral, just two one's added together. 
// Twelve is written as, XII, which is simply X + II. The number twenty seven is 
// written as XXVII, which is XX + V + II.
//
// Roman numerals are usually written largest to smallest from left to right. However,
// the numeral for four is not IIII. Instead, the number four is written as IV.
// Because the one is before the five we subtract it making four. The same principle
// applies to the number nine, which is written as IX. There are six instances where
// subtraction is used:
//
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
//
// Given a roman numeral, convert it to an integer. Input is guaranteed to be within
// the range from 1 to 3999.
//
// Example 1:
//
// Input: "III"
// Output: 3
//
// Example 2:
//
// Input: "IV"
// Output: 4
//
// Example 3:
//
// Input: "IX"
// Output: 9
//
// Example 4:
//
// Input: "LVIII"
// Output: 58
// Explanation: L = 50, V = 5 and III = 3.
//
// Example 5:
//
// Input: "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    s = s.toUpperCase();

    let index = 0;
    let accumulator = 0;

    while (index < s.length) {
        let currentRoman = s[index];

        let nextRoman = '';
        if ((index + 1) < s.length) {
            nextRoman = s[index + 1];
        }

        switch (currentRoman) {
            case 'I':
                if ((nextRoman) === 'V') {
                    accumulator += 4;
                    index += 2;
                } else if ((nextRoman) === 'X') {
                    accumulator += 9;
                    index += 2;
                } else {
                    accumulator += 1;
                    index += 1;
                }
                break;
            case 'V':
                accumulator += 5;
                index += 1;
                break;            
            case 'X':
                if ((nextRoman) === 'L') {
                    accumulator += 40;
                    index += 2;
                } else if ((nextRoman) === 'C') {
                    accumulator += 90;
                    index += 2;
                } else {
                    accumulator += 10;
                    index += 1;
                }
                break;
            case 'L':
                accumulator += 50;
                index += 1;
                break;
            case 'C':
                if ((nextRoman) === 'D') {
                    accumulator += 400;
                    index += 2;
                } else if ((nextRoman) === 'M') {
                    accumulator += 900;
                    index += 2;
                } else {
                    accumulator += 100;
                    index += 1;
                }
                break;
            case 'D':
                accumulator += 500;
                index += 1;
                break;
            case 'M':
                accumulator += 1000;
                index += 1;
                break;
        }
    }

    return accumulator;
};

function test(func) {
    console.log("Testing romanToInt(s)...\n");

    let input, result;

    input = 'III';
    result = func(input);
    console.log(result);

    input = 'IV';
    result = func(input);
    console.log(result);

    input = 'IX';
    result = func(input);
    console.log(result);

    input = 'LVIII';
    result = func(input);
    console.log(result);

    input = 'MCMXCIV';
    result = func(input);
    console.log(result);
}

test(romanToInt);