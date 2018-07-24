# 144. Binary Tree Preorder Traversal
#
# Given a binary tree, return the preorder traversal of its nodes' values.
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
# Output: [1,2,3]
# Follow up: Recursive solution is trivial, could you do it iteratively?

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)

    def preorderTraversal_iterative(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []

        result = []
        stack = []
        stack.append(root)

        while len(stack) != 0:
            node = stack.pop()
            result.append(node.val)
            if node.right != None:
                stack.append(node.right)
            if node.left != None:
                stack.append(node.left)

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

def test():
    print('Testing preorderTraversal(self, root)...\n')

    s = Solution()
    tree = Tree()

    nodes = []
    tree.create(nodes)
    result = s.preorderTraversal(tree.root)
    print('Expected:  []')
    print('Output:    ' + str(result) + '\n')

    nodes = [1, None, 2, 3]
    tree.create(nodes)
    result = s.preorderTraversal(tree.root)
    print('Expected:  [1, 2, 3]')
    print('Output:    ' + str(result) + '\n')

    nodes = [6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]
    tree.create(nodes)
    result = s.preorderTraversal(tree.root)
    print('Expected:  [6, 2, 0, 4, 3, 5, 8, 7, 9]')
    print('Output:    ' + str(result) + '\n')

def test_iterative():
    print('Testing preorderTraversal_iterative(self, root)...\n')

    s = Solution()
    tree = Tree()

    nodes = []
    tree.create(nodes)
    result = s.preorderTraversal_iterative(tree.root)
    print('Expected:  []')
    print('Output:    ' + str(result) + '\n')

    nodes = [1, None, 2, 3]
    tree.create(nodes)
    result = s.preorderTraversal_iterative(tree.root)
    print('Expected:  [1, 2, 3]')
    print('Output:    ' + str(result) + '\n')

    nodes = [6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]
    tree.create(nodes)
    result = s.preorderTraversal_iterative(tree.root)
    print('Expected:  [6, 2, 0, 4, 3, 5, 8, 7, 9]')
    print('Output:    ' + str(result) + '\n')

test()
test_iterative()