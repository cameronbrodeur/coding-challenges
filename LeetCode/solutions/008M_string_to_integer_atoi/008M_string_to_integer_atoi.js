// 8. String to Integer (atoi)
//
// Implement atoi which converts a string to an integer.
//
// The function first discards as many whitespace characters as necessary until the 
// first non-whitespace character is found. Then, starting from this character, 
// takes an optional initial plus or minus sign followed by as many numerical 
// digits as possible, and interprets them as a numerical value.
//
// The string can contain additional characters after those that form the integral 
// number, which are ignored and have no effect on the behavior of this function.
//
// If the first sequence of non-whitespace characters in str is not a valid integral 
// number, or if no such sequence exists because either str is empty or it contains 
// only whitespace characters, no conversion is performed.
//
// If no valid conversion could be performed, a zero value is returned.
//
// Note:
//
// Only the space character ' ' is considered as whitespace character.
// Assume we are dealing with an environment which could only store integers within 
// the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical value is out 
// of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
//
// Example 1:
//
// Input: "42"
// Output: 42
//
// Example 2:
//
// Input: "   -42"
// Output: -42
// Explanation: The first non-whitespace character is '-', which is the minus sign.
//              Then take as many numerical digits as possible, which gets 42.
// Example 3:
//
// Input: "4193 with words"
// Output: 4193
// Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//
// Example 4:
//
// Input: "words and 987"
// Output: 0
// Explanation: The first non-whitespace character is 'w', which is not a numerical 
//              digit or a +/- sign. Therefore no valid conversion could be performed.
// Example 5:
//
// Input: "-91283472332"
// Output: -2147483648
// Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//              Thefore INT_MIN (−2^31) is returned.

/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    if (typeof(str) != 'string') {
        return 0;
    }

    let sign = 1;
    let i = 0;
    while (i < str.length) {
        if (str[i] === ' ') {                       // Check if current char is a space (valid whitespace)
            i++;
            continue;
        }
        if ((str[i] === '+') || (str[i] === '-')) { // Check if current char is +/-
            if (str[i] === '-') {
                sign = -1;
            }
            i++;
            break;
        }
        if ((str[i] >= '0') && (str[i] <= '9')) {   // Check if current char is a numeral 0-9
            break;
        } else {                                    // Non-whitespace char before numeral found (invalid input)
            return 0;
        }
    }

    if (i === str.length) {                         // Reached end of string w/o finding numerals
        return 0;
    }

    let integerStr = '';
    while ((str[i] >= '0') && (str[i] <= '9') && (i !== str.length)) {  // Copy numerals to new string
        integerStr += str[i];
        i++;
    }
    
    let integer = 0;
    for (i = integerStr.length - 1; i >= 0; i--) {
        let power = integerStr.length - 1 - i;
        switch (integerStr[i]) {
            case '0':
                integer += (0 * Math.pow(10, power));
                break;
            case '1':
                integer += (1 * Math.pow(10, power));
                break;
            case '2':
                integer += (2 * Math.pow(10, power));
                break;
            case '3':
                integer += (3 * Math.pow(10, power));
                break;
            case '4':
                integer += (4 * Math.pow(10, power));
                break;
            case '5':
                integer += (5 * Math.pow(10, power));
                break;
            case '6':
                integer += (6 * Math.pow(10, power));
                break;
            case '7':
                integer += (7 * Math.pow(10, power));
                break;
            case '8':
                integer += (8 * Math.pow(10, power));
                break;
            case '9':
                integer += (9 * Math.pow(10, power));
                break;
        }
    }

    integer *= sign;

    const INT_MAX = Math.pow(2, 31) - 1;
    const INT_MIN = -Math.pow(2, 31);

    if (integer > INT_MAX) {
        integer = INT_MAX;
    } else if (integer < INT_MIN) {
        integer = INT_MIN;
    }

    return integer;
};

function test(func) {
    console.log("Testing myAtoi(str)...");

    let str, result;

    str = 42;
    result = func(str);
    console.log('Expected: 0');
    console.log('Output:   ' + result);

    str = '42';
    result = func(str);
    console.log('Expected: 42');
    console.log('Output:   ' + result);

    str = '     -42';
    result = func(str);
    console.log('Expected: -42');
    console.log('Output:   ' + result);

    str = '4193 with words';
    result = func(str);
    console.log('Expected: 4193');
    console.log('Output:   ' + result);

    str = 'words and 987';
    result = func(str);
    console.log('Expected: 0');
    console.log('Output:   ' + result);

    str = '-91283472332';
    result = func(str);
    console.log('Expected: -2147483648');
    console.log('Output:   ' + result);
}

test(myAtoi);