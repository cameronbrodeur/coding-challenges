# 94. Binary Tree Inorder Traversal
#
# Given a binary tree, return the inorder traversal of its nodes' values.
#
# Example:
#
# Input: [1,null,2,3]
#    1
#     \
#      2
#     /
#    3
#
# Output: [1,3,2]
# Follow up: Recursive solution is trivial, could you do it iteratively?

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal_recursive(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        return self.inorderTraversal_recursive(root.left) + [root.val] + self.inorderTraversal_recursive(root.right)
        
    def inorderTraversal_iterative(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:                            # Check if the root we were passed is None
            return []

        stack = []                                  # Create our local stack
        result = []
        current = root

        while True:
            while current != None:                  # Traverse the tree from current, following the left node until current is empty
                stack.append(current)
                current = current.left

            if current == None and len(stack) > 0:  # We've gone as far left as we can...
                current = stack.pop()               # Pop from stack, store current value in result, and move one node right
                result.append(current.val)
                current = current.right
            else:
                break                               # Done! Stop here and return the result
        
        return result

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# Creates a tree from a list of integers. This tree is *not* a binary search tree. Nodes 
# are inserted into the tree using level-order traversal of the tree.
class Tree(object):
    def __init__(self):
        self.root = None

    def create(self, list):
        if len(list) == 0: 
            return

        self.root = TreeNode(list[0])       # Process first element in list
        nodes = [ self.root ]               # Initialize the list of nodes with top level node (i.e. root node)
        node = None

        i = 1
        while i < len(list):                # Each loop iteration processes both left and right child nodes
            node = nodes.pop(0)

            if (node.left == None) and (list[i] != None):
                node.left = TreeNode(list[i])
                nodes.append(node.left)

            i += 1
            if i == len(list):
                break

            if (node.right == None) and (list[i] != None):
                node.right = TreeNode(list[i])
                nodes.append(node.right)

            i += 1

        return self.root

def test_recursive():
    print('Testing inorderTraversal_recursive(self, root)...\n')

    s = Solution()
    tree = Tree()

    nodes = []
    tree.create(nodes)
    result = s.inorderTraversal_recursive(tree.root)
    print('Expected:  []')
    print('Output:    ' + str(result) + '\n')

    nodes = [1, None, 2, 3]
    tree.create(nodes)
    result = s.inorderTraversal_recursive(tree.root)
    print('Expected:  [1, 3, 2]')
    print('Output:    ' + str(result) + '\n')

    #        6
    #      /   \
    #     2     8
    #    / \   / \
    #   0  4  7   9
    #     / \
    #    3  5
    nodes = [6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]
    tree.create(nodes)
    result = s.inorderTraversal_recursive(tree.root)
    print('Expected:  [0, 2, 3, 4, 5, 6, 7, 8, 9]')
    print('Output:    ' + str(result) + '\n')

def test_iterative():
    print('Testing inorderTraversal_iterative(self, root)...\n')

    s = Solution()
    tree = Tree()

    nodes = []
    tree.create(nodes)
    result = s.inorderTraversal_iterative(tree.root)
    print('Expected:  []')
    print('Output:    ' + str(result) + '\n')

    nodes = [1, None, 2, 3]
    tree.create(nodes)
    result = s.inorderTraversal_iterative(tree.root)
    print('Expected:  [1, 3, 2]')
    print('Output:    ' + str(result) + '\n')

    #        6
    #      /   \
    #     2     8
    #    / \   / \
    #   0  4  7   9
    #     / \
    #    3  5
    nodes = [6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]
    tree.create(nodes)
    result = s.inorderTraversal_iterative(tree.root)
    print('Expected:  [0, 2, 3, 4, 5, 6, 7, 8, 9]')
    print('Output:    ' + str(result) + '\n')

test_recursive()
test_iterative()