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

    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head, prev=null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        return slow;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode root = dummy;

        while(a!=null && b!=null) {
            if(a.val < b.val) {
                dummy.next = a;
                a = a.next;
            } else {
                dummy.next = b;
                b = b.next;
            }
            dummy = dummy.next;
        }

        dummy.next = a==null? b:a;
        return root.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode left = sortList(mid);
        ListNode right = sortList(head);
        
        return merge(left, right);
    }
}