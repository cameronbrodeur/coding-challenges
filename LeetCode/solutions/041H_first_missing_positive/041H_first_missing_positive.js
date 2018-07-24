// 41. First Missing Positive
//
// Given an unsorted integer array, find the smallest missing positive integer.
//
// Example 1:
//
// Input: [1,2,0]
// Output: 3
//
// Example 2:
//
// Input: [3,4,-1,1]
// Output: 2
//
// Example 3:
//
// Input: [7,8,9,11,12]
// Output: 1
//
// Note:
// Your algorithm should run in O(n) time and uses constant extra space.

/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    let i = 0;
    let largestPositive = 1;
    let positivesSet = new Set();                   // Holds a set of positive integers which we have not seen
                                                    // in the array of nums.

    while ((nums[i] <= 0) && (i < nums.length)) {   // Find the first num > 0 in nums
        i++;
    }
    
    if (i !== nums.length) {                        // First num > 0 is also the largest num > 0 we have seen
        largestPositive = nums[i];                  // so far. Store this value for later.
    } else {
        positivesSet.add(1);                        // Searched entire array w/o finding any num > 0
    } 

    for (let j = 1; j <= largestPositive - 1; j++) {    // Add all of the integers (iterated over by 'j') between [1..largestPositive - 1]
        positivesSet.add(j);                            // to the set of positive integers.
    }

    // ---------------------------- Main loop ----------------------------
    for (; i < nums.length; i++) {
        if (nums[i] <= 0) {                         // Ignore any nums <= 0
            continue;
        }
        
        if (nums[i] > largestPositive) {            // Found a num larger than the current largestPositive
            for (let j = largestPositive + 1; j <=  nums[i] - 1; j++) {
                positivesSet.add(j);                // Add all of the integers between [(old)largestPositive + 1...(new)largestPositive - 1]
            }                                       // to the set of positive integers we haven't seen.
            largestPositive = nums[i];              // Store the new largestPositive
        } else {
            positivesSet.delete(nums[i]);           // Remove the current nums[i] from the set of positive integers we haven't seen.
        }
    }

    // ------------ Return the smallest positive integer not seen ------------
    let missingPositives = [...positivesSet];
    let smallestMissingPositive;

    if (missingPositives.length > 0) {
        smallestMissingPositive = missingPositives.reduce((a, b) => Math.min(a, b));
    } else {
        smallestMissingPositive = largestPositive + 1;
    }

    return smallestMissingPositive;
};

/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive_improved = function(nums) {
    // <TO DO>
}

function test(func) {
    console.log("Testing firstMissingPositive(nums)...\n");

    let nums, result;

    nums = [1,2,0];
    result = func(nums);
    console.log('Expected: 3');
    console.log('Output:   ' + result);

    nums = [3,4,-1,1];
    result = func(nums);
    console.log('Expected: 2');
    console.log('Output:   ' + result);

    nums = [7,8,9,11,12];
    result = func(nums);
    console.log('Expected: 1');
    console.log('Output:   ' + result);

    nums = [4];
    result = func(nums);
    console.log('Expected: 1');
    console.log('Output:   ' + result);

    nums = [1,3,1,1,1,0,0,1,4];
    result = func(nums);
    console.log('Expected: 2');
    console.log('Output:   ' + result);

    nums = [-5,1000];
    result = func(nums);
    console.log('Expected: 1');
    console.log('Output:   ' + result);

    nums = [2,11,2,0,3,22,-5,3,2,-6,1,4,-4,-1,0,3,-1,5,-7,2,-8,1,1,22,5,-8,1];
    result = func(nums);
    console.log('Expected: 6');
    console.log('Output:   ' + result);

    nums = [1,10,12,6,16,17,4,20,0,16,1,28,11,30,1,10,53,4,48,-9,50,20,0,25,44,-9,50,24,48,11,41,-4,31,-1,13,-8,28,29,22,38,-8,35,11,15,12,24,36,10,39,29,11,34,-5,23,4];
    result = func(nums);
    console.log('Expected: 2');
    console.log('Output:   ' + result);

    nums = [50,20,36,51,15,-3,39,42,-10,20,9,42,10,48,7,-2,9,16,62,21,45,39,57,30,20,-3,-3,35,2,9,-1,40,40,45,27,-9,52,54,21,52,10,18,9,8,54,26,-6,-1,52,-8,8,33,19,1,51,49,9,58,-1,-1,4,60,49,32];
    result = func(nums);
    console.log('Expected: 3');
    console.log('Output:   ' + result);

    nums = [14,30,43,13,29,15,38,45,36,16,3,38,24,42,11,-10,-4,20,8,9,26,31,36,-10,46,44,9,43,-4,33,42,20,16,-3,3,14,23,-6,12,28,36,41,19,30,-5,-1,30];
    result = func(nums);
    console.log('Expected: 1');
    console.log('Output:   ' + result);
}

test(firstMissingPositive);
//test(firstMissingPositive_improved);
