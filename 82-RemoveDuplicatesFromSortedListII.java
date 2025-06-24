class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode curr = head;

        while (curr != null) {

            while (curr.next != null && prev.next.val == curr.next.val) {
                curr = curr.next;
            }

            boolean isNotDuplicate = prev.next == curr;

            if (isNotDuplicate) {
                prev = curr;
            } else {
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return dummyHead.next;
    }
}
