// 616. Add Bold Tag in String
//
// Given a string s and a list of strings dict, you need to add a closed pair of 
// bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two 
// such substrings overlap, you need to wrap them together by only one pair of 
// closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, 
// you need to combine them.
//
// Example 1:
//
// Input: 
// s = "abcxyz123"
// dict = ["abc","123"]
// Output:
// "<b>abc</b>xyz<b>123</b>"
//
// Example 2:
//
// Input: 
// s = "aaabbcc"
// dict = ["aaa","aab","bc"]
// Output:
// "<b>aaabbc</b>c"
//
// Note:
// The given dict won't contain duplicates, and its length won't exceed 100.
// All the strings in input have length in range [1, 1000].
//
// Companies asking this question:
//      Editor's choice: Frequently asked in Google phone interview.

/**
 * @param {string} s
 * @param {string[]} dict
 * @return {string}
 */
var addBoldTag = function(s, dict) {
    let boldIndexMap = new Array(s.length).fill(false);

    // Search 's' for each substr in 'dict'. When we find a substr in 's', mark
    // those indexes as true in the boldIndexMap. When we are finished searching,
    // boldIndexMap will tell us which chars in 's' are bold.
    for (let substr of dict) {
        let index = s.indexOf(substr);
        while (index != -1) {
            for (let i = index; i < (index + substr.length); i++) {
                boldIndexMap[i] = true;
            }
            index = s.indexOf(substr, index + 1);
        }
    }

    // Using boldIndexMap, build a new string sBold where all the chars marked true (i.e. 'bold')
    // in boldIndexMap are wrapped in <b>...</b> tags. Return sBold;
    let sBold = '';
    let i = 0;
    while (i < s.length) {
        if (boldIndexMap[i] === false) {
            sBold += s[i];
            i++;
        } else {    // The char at s[i] is start of a bold tag <b>. Copy bold chars to sBold
                    // until we reach the end of this sequence of bold chars and close with </b>
            sBold += '<b>';
            while (boldIndexMap[i] === true) {
                sBold += s[i];
                i++;
            }
            sBold += '</b>';
        }
    }
    return sBold;
};

function test(func) {
    console.log("Testing addBoldTag(s, dict)...\n");

    let s, dict, result;

    s = 'abcxyz123';
    dict = ['abc','123'];
    result = func(s, dict);
    console.log('Expected: <b>abc</b>xyz<b>123</b>');
    console.log('Output:   ' + result);

    s = 'aaabbcc';
    dict = ['aaa','aab','bc'];
    result = func(s, dict);
    console.log('Expected: <b>aaabbc</b>c');
    console.log('Output:   ' + result);
}

test(addBoldTag);
