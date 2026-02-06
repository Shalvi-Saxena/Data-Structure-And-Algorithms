class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        Stack<Integer> st = new Stack<>();
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            st.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (!st.isEmpty()) {
            if (st.pop() != slow.val)
                return false;
            slow = slow.next;
        }

        return true;
    }
}
