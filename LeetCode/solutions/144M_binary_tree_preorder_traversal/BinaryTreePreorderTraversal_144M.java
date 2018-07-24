// 144. Binary Tree Preorder Traversal
//
// Given a binary tree, return the preorder traversal of its nodes' values.
//
// Example:
//
// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// Output: [1,2,3]
//
// Follow up: Recursive solution is trivial, could you do it iteratively?

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreePreorderTraversal_144M {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        return recursivePreorderTraversal(root, result);
    }
    
    public List<Integer> recursivePreorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        
        result.add(root.val);
        recursivePreorderTraversal(root.left, result);
        recursivePreorderTraversal(root.right, result);

        return result;
    }

    // Definition for a binary tree node.
    public class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode(Integer x) { 
            this.val = x; 
            this.left = null;
            this.right = null;
        }
    }

    // Creates a tree from a list of integers. This tree is *not* a binary search tree unless the 
    // list passed to create() is ordered as a BST. Nodes are inserted into the tree using 
    // level-order traversal of the tree.
    public class Tree {
        TreeNode root;

        Tree() {
            this.root = null;
        }

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
        System.out.println("Testing preorderTraversal(TreeNode root)...\n");

        List<Integer> nodesList;
        Tree tree;
        List<Integer> result;

        nodesList = new ArrayList<Integer>();
        tree = new Tree();
        tree.create(nodesList);
        result = this.preorderTraversal(tree.root);
        System.out.println("Expected:  []");
        System.out.println("Output:    " + result.toString());
        
        nodesList = Arrays.asList(1, null, 2, 3);
        tree = new Tree();
        tree.create(nodesList);
        result = this.preorderTraversal(tree.root);
        System.out.println("Expected:  [1, 2, 3]");
        System.out.println("Output:    " + result.toString());

        nodesList = Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        tree = new Tree();
        tree.create(nodesList);
        result = this.preorderTraversal(tree.root);
        System.out.println("Expected:  [6, 2, 0, 4, 3, 5, 8, 7, 9]");
        System.out.println("Output:    " + result.toString());
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal_144M solution = new BinaryTreePreorderTraversal_144M();
        solution.test();
    }
}
