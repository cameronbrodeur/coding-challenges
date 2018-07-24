// 7. Reverse Integer
//
// Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1:
//
// Input: 123
// Output: 321
//
// Example 2:
//
// Input: -123
// Output: -321
//
// Example 3:
//
// Input: 120
// Output: 21
//
// Note:
// Assume we are dealing with an environment which could only store integers 
// within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose 
// of this problem, assume that your function returns 0 when the reversed 
// integer overflows.

/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    let negative = false;

    if (x < 0) {
        negative = true;
        x = -x;
    }
    
    // Convert number to string and then reverse the string
    let str = x.toString();
    str = str.split('').reverse().join('');

    // Convert string back to number
    let result = Number.parseInt(str);
    if (negative) {
        result = -result;
    }

    // Check for integer underflow/overflow
    const MAX_VALUE = Math.pow(2, 31) - 1;
    const MIN_VALUE = -Math.pow(2, 31);
    if ((result > MAX_VALUE) || (result < MIN_VALUE)) {
        return 0;
    }

    return result;
};

/**
 * @param {number} x
 * @return {number}
 */
var reverse_usingDivMod = function(x) {
    let reversedX = 0;
    let sign = Math.sign(x);
    x = Math.abs(x);

    while (true) {
        reversedX += x % 10;
        if (Math.floor(x / 10) !== 0) {
            reversedX *= 10;
            x = Math.floor(x / 10);
        } else {
            break;
        }
    }

    reversedX *= sign;

    // Check for integer underflow/overflow
    const MAX_VALUE = Math.pow(2, 31) - 1;
    const MIN_VALUE = -Math.pow(2, 31);
    if ((reversedX > MAX_VALUE) || (reversedX < MIN_VALUE)) {
        return 0;
    }

    return reversedX;
};

function test(func) {
    console.log("Testing reverse(x)...");

    let x, result;

    x = 123;
    result = func(x);
    console.log(result);

    x = -123;
    result = func(x);
    console.log(result);

    x = 120;
    result = func(x);
    console.log(result);
}

test(reverse);
test(reverse_usingDivMod);