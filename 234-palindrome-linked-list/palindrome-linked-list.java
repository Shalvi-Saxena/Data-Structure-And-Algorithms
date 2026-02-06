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
    
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        
        Stack<ListNode> st = new Stack<>();
        ListNode slow=head, fast = head;

        while(fast != null) {
            if(fast.next == null) {
                slow = slow.next;
                break;
            }
            st.push(slow);
            slow = slow.next;
            fast = fast.next == null? fast.next: fast.next.next;
        }
        while(!st.isEmpty()) {
            if(st.pop().val != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}