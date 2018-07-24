# 145. Binary Tree Postorder Traversal
#
# Given a binary tree, return the postorder traversal of its nodes' values.
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
# Output: [3,2,1]
# Follow up: Recursive solution is trivial, could you do it iteratively?

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def postorderTraversal_recursive(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        return self.postorderTraversal_recursive(root.left) + self.postorderTraversal_recursive(root.right) + [root.val]

    def postorderTraversal_iterative(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []

        stack = []
        result = []

        while True:
            # Traverse left until we can't go further left
            while root != None:
                if root.right != None:
                    stack.append(root.right)
                stack.append(root)
                root = root.left

            # No root, so get a new root from the stack
            root = stack.pop()

            # If the new root has a right child *and* the root's right child
            # is the next element on the stack, then we need to process the right
            # child before processing the root.
            if root.right != None and self.peek(stack) is root.right:
                stack.pop()                 # Remove the right child from the stack (discard the element)
                stack.append(root)          # Put the root node onto the stack for processing later
                root = root.right           # Set root to right child to process on next iteration
            else:
                # Traversed as far left as possible on this branch so this is smallest value in branch
                # Append to the result list and set the root to none
                result.append(root.val)
                root = None

            if len(stack) == 0:
                break

        return result

    def peek(self, stack):
        if len(stack) > 0:
            return stack[-1]
        return None

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
    print('Testing postorderTraversal_recursive(self, root)...\n')

    s = Solution()
    tree = Tree()

    nodes = []
    tree.create(nodes)
    result = s.postorderTraversal_recursive(tree.root)
    print('Expected:  []')
    print('Output:    ' + str(result) + '\n')
    
    nodes = [1, None, 2, 3]
    tree.create(nodes)
    result = s.postorderTraversal_recursive(tree.root)
    print('Expected:  [3, 2, 1]')
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
    result = s.postorderTraversal_recursive(tree.root)
    print('Expected:  [0, 3, 5, 4, 2, 7, 9, 8, 6]')
    print('Output:    ' + str(result) + '\n')

def test_iterative():
    print('Testing postorderTraversal_iterative(self, root)...\n')

    s = Solution()
    tree = Tree()

    nodes = []
    tree.create(nodes)
    result = s.postorderTraversal_iterative(tree.root)
    print('Expected:  []')
    print('Output:    ' + str(result) + '\n')

    nodes = [1, None, 2, 3]
    tree.create(nodes)
    result = s.postorderTraversal_iterative(tree.root)
    print('Expected:  [3, 2, 1]')
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
    result = s.postorderTraversal_iterative(tree.root)
    print('Expected:  [0, 3, 5, 4, 2, 7, 9, 8, 6]')
    print('Output:    ' + str(result) + '\n')

test_recursive()
test_iterative()