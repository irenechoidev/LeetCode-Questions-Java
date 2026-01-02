class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode curr1 = dummy1;

        ListNode dummy2 = new ListNode();
        ListNode curr2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                curr1.next = new ListNode(head.val);
                curr1 = curr1.next;
            } else {
                curr2.next = new ListNode(head.val);
                curr2 = curr2.next;
            }
            head = head.next;
        }
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}