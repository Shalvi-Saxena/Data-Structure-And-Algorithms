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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head, next = head.next;
        ListNode past = null;

        while(curr.next != null) {
            next = curr.next;
            curr.next = past;

            past = curr;
            curr = next;
        }

        curr.next = past;

        return curr;
    }
}