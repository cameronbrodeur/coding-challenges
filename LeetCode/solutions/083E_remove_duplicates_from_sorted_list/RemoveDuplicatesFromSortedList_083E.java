// 83. Remove Duplicates from Sorted List
//
// Given a sorted linked list, delete all duplicates such that each element appear 
// only once.
//
// Example 1:
//
// Input: 1->1->2
// Output: 1->2
//
// Example 2:
//
// Input: 1->1->2->3->3
// Output: 1->2->3

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.Arrays;
import java.util.List;

class RemoveDuplicatesFromSortedList_083E {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode runner = head;

        while (runner != null) {
            if ((runner.next != null) && (runner.next.val == runner.val)) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }

        return head;
    }

    public ListNode createList(List<Integer> array) {
        ListNode head = new ListNode(0);                // Create a dummy node at head; simplifies insertion of new nodes
        ListNode current = head;

        for (int i = 0; i < array.size(); i++) {
            ListNode node = new ListNode(array.get(i));
            current.next = node;
            current = current.next;
        }

        head = head.next;                               // Skip past the dummy node to first element in the list
        return head;
    }

    public String listToString(ListNode list) {
        String s = new String();

        while (list != null) {
            s += list.val + "->";
            list = list.next;
        }

        if (s.length() != 0) {
            s = s.substring(0, s.length() - 2);         // Remove the extra "->" from the end of s
        }

        return s;
    }

    public void test() {
        System.out.println("Testing deleteDuplicates(ListNode head)...\n");

        ListNode head;
        ListNode result;

        head = createList(Arrays.asList(1,1,2));
        result = deleteDuplicates(head);
        System.out.println("Expected:  1->2");
        System.out.println("Output:    " + listToString(result) + "\n");

        head = createList(Arrays.asList(1,1,2,3,3));
        result = deleteDuplicates(head);
        System.out.println("Expected:  1->2->3");
        System.out.println("Output:    " + listToString(result) + "\n");

        head = createList(Arrays.asList(1,1,1));
        result = deleteDuplicates(head);
        System.out.println("Expected:  1");
        System.out.println("Output:    " + listToString(result) + "\n");
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList_083E solution = new RemoveDuplicatesFromSortedList_083E();
        solution.test();
    }
}