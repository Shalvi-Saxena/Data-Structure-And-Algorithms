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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1) {
            return lists[0];
        } 
        if(lists.length == 0) {
            return null;
        }

        for(int i=1; i<lists.length; i++) {
            ListNode curr1 = lists[0], curr2 = lists[i], prev = null;
            if(curr1 == null && curr2 == null) {
                continue;
            } else if(curr2 == null) {
                continue;
            } else if(curr1 == null) {
                lists[0] = curr2;
                continue;
            } else if(curr2.val <= curr1.val) {
                ListNode temp = curr2;
                curr2 = curr2.next;
                temp.next = curr1;
                lists[0] = temp;
                prev = temp;
            }
            while(curr1 != null && curr2 != null) {
                if(curr2.val <= curr1.val) {
                    ListNode temp = curr2;
                    curr2 = curr2.next;
                    temp.next = curr1;
                    if(prev != null) {
                        prev.next = temp;
                    }
                    prev = temp;
                } else {
                    prev = curr1;
                    curr1 = curr1.next;
                }
            }
            if(curr2 != null && prev != null) {
                prev.next = curr2;
            }
        }
        return lists[0];
    }
}