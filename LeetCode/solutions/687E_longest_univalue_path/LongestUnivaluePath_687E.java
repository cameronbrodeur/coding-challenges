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
//                5
//               / \
//              4   5
//             / \   \
//            1   1   5
// Output:
// 2
//
// Example 2:
//
// Input:
//
//                1
//               / \
//              4   5
//             / \   \
//            4   4   5
// Output:
// 2
//
// Note: The given binary tree has not more than 10000 nodes. The height of the 
// tree is not more than 1000.
//
// Companies asking this question:
//     Google - Online assessment question.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

class LongestUnivaluePath_687E {
    int ans;            // Member variable to store the length of longest path

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) 
            return 0;

        int left = arrowLength(node.left);
        int right = arrowLength(node.right);

        int arrowLeft = 0, arrowRight = 0;

        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }

        ans = Math.max(ans, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }        
    }

    // Creates a tree from a list of integers. This tree is *not* a binary search tree unless the 
    // list passed to create() is ordered as a BST. Nodes are inserted into the tree using 
    // level-order traversal of the tree.
    public class Tree {
        TreeNode root;

        Tree() { this.root = null; }

        void create(List<Integer> nodesList) {
            if (nodesList.size() == 0) {
                return;
            }

            this.root = new TreeNode(nodesList.get(0));
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(this.root);
            TreeNode node = null;

            Integer i = 1;
            while (i < nodesList.size()) {
                node = queue.remove();

                if ((node.left == null) && (nodesList.get(i) != null)) {
                    node.left = new TreeNode(nodesList.get(i));
                    queue.add(node.left);
                }

                i++;
                if (i == nodesList.size()) {
                    break;
                }

                if ((node.right == null) && (nodesList.get(i) != null)) {
                    node.right = new TreeNode(nodesList.get(i));;
                    queue.add(node.right);
                }

                i++;
            }
        }
    }
    
    public void test() {
        System.out.println("Testing longestUnivaluePath(TreeNode root)...\n");

        List<Integer> nodesList;
        Tree t = null;
        int result;

        // Input:
        //        null
        result = longestUnivaluePath(null);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        // Input:
        //        []
        nodesList = Arrays.asList();
        t = new Tree();
        t.create(nodesList);
        result = longestUnivaluePath(t.root);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");

        // Input:
        //        1
        nodesList = Arrays.asList(1);
        t = new Tree();
        t.create(nodesList);
        result = longestUnivaluePath(t.root);
        System.out.println("Expected:  0");
        System.out.println("Output:    " + result + "\n");
    
        // Input:
        //        5
        //       / \
        //      4   5
        //     / \   \
        //    1   1   5
        nodesList = Arrays.asList(5,4,5,1,1,5);
        t = new Tree();
        t.create(nodesList);
        result = longestUnivaluePath(t.root);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");
    
        // Input:
        //        1
        //       / \
        //      4   5
        //     / \   \
        //    4   4   5
        nodesList = Arrays.asList(1,4,5,4,4,5);
        t = new Tree();
        t.create(nodesList);
        result = longestUnivaluePath(t.root);
        System.out.println("Expected:  2");
        System.out.println("Output:    " + result + "\n");
    }

    public static void main(String[] args) {
        LongestUnivaluePath_687E solution = new LongestUnivaluePath_687E();
        solution.test();
    }
}