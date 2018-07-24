// 686. Repeated String Match
//
// Given two strings A and B, find the minimum number of times A has to be repeated 
// such that B is a substring of it. If no such solution, return -1.
//
// For example, with A = "abcd" and B = "cdabcdab".
//
// Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring 
// of it; and B is not a substring of A repeated two times ("abcdabcd").
//
// Note:
// The length of A and B will be between 1 and 10000.
//
// Companies asking this question:
//      Google - Online assessment question.

/**
 * @param {string} A
 * @param {string} B
 * @return {number}
 */
var repeatedStringMatch = function(A, B) {
    let startIndexB;
    let repeatedA = A;
    let numRepeatedA = 1;

    let maxNumRepeatedA;
    if (B.length < A.length) {
        maxNumRepeatedA = 2;
    } else {
        maxNumRepeatedA = Math.ceil(B.length / A.length) + 1;
    }

    while (numRepeatedA <= maxNumRepeatedA) {
        startIndexB = repeatedA.indexOf(B);
        if (startIndexB >= 0) {
            return numRepeatedA;
        } else {
            repeatedA += A;
            numRepeatedA++;
        }
    }

    return -1;
};

function test(func) {
    console.log("Testing repeatedStringMatch(A, B)...\n");

    let A, B, result;

    A = 'abcd';
    B = 'cdabcdab';
    result = func(A, B);
    console.log('Expected: 3');
    console.log('Output:   ' + result);

    A = "abcabcabcabc";
    B = "abac";
    result = func(A, B);
    console.log('Expected: -1');
    console.log('Output:   ' + result);
}

test(repeatedStringMatch);