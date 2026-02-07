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
    public void reorderList(ListNode head) {
        
        if(head.next == null || head.next.next == null) {
            return;
        }

        Stack<ListNode> st = new Stack<>();
        ListNode slow = head, fast = head, last = null;
        
        while(fast != null && fast.next != null) {
            st.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        head = null;
        if(fast != null) {
            head = slow;
            slow = slow.next;
            head.next = null;
        }

        while(!st.isEmpty()) {
            ListNode first = st.pop();
            first.next = slow;
            slow = slow.next;
 
            first.next.next = head;
            head = first;
        }
    }
}