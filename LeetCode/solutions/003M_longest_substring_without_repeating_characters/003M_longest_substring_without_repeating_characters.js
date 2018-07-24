// 3. Longest Substring Without Repeating Characters
//
// Given a string, find the length of the longest substring without
// repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that
// the answer must be a substring, "pwke" is a subsequence and not a
// substring.

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let charToIndexMap = {};
    let longestSubstring = { startIndex: 0, length: 0 };
    let currentSubstring = { startIndex: 0, length: 0 };

    let i = 0;
    while (i < s.length) {
        let char = s[i];
        if (char in charToIndexMap) { // Repeated char; end of this substring
            // Check if we found a new longest substring and store it (if appropriate)
            if (currentSubstring.length > longestSubstring.length) {
                longestSubstring.length = currentSubstring.length;
                longestSubstring.startIndex = currentSubstring.startIndex;
            }

            // Reset the currentSubstring length and startIndex.
            // We need to fixup the loop index, i, so that it points to one element past
            // the char index in charToIndexMap. Therefore, we will continue looking for
            // a longest substring at s[charToIndexMap[char] + 1].
            currentSubstring.length = 1;
            currentSubstring.startIndex = charToIndexMap[char] + 1;
            i = currentSubstring.startIndex;

            // Clear the charToIndexMap and add the current char to the map. Note
            // that the current char we are processing has changed! Get the current
            // char from the string, s, so we can add the correct char to our map.
            charToIndexMap = {};
            char = s[i];
            charToIndexMap[char] = i;
        } else { // New char
            currentSubstring.length += 1;
            charToIndexMap[char] = i;
        }
        i += 1;
    }

    // It is possible to exit the for loop w/o checking if currentSubstring is a new
    // longestSubstring. (e.g. longest substring is at end of string, s='dvdf')
    // To ensure that longestSubstring is correct and has valid data, check again here.
    if (currentSubstring.length > longestSubstring.length) {
        longestSubstring.length = currentSubstring.length;
        longestSubstring.startIndex = currentSubstring.startIndex;
    }

    return longestSubstring.length;
};

function test(func) {
    console.log("Testing lengthOfLongestSubstring(s)...");

    let s, result;

    s = 'abcabcbb';
    result = func(s);
    console.log(result);

    s = 'bbbbb';
    result = func(s);
    console.log(result);

    s = 'pwwkew';
    result = func(s);
    console.log(result);

    s = 'c';
    result = func(s);
    console.log(result);

    s = 'dvdf';
    result = func(s);
    console.log(result);
}

test(lengthOfLongestSubstring);