// 500. Keyboard Row
//
// Given a List of words, return the words that can be typed using letters of 
// alphabet on only one row's of American keyboard like the image below.
//
// Example 1:
//
// Input: ["Hello", "Alaska", "Dad", "Peace"]
// Output: ["Alaska", "Dad"]
//
// Note:
// You may use one character in the keyboard more than once.
// You may assume the input string will only contain letters of alphabet.

/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(words) {
    const rows = ['qwertyuiop', 'asdfghjkl', 'zxcvbnm'];
    let rowNum;
    let result = [];
    
    for (let word of words) {
        rowNum = 0;
        while (rows[rowNum].indexOf(word[0].toLowerCase()) === -1) {
            rowNum++;
        } 
        
        let singleRow = true;
        let i = 0;
        while ((i < word.length) && (singleRow === true)) {
            if (rows[rowNum].indexOf(word[i].toLowerCase()) === -1) {
                singleRow = false;
            }
            i++;
        }
        
        if (singleRow === true) {
            result.push(word);
        }
    }
    
    return result;
};


function test(func) {
    console.log("Testing findWords(words)...\n");

    let words, result;

    words = ["Hello", "Alaska", "Dad", "Peace"];
    result = func(words);
    console.log('Expected: Alaska,Dad');
    console.log('Output:   ' + result);
}

test(findWords);