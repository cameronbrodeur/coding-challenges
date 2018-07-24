// 21. Merge Two Sorted Lists
//
// Merge two sorted linked lists and return it as a new list. The new list 
// should be made by splicing together the nodes of the first two lists.
//
// Example:
//
// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4

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

class MergeTwoSortedLists_21E {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        head = new ListNode(0);                         // Create dummy node at head of merged list
        ListNode current = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 == null) {
            current.next = l2;
        } else if (l2 == null) {
            current.next = l1;
        }

        head = head.next;                               // Skip over the dummy node at the head
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
        System.out.println("Testing mergeTwoLists(ListNode l1, ListNode l2)...\n");

        ListNode l1, l2, result;

        // Input: 1->2->4, 1->3->4
        l1 = createList(Arrays.asList(1,2,4));
        l2 = createList(Arrays.asList(1,3,4));
        result = this.mergeTwoLists(l1, l2);
        System.out.println("Expected:  1->1->2->3->4->4");
        System.out.println("Output:    " + listToString(result) + "\n");

        // Input: null, null
        l1 = null;
        l2 = null;
        result = this.mergeTwoLists(l1, l2);
        System.out.println("Expected:  ");
        System.out.println("Output:    " + listToString(result) + "\n");

        // Input: null, 1->2->3
        l1 = null;
        l2 = createList(Arrays.asList(1,2,3));
        result = this.mergeTwoLists(l1, l2);
        System.out.println("Expected:  1->2->3");
        System.out.println("Output:    " + listToString(result) + "\n");

        // Input: 1->2->3, null
        l1 = createList(Arrays.asList(1,2,3));
        l2 = null;
        result = this.mergeTwoLists(l1, l2);
        System.out.println("Expected:  1->2->3");
        System.out.println("Output:    " + listToString(result) + "\n");
    }

    public static void main(String[] args) {
        MergeTwoSortedLists_21E solution = new MergeTwoSortedLists_21E();
        solution.test();
    }
}