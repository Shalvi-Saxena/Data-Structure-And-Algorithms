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
    ListNode curr;
    boolean stop;

    public void reOrder(ListNode head) {
        if(head == null)   return;
        reOrder(head.next);
        if(stop)    return;
        
        if(curr == head) {
            stop = true;
            curr.next = null;
            return;
        }

        if(curr.next == head) {
            stop = true;
            head.next = null;
            return;
        }

        ListNode next = curr.next;
        curr.next = head;
        head.next = next;
        curr = next;
    }

    public void reorderList(ListNode head) {
        curr = head;
        stop = false;
        reOrder(head);
    }
}