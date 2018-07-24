// 289. Game of Life
//
// According to the Wikipedia's article: "The Game of Life, also known simply as 
// Life, is a cellular automaton devised by the British mathematician John Horton 
// Conway in 1970."
//
// Given a board with m by n cells, each cell has an initial state live (1) or 
// dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, 
// diagonal) using the following four rules (taken from the above Wikipedia 
// article):
//
// 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
// 2. Any live cell with two or three live neighbors lives on to the next generation.
// 3. Any live cell with more than three live neighbors dies, as if by over-population..
// 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//
// Write a function to compute the next state (after one update) of the board 
// given its current state.
//
// Follow up: 
// Could you solve it in-place? Remember that the board needs to be updated at the 
// same time: You cannot update some cells first and then use their updated values 
// to update other cells.
//
// In this question, we represent the board using a 2D array. In principle, the 
// board is infinite, which would cause problems when the active area encroaches 
// the border of the array. How would you address these problems?
//
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all 
// test cases.
//
// Companies asking this question:
//      Google - Editor's choice: Frequently asked in Google onsite interview.

/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {
    let nextBoard = new Array(board.length);
    for (let i = 0; i < nextBoard.length; i++) {
        nextBoard[i] = new Array(board[0].length).fill(0);
    }

    let numNeighbors;

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            numNeighbors = getNumNeighbors(i, j, board);
            if (board[i][j] === 1) {
                (numNeighbors === 2) || (numNeighbors === 3) ? nextBoard[i][j] = 1 : nextBoard[i][j] = 0;
            } else {
                numNeighbors === 3 ? nextBoard[i][j] = 1 : nextBoard[i][j] = 0;
            }
        }
    }

    for (let i = 0; i < board.length; i++) {            // Copy the contents of 'nextBoard' to 'board', as exercise requires
        for (let j = 0; j < board[i].length; j++) {     // we pass original board w/ changes for this timestep back to caller
            board[i][j] = nextBoard[i][j];              // DO NOT RETURN nextBoard!!!
        }
    }
};

function getNumNeighbors(i, j, board) {
    let numNeighbors = 0;

    if (((i - 1) >= 0) && (board[i - 1][j] === 1)) { numNeighbors++; }
    if (((i + 1) < board.length) && (board[i + 1][j] === 1)) { numNeighbors++; }
    if (((j - 1) >= 0) && (board[i][j - 1] === 1)) { numNeighbors++; }
    if (((j + 1) < board[i].length) && (board[i][j + 1] === 1)) { numNeighbors++; }
    if (((i - 1) >= 0)  && ((j - 1) >= 0) && (board[i - 1][j - 1] === 1)) { numNeighbors++; }
    if (((i + 1) < board.length)  && ((j - 1) >= 0) && (board[i + 1][j - 1] === 1)) { numNeighbors++; }
    if (((i - 1) >= 0)  && ((j + 1) < board[i].length) && (board[i - 1][j + 1] === 1)) { numNeighbors++; }
    if (((i + 1) < board.length)  && ((j + 1) < board[i].length) && (board[i + 1][j + 1] === 1)) { numNeighbors++; }

    return numNeighbors;
}

function test(func) {
    console.log("Testing gameOfLife(board)...\n");

    let board;

    board = [
             [0,0,0,0,0],
             [0,0,1,0,0],
             [0,0,1,0,0],
             [0,0,1,0,0],
             [0,0,0,0,0]
            ];
    func(board);
    console.log('Expected: 0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0');
    console.log('Output:   ' + board);

    board = [[0,0]];
    func(board);
    console.log('Expected: 0,0');
    console.log('Output:   ' + board);

    board = [[1]];
    func(board);
    console.log('Expected: 0');
    console.log('Output:   ' + board);

    board = [[1,1],[1,0]];
    func(board);
    console.log('Expected: 1,1,1,1');
    console.log('Output:   ' + board);

    board = [[0,0,0,0,0,0],[0,0,1,1,0,0],[0,1,0,0,1,0],[0,0,1,1,0,0],[0,0,0,0,0,0]];
    func(board);
    console.log('Expected: 0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0');
    console.log('Output:   ' + board);
}

test(gameOfLife);
