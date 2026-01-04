class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return head;
        if (left == right)
            return head;

        ListNode resHead = new ListNode();
        ListNode res = resHead;
        ListNode curr = head;

        for (int i = 1; i < left; i++) {
            res.next = new ListNode(curr.val);
            res = res.next;
            curr = curr.next;
        }

        ListNode prev = null;
        ListNode next = null;
        for (int j = 1; j < right - left + 1; j++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        next = curr.next;
        curr.next = prev;

        while (curr != null) {
            res.next = new ListNode(curr.val);
            res = res.next;
            curr = curr.next;
        }

        while (next != null) {
            res.next = new ListNode(next.val);
            res = res.next;
            next = next.next;
        }

        return resHead.next;
    }
}