// 687. Longest Univalue Path
//
// Given a binary tree, find the length of the longest path where each node in the 
// path has the same value. This path may or may not pass through the root.
//
// Note: The length of path between two nodes is represented by the number of 
// edges between them.
//
// Example 1:
//
// Input:
//
//               5
//              / \
//             4   5
//            / \   \
//           1   1   5
// Output:
// 2
//
// Example 2:
//
// Input:
//
//               1
//              / \
//             4   5
//            / \   \
//           4   4   5
// Output:
// 2
//
// Note: The given binary tree has not more than 10000 nodes. The height of the 
// tree is not more than 1000.
//
// Companies asking this question:
//      Google - Online assessment question.

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

/**
 * Creates a tree from a list of integers. This tree is *not* a binary search tree. Nodes 
 * are inserted into the tree using level-order traversal of the tree.
 */
function createTreeFromList(list) {
    if (list.length === 0) {
        return null;
    }

    let root = new TreeNode(list[0]);           // Process first element in list
    let nodes = new Array(root);                // Initialize the list of nodes with top level node (i.e. root node)
    let node;

    let i = 1;
    while (i < list.length) {                   // Each loop iteration processes both left and right child nodes
        node = nodes.shift();

        if ((node.left === null) && (list[i] !== null)) {
            node.left = new TreeNode(list[i]);
            nodes.push(node.left);
        }

        i++;
        if (i === list.length) {
            break;
        }

        if ((node.right === null) && (list[i] !== null)) {
            node.right = new TreeNode(list[i]);
            nodes.push(node.right);
        }

        i++;
    }

    return root;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var longestUnivaluePath = function(root) {
    if (root === null) 
        return 0;
    
    return Math.max(
        longestUnivaluePath(root.left),
        longestUnivaluePath(root.right),
        straightUnivaluePath(root.left, root.val) + straightUnivaluePath(root.right, root.val)
    );
};

var straightUnivaluePath = function(node, uniVal) {
    if ((node === null) || (node.val !== uniVal))
        return 0;

    return Math.max(straightUnivaluePath(node.left, uniVal), straightUnivaluePath(node.right, uniVal)) + 1;
};

function test(func) {
    console.log("Testing longestUnivaluePath(root)...\n");

    let root, result;

    // Input:
    //        []
    root = createTreeFromList([]);
    result = func(root);
    console.log('Expected: 0');
    console.log('Output:   ' + result);

    // Input:
    //        null
    root = null;
    result = func(root);
    console.log('Expected: 0');
    console.log('Output:   ' + result);

    // Input:
    //        1
    root = createTreeFromList([1]);
    result = func(root);
    console.log('Expected: 0');
    console.log('Output:   ' + result);

    // Input:
    //        5
    //       / \
    //      4   5
    //     / \   \
    //    1   1   5
    root = createTreeFromList([5,4,5,1,1,5]);
    result = func(root);
    console.log('Expected: 2');
    console.log('Output:   ' + result);

    // Input:
    //        1
    //       / \
    //      4   5
    //     / \   \
    //    4   4   5
    root = createTreeFromList([1,4,5,4,4,5]);
    result = func(root);
    console.log('Expected: 2');
    console.log('Output:   ' + result);
}

test(longestUnivaluePath);