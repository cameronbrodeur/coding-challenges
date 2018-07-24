# 148. Sort List
#
# Sort a linked list in O(n log n) time using constant space complexity.
#
# Example 1:
#
# Input: 4->2->1->3
# Output: 1->2->3->4
#
# Example 2:
#
# Input: -1->5->3->4->0
# Output: -1->0->3->4->5

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import heapq

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        heap = []
        sortedList = ListNode(0)
        runner = sortedList

        # Put each node in the list being sorted into our minHeap (priorityQueue)
        while head != None:
            heapq.heappush(heap, (head.val, head))
            head = head.next

        # Pop the smallest valued node off of the heap and add it to the sorted list
        while len(heap) > 0:
            node = heapq.heappop(heap)
            runner.next = node[1]
            runner = runner.next

        runner.next = None
        sortedList = sortedList.next
        return sortedList

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

def createList(array):
    head = ListNode(0)
    runner = head

    for i in range(len(array)):
        node = ListNode(array[i])
        runner.next = node
        runner = runner.next

    head = head.next
    return head

def linkedListToString(linkedList):
    s = ''

    while linkedList != None:
        s += str(linkedList.val) + '->'
        linkedList = linkedList.next

    if len(s) != 0:
        s = s[:-2]              # Remove the extra "->" from the end of s

    return s

def test():
    print('Testing sortList(self, head)...\n')

    s = Solution()
    
    array = [4,2,1,3]
    linkedList = createList(array)
    result = s.sortList(linkedList)
    print('Expected:  1->2->3->4')
    print('Output:    ' + linkedListToString(result) + '\n')

    array = [-1,5,3,4,0]
    linkedList = createList(array)
    result = s.sortList(linkedList)
    print('Expected:  -1->0->3->4->5')
    print('Output:    ' + linkedListToString(result) + '\n')

test()