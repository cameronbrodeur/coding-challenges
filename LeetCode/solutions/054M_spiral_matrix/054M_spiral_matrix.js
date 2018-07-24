// 54. Spiral Matrix
//
// Given a matrix of m x n elements (m rows, n columns), return all elements of 
// the matrix in spiral order.
//
// Example 1:
//
// Input:
// [
//   [ 1, 2, 3 ],
//   [ 4, 5, 6 ],
//   [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]
//
// Example 2:
//
// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
// Companies asking this question:
//      Google - Editor's choice: Frequently asked in Google onsite interview

/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    if (matrix.length === 0) {
        return [];
    }

    const n = matrix.length - 1;
    const m = matrix[0].length - 1;
    const mnSize = matrix[0].length * matrix.length;
    let spiral = [];
    let rightBound = matrix[0].length - 1, bottomBound = matrix.length - 1, leftBound = 0, topBound = 0;

    while (true) {
        // Loop right
        for (let i = leftBound; i <= rightBound; i++) {
            spiral.push(matrix[topBound][i]);
            if (spiral.length === mnSize) {
                return spiral;
            }
        }
        topBound++;

        // Loop down
        for (let i = topBound; i <= bottomBound; i++) {
            spiral.push(matrix[i][rightBound]);
            if (spiral.length === mnSize) {
                return spiral;
            }
        }
        rightBound--;

        // Loop left
        for (let i = rightBound; i >= leftBound; i--) {
            spiral.push(matrix[bottomBound][i]);
            if (spiral.length === mnSize) {
                return spiral;
            }
        }
        bottomBound--;

        // Loop up
        for (let i = bottomBound; i >= topBound; i--) {
            spiral.push(matrix[i][leftBound]);
            if (spiral.length === mnSize) {
                return spiral;
            }
        }
        leftBound++;
    }

    return spiral;
};

function test(func) {
    console.log("Testing spiralOrder(matrix)...\n");

    let matrix, result;

    matrix = [
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
    ];
    result = func(matrix);
    console.log('Expected: [1,2,3,6,9,8,7,4,5]');
    console.log('Output:   [' + result + ']');

    matrix = [
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9,10,11,12]
    ];
    result = func(matrix);
    console.log('Expected: [1,2,3,4,8,12,11,10,9,5,6,7]');
    console.log('Output:   [' + result + ']');
}

test(spiralOrder);