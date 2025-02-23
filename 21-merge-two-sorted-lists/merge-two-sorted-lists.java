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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode a = list1.val < list2.val ? list1: list2;
        ListNode b = list1.val < list2.val ? list2: list1;

        ListNode start = a;

        while(a.next != null) {
            if(b == null) break;
            if(b.val < a.next.val) {
                a.next = new ListNode(b.val, a.next);
                b = b.next;
            }
            a = a.next;
        }

        if(b != null ) {
            a.next = b;
        }

        return start;
    }
}