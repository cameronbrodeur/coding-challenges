# 101. Symmetric Tree
#
# Given a binary tree, check whether it is a mirror of itself (ie, symmetric 
# around its center).
#
# For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
#
#     1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3
#
# But the following [1,2,2,null,3,null,3] is not:
#     1
#    / \
#   2   2
#    \   \
#    3    3
#
# Note:
# Bonus points if you could solve it both recursively and iteratively.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

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

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        queue = []
        queue.append(root)
        queue.append(root)

        while len(queue) > 0:
            t1 = queue.pop()
            t2 = queue.pop()

            if t1 == None and t2 == None:
                continue

            if t1 == None or t2 == None:
                return False
                
            if t1.val != t2.val:
                return False
            
            queue.append(t1.left)
            queue.append(t2.right)
            queue.append(t1.right)
            queue.append(t2.left)

        return True

    def isMirror(self, t1, t2):
        if t1 == None and t2 == None:
            return True
        if t1 == None or t2 == None:
            return False
        return t1.val == t2.val and self.isMirror(t1.left, t2.right) and self.isMirror(t1.right, t2.left)

    def isSymmetric_recursive(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.isMirror(root, root)

def test():
    print('Testing isSymmetric(self, root)...\n')
    
    s = Solution()
    tree = Tree()

    nodes = [1, 2, 2, 3, 4, 4, 3]
    tree.create(nodes)
    result = s.isSymmetric(tree.root)
    print('Expected:  True')
    print('Output:    ' + str(result))

    nodes = [1, 2, 2, None, 3, None, 3]
    tree.create(nodes)
    result = s.isSymmetric(tree.root)
    print('Expected:  False')
    print('Output:    ' + str(result) + '\n')

def test_recursive():
    print('Testing isSymmetric_recursive(self, root)...\n')
    
    s = Solution()
    tree = Tree()

    nodes = [1, 2, 2, 3, 4, 4, 3]
    tree.create(nodes)
    result = s.isSymmetric_recursive(tree.root)
    print('Expected:  True')
    print('Output:    ' + str(result))

    nodes = [1, 2, 2, None, 3, None, 3]
    tree.create(nodes)
    result = s.isSymmetric_recursive(tree.root)
    print('Expected:  False')
    print('Output:    ' + str(result) + '\n')

test()
test_recursive()
