// 100. Same Tree
//
// Given two binary trees, write a function to check if they are the same or not.
//
// Two binary trees are considered the same if they are structurally identical and 
// the nodes have the same value.
//
// Example 1:
//
// Input:     1         1
//           / \       / \
//          2   3     2   3
//
//         [1,2,3],  [1,2,3]
//
// Output: true
//
// Example 2:
//
// Input:     1         1
//           /           \
//          2             2
//
//         [1,2],     [1,null,2]
//
// Output: false
//
// Example 3:
//
// Input:     1         1
//           / \       / \
//          2   1     1   2
//
//         [1,2,1],  [1,1,2]
//
// Output: false

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

class SameTree_100E {
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

    // This solution builds a list representation of the trees p and q. The lists are then compared
    // for equality (list are of the same size and ordering of elements in each list is identical). This
    // solution has additional space complexity of O(m + n), where m and n are the lengths of the list 
    // representations of trees p and q, respectively.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> pList = new ArrayList<Integer>();
        ArrayList<Integer> qList = new ArrayList<Integer>();

        treeToList(p, pList);
        treeToList(q, qList);

        return pList.equals(qList);
    }

    // Recursive function to perform a pre-order traversal of the tree. As each node in
    // the tree is processed, add the node's val (or null) to the list representation 
    // of the tree.
    public void treeToList(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }

        list.add(root.val);
        treeToList(root.left, list);
        treeToList(root.right, list);
    }

    // Traverses trees p and q simultaneously, comparing node values as we go.
    public boolean isSameTree_improved(TreeNode p, TreeNode q) {
        if ((p == null) && (q == null)) {
            return true;
        }

        if ((p == null) || (q == null)) {
            return false;
        }

        if (p.val == q.val) {
            boolean pResult = isSameTree_improved(p.left, q.left);
            boolean qResult = isSameTree_improved(p.right, q.right);
            return (pResult && qResult);
        } 

        return false;
    }

    public void test() {
        System.out.println("Testing isSameTree(TreeNode p, TreeNode q)...\n");

        List<Integer> nodesList;
        Tree p, q = null;
        boolean result;

        nodesList = Arrays.asList(1,2,3);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(1,2,3);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree(p.root, q.root);
        System.out.println("Expected:  true");
        System.out.println("Output:    " + result + "\n");

        nodesList = Arrays.asList(1,2);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(1,null,2);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree(p.root, q.root);
        System.out.println("Expected:  false");
        System.out.println("Output:    " + result + "\n");

        nodesList = Arrays.asList(1,2,1);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(1,1,2);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree(p.root, q.root);
        System.out.println("Expected:  false");
        System.out.println("Output:    " + result + "\n");

        nodesList = Arrays.asList(5,-685,2970,-755,-462,2770,3620,null,-714,-649,434,373,2913,3337,4201,null,null,null,-497,-400,-95,313,1620,2838,null,3228,3574,3874,4262,-589,-484,null,-225,-183,null,240,null,1357,2342,null,null,2988,3262,3434,null,3658,3885,null,null,-622,null,null,null,-381,null,null,null,150,null,1237,1538,2235,2593,null,3072,null,null,3349,3490,null,3760,null,4187,null,null,null,-325,74,null,701,1246,1439,1583,2136,2249,2553,2661,3053,3174,null,3384,3465,null,3686,3855,3971,null,null,null,null,null,527,913,null,1283,null,null,null,null,1945,2219,null,null,2370,null,null,2694,3007,null,3109,null,null,null,null,null,null,null,null,null,null,4058,519,624,712,972,null,null,1736,1954,null,null,null,2467,2692,null,null,null,null,3115,null,4100,-203,null,null,null,null,725,null,1227,1670,1745,1952,2030,2427,null,null,null,null,null,null,null,null,null,null,817,1056,null,null,null,null,1852,null,null,null,2098,null,null,null,null,null,1133,1834,1929);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(5,-685,2970,-755,-462,2770,3620,null,-714,-649,434,373,2913,3337,4201,null,null,null,-497,-400,-95,313,1620,2838,null,3228,3574,3874,4262,-589,-484,null,-225,-183,null,240,null,1357,2342,null,null,2988,3262,3434,null,3658,3885,null,null,-622,null,null,null,-381,null,null,null,150,null,1237,1538,2235,2593,null,3072,null,null,3349,3490,null,3760,null,4187,null,null,null,-325,74,null,701,1246,1439,1583,2136,2249,2553,2661,3053,3174,null,3384,3465,null,3686,3855,3971,null,null,null,null,null,527,913,null,1283,null,null,null,null,1945,2219,null,null,2370,null,null,2694,3007,null,3109,null,null,null,null,null,null,null,null,null,null,4058,519,624,712,972,null,null,1736,1954,null,null,null,2467,2692,null,null,null,null,3115,null,4100,-203,null,null,null,null,725,null,1227,1670,1745,1952,2030,2427,null,null,null,null,null,null,null,null,null,null,817,1056,null,null,null,null,1852,null,null,null,2098,null,null,null,null,null,1133,1834,1929);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree(p.root, q.root);
        System.out.println("Expected:  true");
        System.out.println("Output:    " + result + "\n");
    }

    public void test_improved() {
        System.out.println("Testing isSameTree_improved(TreeNode p, TreeNode q)...\n");

        List<Integer> nodesList;
        Tree p, q = null;
        boolean result;

        nodesList = Arrays.asList(1,2,3);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(1,2,3);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree_improved(p.root, q.root);
        System.out.println("Expected:  true");
        System.out.println("Output:    " + result + "\n");

        nodesList = Arrays.asList(1,2);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(1,null,2);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree_improved(p.root, q.root);
        System.out.println("Expected:  false");
        System.out.println("Output:    " + result + "\n");

        nodesList = Arrays.asList(1,2,1);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(1,1,2);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree_improved(p.root, q.root);
        System.out.println("Expected:  false");
        System.out.println("Output:    " + result + "\n");

        nodesList = Arrays.asList(5,-685,2970,-755,-462,2770,3620,null,-714,-649,434,373,2913,3337,4201,null,null,null,-497,-400,-95,313,1620,2838,null,3228,3574,3874,4262,-589,-484,null,-225,-183,null,240,null,1357,2342,null,null,2988,3262,3434,null,3658,3885,null,null,-622,null,null,null,-381,null,null,null,150,null,1237,1538,2235,2593,null,3072,null,null,3349,3490,null,3760,null,4187,null,null,null,-325,74,null,701,1246,1439,1583,2136,2249,2553,2661,3053,3174,null,3384,3465,null,3686,3855,3971,null,null,null,null,null,527,913,null,1283,null,null,null,null,1945,2219,null,null,2370,null,null,2694,3007,null,3109,null,null,null,null,null,null,null,null,null,null,4058,519,624,712,972,null,null,1736,1954,null,null,null,2467,2692,null,null,null,null,3115,null,4100,-203,null,null,null,null,725,null,1227,1670,1745,1952,2030,2427,null,null,null,null,null,null,null,null,null,null,817,1056,null,null,null,null,1852,null,null,null,2098,null,null,null,null,null,1133,1834,1929);
        p = new Tree();
        p.create(nodesList);
        nodesList = Arrays.asList(5,-685,2970,-755,-462,2770,3620,null,-714,-649,434,373,2913,3337,4201,null,null,null,-497,-400,-95,313,1620,2838,null,3228,3574,3874,4262,-589,-484,null,-225,-183,null,240,null,1357,2342,null,null,2988,3262,3434,null,3658,3885,null,null,-622,null,null,null,-381,null,null,null,150,null,1237,1538,2235,2593,null,3072,null,null,3349,3490,null,3760,null,4187,null,null,null,-325,74,null,701,1246,1439,1583,2136,2249,2553,2661,3053,3174,null,3384,3465,null,3686,3855,3971,null,null,null,null,null,527,913,null,1283,null,null,null,null,1945,2219,null,null,2370,null,null,2694,3007,null,3109,null,null,null,null,null,null,null,null,null,null,4058,519,624,712,972,null,null,1736,1954,null,null,null,2467,2692,null,null,null,null,3115,null,4100,-203,null,null,null,null,725,null,1227,1670,1745,1952,2030,2427,null,null,null,null,null,null,null,null,null,null,817,1056,null,null,null,null,1852,null,null,null,2098,null,null,null,null,null,1133,1834,1929);
        q = new Tree();
        q.create(nodesList);
        result = isSameTree_improved(p.root, q.root);
        System.out.println("Expected:  true");
        System.out.println("Output:    " + result + "\n");
    }

    public static void main(String[] args) {
        SameTree_100E solution = new SameTree_100E();
        solution.test();
        solution.test_improved();
    }
}