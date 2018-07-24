// 344. Reverse String
//
// Write a function that takes a string as input and returns the string 
// reversed.
//
// Example:
// Given s = "hello", return "olleh".

/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    let reversed = '';
    for (let i = s.length - 1; i >= 0; i--) {
        reversed += s[i];
    }

    return reversed;
};

function test(func) {
    console.log("Testing reverseString(s)...\n");

    let s, result;

    s = '';
    result = func(s);
    console.log(result);

    s = 'a';
    result = func(s);
    console.log(result);

    s = 'abc';
    result = func(s);
    console.log(result);

    s = 'hello';
    result = func(s);
    console.log(result);
}

test(reverseString);