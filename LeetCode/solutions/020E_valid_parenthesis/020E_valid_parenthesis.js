// 20. Valid Parentheses
//
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
// determine if the input string is valid.
//
// An input string is valid if:
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.
//
// Example 1:
//
// Input: "()"
// Output: true
//
// Example 2:
//
// Input: "()[]{}"
// Output: true
//
// Example 3:
//
// Input: "(]"
// Output: false
//
// Example 4:
//
// Input: "([)]"
// Output: false
//
// Example 5:
//
// Input: "{[]}"
// Output: true

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(input) {
    let bracketStack = [];
    const openingBracket = '({[';
    const closingBracket = ')}]';
    let match = { 
                    '(': ')', 
                    '{': '}',
                    '[': ']' 
                };

    for (let i = 0; i < input.length; i++) {
        if (openingBracket.indexOf(input[i]) >= 0) {
            bracketStack.push(input[i]);
            continue;
        }

        if (closingBracket.indexOf(input[i]) >= 0) {
            let lastOpeningBracket = bracketStack.pop();
            if (match[lastOpeningBracket] != input[i]) {
                return false;
            }
            continue;
        }
    }

    return bracketStack.length === 0;
};

function test(func) {
    console.log("Testing isValid(s)...\n");

    let input, result;

    input = '()';
    result = func(input);
    console.log(result);

    input = '([{}])';
    result = func(input);
    console.log(result);

    input = '(]';
    result = func(input);
    console.log(result);

    input = ']{}';
    result = func(input);
    console.log(result);
}

test(isValid);