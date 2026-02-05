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
    public ListNode deleteDuplicates(ListNode head) {
        
        while(head != null && head.next != null && head.val == head.next.val) {
            while(head != null && head.next != null
                     && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        ListNode curr = head;

        while(head != null) {
            if(head.next != null && head.next.next != null && 
                head.next.val == head.next.next.val) {
                while(head.next != null && head.next.next != null && head.next.val == head.next.next.val) {
                    head.next = head.next.next;
                }
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return curr;
    }
}