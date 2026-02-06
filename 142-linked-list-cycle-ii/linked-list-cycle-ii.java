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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;

        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next == null? fast.next: fast.next.next;

            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if(fast == null || !hasCycle)   return null;

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}