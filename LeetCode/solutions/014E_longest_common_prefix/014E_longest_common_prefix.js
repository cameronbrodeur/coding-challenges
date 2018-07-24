// 14. Longest Common Prefix
//
// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
// Input: ["flower","flow","flight"]
// Output: "fl"
//
// Example 2:
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
// Note:
// All given inputs are in lowercase letters a-z.

/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (((strs instanceof Array) != true) || (strs.length === 0)) {
        return '';
    }

    let prefix = '';
    let shortestLengthStr = Number.POSITIVE_INFINITY;

    for (let str of strs) {
        if(str.length < shortestLengthStr) {
            shortestLengthStr = str.length;
        }
    }

    for (let charIndex = 0; charIndex < shortestLengthStr; charIndex++) {
        let char = strs[0][charIndex];
        for (let strsIndex = 1; strsIndex < strs.length; strsIndex++) {
            if (strs[strsIndex][charIndex] != char) {
                return prefix;
            }
        }
        prefix += char;
    }
    return prefix;
};

function test(func) {
    console.log("Testing longestCommonPrefix(strs)...\n");

    let strs, result;

    strs = ["flower","flow","flight"];
    result = func(strs);
    console.log('Expected: fl');
    console.log('Output:   ' + result);

    strs = ["dog","racecar","car"];
    result = func(strs);
    console.log('Expected: ');
    console.log('Output:   ' + result);
}

test(longestCommonPrefix);
