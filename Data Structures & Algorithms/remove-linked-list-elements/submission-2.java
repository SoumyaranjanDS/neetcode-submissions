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
    public ListNode removeElements(ListNode head, int val) {
        // via recursion
        // base case
        if (head == null) {
            return null;
        }

        // check and remove elements from the list
        head.next = removeElements(head.next, val);

        // check if to keep this node or not
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}