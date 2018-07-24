// 771. Jewels and Stones
//
// You're given strings J representing the types of stones that are jewels, 
// and S representing the stones you have.  Each character in S is a type 
// of stone you have.  You want to know how many of the stones you have are
// also jewels.
//
// The letters in J are guaranteed distinct, and all characters in J and S
// are letters. Letters are case sensitive, so "a" is considered a
// different type of stone from "A".
//
// Example 1:
//
// Input: J = "aA", S = "aAAbbbb"
// Output: 3
//
// Example 2:
//
// Input: J = "z", S = "ZZ"
// Output: 0

// Note:
// S and J will consist of letters and have length at most 50.
// The characters in J are distinct.

/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    let numJewels = 0;

    for (let i = 0; i < S.length; i++) {
        if (J.indexOf(S[i]) != -1) {
            numJewels += 1;
        }
    }

    return numJewels;
};

/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones_usingSet = function(J, S) {
    let jewelCount = 0;
    const jewelSet = new Set(J.split(''));

    for (let stone of S.split('')) {
        if (jewelSet.has(stone)) {
            jewelCount += 1;
        }
    }

    return jewelCount;
};

function test(func) {
    console.log("\nTesting numJewelsInStones(J, S)...\n");

    let J, S, result;

    J = "aA";
    S = "aAAbbbb";
    result = func(J, S);
    console.log(result);

    J = "z";
    S = "ZZ";
    result = func(J, S);
    console.log(result);
}

test(numJewelsInStones);
test(numJewelsInStones_usingSet);