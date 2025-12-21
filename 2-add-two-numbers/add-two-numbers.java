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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0, l1);
        ListNode root = res;
        int carry = 0;

        while(l2!=null) {
            if(root.next == null) {
                root.next = new ListNode(0);
            }
            root = root.next;
            int sum = root.val + l2.val + carry;
            root.val = sum%10;
            carry = sum/10;
            l2 = l2.next;
        }

        while(carry > 0) {
            if(root.next == null) {
                root.next = new ListNode(0);
            }
            root = root.next;
            int sum = root.val + carry;
            root.val = sum%10;
            carry = sum/10;
        }

        return res.next;
    }
}