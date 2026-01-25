class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeSort(0, lists.length - 1, lists);
    }

    private ListNode mergeSort(int start, int end, ListNode[] lists) {
        if (start == end)
            return lists[start];
        int mid = start + (end - start) / 2;

        ListNode left = mergeSort(start, mid, lists);
        ListNode right = mergeSort(mid + 1, end, lists);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        return dummy.next;
    }
}