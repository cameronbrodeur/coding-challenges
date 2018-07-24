// 102. Binary Tree Level Order Traversal
//
// Given a binary tree, return the level order traversal of its nodes' values. 
// (ie, from left to right, level by level).
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// return its level order traversal as:
//
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal_102M {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        LinkedList<TreeNode> queueCurrentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queueNextLevel = new LinkedList<TreeNode>();
        queueNextLevel.add(root);
        
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            queueCurrentLevel = (LinkedList<TreeNode>) queueNextLevel.clone();
            queueNextLevel.clear();

            while (queueCurrentLevel.size() > 0) {
                TreeNode node = queueCurrentLevel.remove();
                level.add(node.val);
                if (node.left != null) {
                    queueNextLevel.add(node.left);
                }
                if (node.right != null) {
                    queueNextLevel.add(node.right);
                }
            }
            result.add(level);

            if (queueNextLevel.size() == 0) {
                break;
            }
        }
        
        return result;
    }

    public List<List<Integer>> levelOrder_improved(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (queue.size() > 0) {
            Integer size = queue.size();
            List<Integer> level = new ArrayList<Integer>();

            while (size > 0) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            result.add(level);
        }
        
        return result;
    }

    public void test() {
        System.out.println("Testing levelOrder(TreeNode root)...\n");

        List<Integer> nodesList;
        Tree tree;
        List<List<Integer>> result;

        nodesList = new ArrayList<Integer>();
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder(tree.root);
        System.out.println("Expected:  []");
        System.out.println("Output:    " + result.toString());
        
        nodesList = Arrays.asList(1, null, 2, 3);
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder(tree.root);
        System.out.println("Expected:  [[1], [2], [3]]");
        System.out.println("Output:    " + result.toString());

        nodesList = Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder(tree.root);
        System.out.println("Expected:  [[6], [2, 8], [0, 4, 7, 9], [3, 5]]");
        System.out.println("Output:    " + result.toString());

        nodesList = Arrays.asList(3, 9, 20, null, null, 15, 7);
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder(tree.root);
        System.out.println("Expected:  [[3], [9, 20], [15, 7]]");
        System.out.println("Output:    " + result.toString());
    }

    public void test_improved() {
        System.out.println("\nTesting levelOrder_improved(TreeNode root)...\n");

        List<Integer> nodesList;
        Tree tree;
        List<List<Integer>> result;

        nodesList = new ArrayList<Integer>();
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder_improved(tree.root);
        System.out.println("Expected:  []");
        System.out.println("Output:    " + result.toString());
        
        nodesList = Arrays.asList(1, null, 2, 3);
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder_improved(tree.root);
        System.out.println("Expected:  [[1], [2], [3]]");
        System.out.println("Output:    " + result.toString());

        nodesList = Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder_improved(tree.root);
        System.out.println("Expected:  [[6], [2, 8], [0, 4, 7, 9], [3, 5]]");
        System.out.println("Output:    " + result.toString());

        nodesList = Arrays.asList(3, 9, 20, null, null, 15, 7);
        tree = new Tree();
        tree.create(nodesList);
        result = this.levelOrder_improved(tree.root);
        System.out.println("Expected:  [[3], [9, 20], [15, 7]]");
        System.out.println("Output:    " + result.toString());
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal_102M solution = new BinaryTreeLevelOrderTraversal_102M();
        solution.test();
        solution.test_improved();
    }
}
