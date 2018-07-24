// 683. K Empty Slots
//
// There is a garden with N slots. In each slot, there is a flower. The N flowers 
// will bloom one by one in N days. In each day, there will be exactly one flower 
// blooming and it will be in the status of blooming since then.
//
// Given an array flowers consists of number from 1 to N. Each number in the array 
// represents the place where the flower will open in that day.
//
// For example, flowers[i] = x means that the unique flower that blooms at day i will 
// be at position x, where i and x will be in the range from 1 to N.
//
// Also given an integer k, you need to output in which day there exists two flowers 
// in the status of blooming, and also the number of flowers between them is k and 
// these flowers are not blooming.
//
// If there isn't such day, output -1.
//
// Example 1:
//
// Input: 
// flowers: [1,3,2]
// k: 1
// Output: 2
// Explanation: In the second day, the first and the third flower have become blooming.
// 
// Example 2:
//
// Input: 
// flowers: [1,2,3]
// k: 1
// Output: -1
//
// Note:
// The given array will be in the range [1, 20000].
//
// Companies asking this question:
//      Google - Online assessment question.

/**
 * @param {number[]} flowers
 * @param {number} k
 * @return {number}
 */
var kEmptySlots = function(flowers, k) {
    flowers.unshift(-1);                                // !!! Adding a dummy element to front of array might be expensive operation
                                                        // !!! Could reformulate the code below to use 0-indexed arrays rather than
                                                        // !!! 1-indexed arrays, but code might be less readable.
                                                        
    let bloomed = Array(flowers.length).fill(false);
    const numDays = flowers.length - 1;                 // Since the [0] element of array doesn't contain a flower
                                                        // be sure to not include this in the number of days
    for (let day = 1; day <= numDays; day++) {
        const todaySlot = flowers[day];
        bloomed[todaySlot] = true;

        // Check if there is a blooming flower k slots to the left and right of today's slot
        let searchLeft = false, searchRight = false;
        if (((todaySlot - 1 - k) >= 1) && ((bloomed[todaySlot - 1 - k]) === true)) {
            searchLeft = true;
        }
        if (((todaySlot + 1 + k) < bloomed.length) && ((bloomed[todaySlot + 1 + k]) === true)) {
            searchRight = true;
        }

        // Search left/right for k empty slots between today's bloom and the bloom k slots away
        // If we find a pair of flowers that satisfy the k empty slots requirement, return day
        let leftEmpty = true, rightEmpty = true;
        if (searchLeft) {
            for (let i = todaySlot - 1; i > todaySlot - 1 - k; i--) {
                if (bloomed[i] === true) {
                    leftEmpty = false;
                }
            }
            if (leftEmpty) {
                return day;
            }
        }
        if (searchRight) {
            for (let i = todaySlot + 1; i < todaySlot + 1 + k; i++) {
                if (bloomed[i] === true) {
                    rightEmpty = false;
                }
            }
            if (rightEmpty) {
                return day;
            }
        }
    }

    return -1;
};

function test(func) {
    console.log("Testing kEmptySlots(flowers, k)...\n");

    let flowers, k, result;

    flowers = [1,3,2];
    k = 1;
    result = func(flowers, k);
    console.log('Expected: 2');
    console.log('Output:   ' + result);

    flowers = [1,2,3];
    k = 1;
    result = func(flowers, k);
    console.log('Expected: -1');
    console.log('Output:   ' + result);
}

test(kEmptySlots);