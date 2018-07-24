// 42. Trapping Rain Water
//
// Given n non-negative integers representing an elevation map where the
// width of each bar is 1, compute how much water it is able to trap after
// raining.
//
//              =
//          =   == =
//        = == ====== 
//       ------------
//         ^ ^^^  ^    calc total volume of water here
//
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
// In this case, 6 units of rain water (blue section) are being trapped.
//
// Example 1:
//
// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
//
//
// Example 2:
//
// Input: [3,1,4,0,4]
// Output: 6
//
//         = =
//       = = =
//       = = =
//       === =
//       -----
//        ^ ^   calc total volume of water here
//
// Companies asking this question:
//      Google - Editor's choice: Frequently asked in Google phone interview.

/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    if (height.length < 3) {
        return 0;
    }

    let maxLeft = height[0], maxRight = height[height.length - 1];
    let trapArea = 0;
    let leftIndex = 0, rightIndex = height.length - 1;

    while (rightIndex > leftIndex) {
        let currentMinMax;
        if (height[leftIndex] < height[rightIndex]) {
            leftIndex++;

            if (height[leftIndex] > maxLeft) {
                maxLeft = height[leftIndex];
            }

            currentMinMax = Math.min(maxLeft, maxRight);
            if (height[leftIndex] < currentMinMax) {
                trapArea +=  currentMinMax - height[leftIndex];
            }
        } else {
            rightIndex--;

            if (height[rightIndex] > maxRight) {
                maxRight = height[rightIndex];
            }

            currentMinMax = Math.min(maxLeft, maxRight);
            if (height[rightIndex] < currentMinMax) {
                trapArea +=  currentMinMax - height[rightIndex];
            }
        }
    }

    return trapArea;
}

function test(func) {
    console.log("Testing trap(height)...\n");

    let height, result;

    height = [5,4,1,2];
    result = func(height);
    console.log('Expected: 1');
    console.log('Output:   ' + result);

    height = [3,1,4,0,4];
    result = func(height);
    console.log('Expected: 6');
    console.log('Output:   ' + result);

    height = [0,1,0,2,1,0,1,3,2,1,2,1];
    result = func(height);
    console.log('Expected: 6');
    console.log('Output:   ' + result);

    height = [4,2,3];
    result = func(height);
    console.log('Expected: 1');
    console.log('Output:   ' + result);
}

test(trap);
