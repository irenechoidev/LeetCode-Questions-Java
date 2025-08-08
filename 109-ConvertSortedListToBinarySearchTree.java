class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        List<Integer> list = fillList(head);
        return constructTree(list, 0, list.size() - 1);
    }

    private TreeNode constructTree(List<Integer> list, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = constructTree(list, start, mid - 1);
        root.right = constructTree(list, mid + 1, end);

        return root;
    }

    private List<Integer> fillList(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
}
