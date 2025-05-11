class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null)
            return false;

        if (head.val == root.val) {
            if (match(head, root)) {
                return true;
            }
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean match(ListNode head, TreeNode root) {
        if (head != null && root != null) {
            if (head.val == root.val) {
                return match(head.next, root.left) || match(head.next, root.right);
            } else {
                return false;
            }
        }
        return head == null;
    }
}
