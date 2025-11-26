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
    public int removeNthNode(ListNode head, int n) {
        if(head == null) {
            return 0;
        }
        int ind = removeNthNode(head.next, n);
        if(ind == n) {
            head.next = head.next.next;
        }

        return ind+1;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = removeNthNode(head, n);

        return i==n? head.next: head;
    }
}