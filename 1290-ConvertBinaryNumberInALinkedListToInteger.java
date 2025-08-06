/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {

        int res = 0;
        List<Integer> list = LinkedListToList(head);

        for (int i = 0; i < list.size(); i++) {
            res = res * 2 + list.get(i) % 2;
        }

        return res;
    }

    private List<Integer> LinkedListToList(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
}