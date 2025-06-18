class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;

        ListNode l1 = head;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        prev.next = null;

        ListNode l2 = reverseList(slow);
        mergeList(l1, l2);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        boolean isL1 = true;

        while (l1 != null && l2 != null) {
            if (isL1) {
                dummy.next = l1;
                l1 = l1.next;

                isL1 = false;
            } else {
                dummy.next = l2;
                l2 = l2.next;

                isL1 = true;
            }
            dummy = dummy.next;
        }

        if (l1 != null)
            dummy.next = l1;
        if (l2 != null)
            dummy.next = l2;
    }
}