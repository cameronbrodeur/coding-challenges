// 125. Valid Palindrome
//
// Given a string, determine if it is a palindrome, considering only alphanumeric 
// characters and ignoring cases.
//
// Note: For the purpose of this problem, we define empty string as valid 
// palindrome.
//
// Example 1:
//
// Input: "A man, a plan, a canal: Panama"
// Output: true
//
// Example 2:
//
// Input: "race a car"
// Output: false

/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let i = 0;
    let j = s.length - 1;

    while (i < j) {
        if ((((s[i].toLowerCase() >= 'a') && (s[i].toLowerCase() <= 'z')) || 
           ((s[i] >= '0') && (s[i] <= '9'))) === false) {
                i++;
                continue;
        }
        if ((((s[j].toLowerCase() >= 'a') && (s[j].toLowerCase() <= 'z')) || 
           ((s[j] >= '0') && (s[j] <= '9'))) === false) {            
                j--;
                continue;
        }

        if (s[i].toLowerCase() != s[j].toLowerCase()) {
            return false;
        }

        i++;
        j--;
    }

    return true;
};

function test(func) {
    console.log("Testing isPalindrome(s)...\n");

    let s, result;

    s = "";
    result = func(s);
    console.log('Expected: true');
    console.log('Output:   ' + result);

    s = "A man, a plan, a canal: Panama";
    result = func(s);
    console.log('Expected: true');
    console.log('Output:   ' + result);

    s = "race a car";
    result = func(s);
    console.log('Expected: false');
    console.log('Output:   ' + result);

    s = "0P";
    result = func(s);
    console.log('Expected: false');
    console.log('Output:   ' + result);

    s = "0123abccba3210";
    result = func(s);
    console.log('Expected: true');
    console.log('Output:   ' + result);

    s = "0123abcdcba3210";
    result = func(s);
    console.log('Expected: true');
    console.log('Output:   ' + result);

    s = "0123abccba34210";
    result = func(s);
    console.log('Expected: false');
    console.log('Output:   ' + result);
}

test(isPalindrome);