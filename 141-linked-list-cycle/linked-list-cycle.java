/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // System.out.println("head "+head.val);
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;

        while(fast != null && slow != null) {
            // System.out.println("Fast "+fast.val +". slow "+slow.val);
            fast = fast.next != null? fast.next.next : fast.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }

        if( fast == null || slow == null) {
            return false;
        }
        return true;
    }
}