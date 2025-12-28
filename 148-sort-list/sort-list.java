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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->
            Integer.compare(a.val, b.val)
        );

        while(head != null) {
            pq.add(head);
            head = head.next;
        }

        ListNode root = pq.poll();
        head = root;

        while(!pq.isEmpty()) {
            root.next = pq.poll();
            root = root.next;
        }

        root.next = null;
        return head;
    }
}