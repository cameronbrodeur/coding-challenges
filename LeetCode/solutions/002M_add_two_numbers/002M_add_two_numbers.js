// 2. Add Two Numbers
//
// You are given two non-empty linked lists representing two non-negative
// integers. The digits are stored in reverse order and each of their
// nodes contain a single digit. Add the two numbers and return it as a
// linked list.
//
// You may assume the two numbers do not contain any leading zero, except
// the number 0 itself.
//
// Example
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let l1Runner = l1;
    let l2Runner = l2;
    let carry = 0;
    let sumHead = new ListNode(0);  // Dummy ListNode to make list initialization simpler
    let sumRunner = sumHead;
    
    while ((l1Runner !== null) || (l2Runner !== null) || carry !== 0) {
        let newDigit = new ListNode(carry);     // sum(carry, l1Runner.val, l2Runner.val)
        
        if (l1Runner !== null) {
            newDigit.val += l1Runner.val;
        }
        
        if (l2Runner !== null) {
            newDigit.val += l2Runner.val;
        }
        
        carry = Math.floor(newDigit.val / 10);  // Calculate the carry value of sum(carry, l1Runner.val, l2Runner.val)
        newDigit.val = newDigit.val % 10;       // Find the least significant digit of sum(carry, l1Runner, l2Runner)
                                                // and store it as the value of the newDigit

        sumRunner.next = newDigit;              // Add the new digit to the sum list

        sumRunner = sumRunner.next;             // Fixup pointers for the next loop iteration
        
        if (l1Runner !== null) {
            l1Runner = l1Runner.next;
        }

        if (l2Runner !== null) {
            l2Runner = l2Runner.next;
        }
    }

    return sumHead.next;    // Skip past the dummy node at head of list and return
};

function test(func) {
    console.log("Testing addTwoNumbers(l1, l2)...");

    let l1, l2, result, resultStr;
    let l1Runner, l2Runner, runner;

    l1 = new ListNode(2);
    l1Runner = l1;
    l1Runner.next = new ListNode(4);
    l1Runner = l1Runner.next;
    l1Runner.next = new ListNode(3);
    l2 = new ListNode(5);
    l2Runner = l2;
    l2Runner.next = new ListNode(6);
    l2Runner = l2Runner.next;
    l2Runner.next = new ListNode(4);

    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8
    result = runner = func(l1, l2);
    resultStr = '';
    while (runner !== null) {
        resultStr += runner.val;
        runner = runner.next;
    }
    console.log(resultStr);

    l1 = new ListNode(5);
    l2 = new ListNode(5);

    // Input: (5) + (5)
    // Output: 0 -> 1
    result = runner = func(l1, l2);
    resultStr = '';
    while (runner !== null) {
        resultStr += runner.val;
        runner = runner.next;
    }
    console.log(resultStr);
}

test(addTwoNumbers);