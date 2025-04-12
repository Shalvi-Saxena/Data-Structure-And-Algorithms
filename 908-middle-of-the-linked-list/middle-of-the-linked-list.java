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
    int length;
    public ListNode middleNode(ListNode head, int len) {
        if(head.next == null) {
            length = len;
            return head;
        }

        ListNode mid = middleNode(head.next, len+1);

        if(len <= Math.ceil(length/2)) {
            return mid;
        }
        return head;
    }
    public ListNode middleNode(ListNode head) {
        if(head.next == null) {
            return head;
        }

        return middleNode(head, 1);
    }
}