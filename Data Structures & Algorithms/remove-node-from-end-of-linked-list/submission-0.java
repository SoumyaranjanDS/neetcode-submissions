/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // reverse the list
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        // point head to the last of the  list
        head = prev;
        // remove the n-th node from start
        if (n == 1) {
            head = head.next;
        } else {
            ListNode temp = head;
            for (int i = 1; i < n - 1; i++) {
                temp = temp.next;
            }
            // remove the node
            temp.next = temp.next.next;
        }
        // reverse again and return the head
        prev = null;
        curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
