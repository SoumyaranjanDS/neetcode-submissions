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
        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        // move fast to nth node
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // move 2 pointers untill fast reaches end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // remove the slow' s next node
        slow.next = slow.next.next;

        return dummy.next;
    }
}
