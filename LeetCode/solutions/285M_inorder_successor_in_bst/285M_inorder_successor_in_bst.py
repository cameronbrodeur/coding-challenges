# 285. Inorder Successor in BST
#
# Given a binary search tree and a node in it, find the in-order successor of that 
# node in the BST.
#
# Note: If the given node has no in-order successor in the tree, return null.
#
# Example 1:
#
# Input: root = [2,1,3], p = 1
#
#   2
#  / \
# 1   3
#
# Output: 2
# Example 2:
#
# Input: root = [5,3,6,2,4,null,null,1], p = 6
#
#       5
#      / \
#     3   6
#    / \
#   2   4
#  /   
# 1
#
# Output: null
#
# Companies asking this question:
#   Google - Editor's choice: Frequently asked in Google phone interview.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # ***** Implementation is *NOT* correct! *****
    def inorderSuccessor(self, root, p):
        """
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        previousNode = None
        if root != None:
            previousNode = root

        runner = root
        while (runner != None) and (runner.val != p.val):
            if p.val < runner.val:
                previousNode = runner
                runner = runner.left
            else:
                runner = runner.right
        
        if runner == None:
            return None

        if runner.right != None:
            return runner.right
        elif previousNode.val > runner.val:
            return previousNode
        else:
            return None

    # ***** Implementation is correct! *****
    def inorderSuccessor_improved(self, root, p):
        """
        :type root: TreeNode
        :type p: TreeNode
        :rtype: TreeNode
        """
        successor = None
        while root:
            if p.val < root.val:
                successor = root
                root = root.left
            else:
                root = root.right
        return successor

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
    print('Testing inorderSuccessor(self, root, p)...\n')

    s = Solution()
    tree = Tree()

    nodes = [2, 1, 3]
    p = TreeNode(1)
    tree.create(nodes)
    result = s.inorderSuccessor(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val
    print('Expected:  2')
    print('Output:    ' + str(val) + '\n')

    nodes = [5, 3, 6, 2, 4, None, None, 1]
    p = TreeNode(6)
    tree.create(nodes)
    result = s.inorderSuccessor(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val    
    print('Expected:  None')
    print('Output:    ' + str(val) + '\n')

    nodes = [2, 1]
    p = TreeNode(1)
    tree.create(nodes)
    result = s.inorderSuccessor(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val    
    print('Expected:  2')
    print('Output:    ' + str(val) + '\n')

    nodes = [2, 1]
    p = TreeNode(2)
    tree.create(nodes)
    result = s.inorderSuccessor(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val
    print('Expected:  None')
    print('Output:    ' + str(val) + '\n')

    nodes = [0]
    p = TreeNode(0)
    tree.create(nodes)
    result = s.inorderSuccessor(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val
    print('Expected:  None')
    print('Output:    ' + str(val) + '\n')

    #        6
    #      /   \
    #     2     8
    #    / \   / \
    #   0  4  7   9
    #     / \
    #    3  5

    nodes = [6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]
    p = TreeNode(2)
    tree.create(nodes)
    result = s.inorderSuccessor(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val
    print('Expected:  3')
    print('Output:    ' + str(val) + '\n')

def test_improved():
    print('Testing inorderSuccessor_improved(self, root, p)...\n')

    s = Solution()
    tree = Tree()

    nodes = [2, 1, 3]
    p = TreeNode(1)
    tree.create(nodes)
    result = s.inorderSuccessor_improved(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val
    print('Expected:  2')
    print('Output:    ' + str(val) + '\n')

    nodes = [5, 3, 6, 2, 4, None, None, 1]
    p = TreeNode(6)
    tree.create(nodes)
    result = s.inorderSuccessor_improved(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val
    print('Expected:  None')
    print('Output:    ' + str(val) + '\n')

    nodes = [2, 1]
    p = TreeNode(1)
    tree.create(nodes)
    result = s.inorderSuccessor_improved(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val    
    print('Expected:  2')
    print('Output:    ' + str(val) + '\n')

    nodes = [2, 1]
    p = TreeNode(2)
    tree.create(nodes)
    result = s.inorderSuccessor_improved(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val    
    print('Expected:  None')
    print('Output:    ' + str(val) + '\n')

    nodes = [0]
    p = TreeNode(0)
    tree.create(nodes)
    result = s.inorderSuccessor_improved(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val    
    print('Expected:  None')
    print('Output:    ' + str(val) + '\n')

    #        6
    #      /   \
    #     2     8
    #    / \   / \
    #   0  4  7   9
    #     / \
    #    3  5

    nodes = [6, 2, 8, 0, 4, 7, 9, None, None, 3, 5]
    p = TreeNode(2)
    tree.create(nodes)
    result = s.inorderSuccessor_improved(tree.root, p)
    if result == None:
        val = None
    else:
        val = result.val
    print('Expected:  3')
    print('Output:    ' + str(val) + '\n')

test()
test_improved()