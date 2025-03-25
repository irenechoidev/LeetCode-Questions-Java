class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode resHead = new ListNode(0);
        ListNode res = resHead;

        res.next = head;

        while (res.next != null && res.next.next != null) {
            ListNode firstNode = res.next;
            ListNode secondNode = res.next.next;

            firstNode.next = secondNode.next;

            res.next = secondNode;
            res.next.next = firstNode;

            res = res.next.next;
        }

        return resHead.next;
    }
}
