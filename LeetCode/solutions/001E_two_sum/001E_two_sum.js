// 1. Two Sum
//
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
// Example:
//
// Given nums = [2, 7, 11, 15], target = 9,
//
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

/**
 * My first solution: O(n^2) time complexity, O(1) space complexity
 * 
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = 1; j < nums.length; j++) {
            if (((nums[i] + nums[j]) === target) && (i != j)) {
                return [i, j];
            }
        }
    }
};

/**
 * Second solution: O(n) time complexity, O(n) space complexity
 * 
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum_usingHash = function(nums, target) {
    let numHash = {};
    for (let i = 0; i < nums.length; i++) {
        numHash[nums[i]] = i;
    }

    for (i = 0; i < nums.length; i++) {
        let compliment = target - nums[i];
        if ((compliment in numHash) && (i != numHash[compliment])) {
                return [i, numHash[compliment]];
        }
    }

    return false;
};

function test(func) {
    console.log("Testing twoSum(nums, target)...");

    let nums, target, result;

    nums = [2,7,11,15];
    target = 9;
    result = func(nums, target);
    console.log(result);

    nums = [2,5,5,15];
    target = 10;
    result = func(nums, target);
    console.log(result);
}

test(twoSum);
test(twoSum_usingHash);