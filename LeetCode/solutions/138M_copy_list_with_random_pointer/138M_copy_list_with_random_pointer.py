# 138. Copy List with Random Pointer
# 
# A linked list is given such that each node contains an additional random pointer
# which could point to any node in the list or null.
# 
# Return a deep copy of the list.

# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        newHead = RandomListNode(0)
        newRunner = newHead
        runner = head
        while runner != None:
            newRunner.next = RandomListNode(runner.label)
            newRunner = newRunner.next
            runner = runner.next

        newRunner = newHead.next
        runner = head
        while runner != None:
            if runner.random != None:
                runner2 = newHead
                while runner2.label != runner.random.label:
                    runner2 = runner2.next
                newRunner.random = runner2

            newRunner = newRunner.next
            runner = runner.next

        newHead = newHead.next
        return newHead        

class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

def listFromArray(arr):
    randPtrList = RandomListNode(0)
    runner = randPtrList
    for i in range(len(arr)):
        runner.next = RandomListNode(arr[i][0])
        runner = runner.next

    runner = randPtrList.next
    for i in range(len(arr)):
        if arr[i][1] != None:
            runner2 = randPtrList.next
            while runner2 != None and runner2.label != arr[i][1]:
                runner2 = runner2.next
            runner.random = runner2

        runner = runner.next

    randPtrList = randPtrList.next
    return randPtrList

def listToString(randPtrList):
    if randPtrList == None:
        return 'None'

    s = ''
    runner = randPtrList
    while runner != None:
        if runner.random != None:
            s += '{' + str(runner.label) + ',' + str(runner.random.label) + '},'
        else:
            s += '{' + str(runner.label) + ',None},'
        runner = runner.next
        
    return s[:-1]

def printListDebugInfo(randPtrList, label):
    print('=== Debug info for ' + label + ' ===')
    count = 1
    while randPtrList != None:
        print('Node number ' + str(count) + ' @ ' + str(randPtrList))
        print('\tlabel : ' + str(randPtrList.label))
        print('\tnext : ' + str(randPtrList.next))
        print('\trandom : ' + str(randPtrList.random))
        randPtrList = randPtrList.next
        count += 1

def test():
    print('Testing copyRandomList(self, head)...\n')

    s = Solution()

    # Input: {}
    randPtrArr = []
    head = listFromArray(randPtrArr)
    result = s.copyRandomList(head)
    print('Expected:  ' + listToString(head))
    print('Output:    ' + listToString(result) + '\n')

    # Input: {-1,#}
    randPtrArr = [(-1,None)]
    head = listFromArray(randPtrArr)
    result = s.copyRandomList(head)
    print('Expected:  ' + listToString(head))
    print('Output:    ' + listToString(result) + '\n')

    # Input: {-1,-1}
    randPtrArr = [(-1,-1)]
    head = listFromArray(randPtrArr)
    result = s.copyRandomList(head)
    printListDebugInfo(head, "head")
    printListDebugInfo(result, "result")
    print('Expected:  ' + listToString(head))
    print('Output:    ' + listToString(result) + '\n')

    randPtrArr = [(1,None),(2,7),(3,11),(4,12),(5,None),(6,None),(7,1),(8,None),(9,6),(10,9),(11,14),(12,None),(13,2),(14,None),(15,4)]
    head = listFromArray(randPtrArr)
    result = s.copyRandomList(head)
    printListDebugInfo(head, "head")
    printListDebugInfo(result, "result")
    print('Expected:  ' + listToString(head))
    print('Output:    ' + listToString(result) + '\n')

test()
