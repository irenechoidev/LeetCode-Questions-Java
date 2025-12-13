class Solution {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        getLongestUnivaluePath(root);
        return res;
    }

    private int getLongestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;

        int left = getLongestUnivaluePath(root.left);
        int right = getLongestUnivaluePath(root.right);

        if (root.left != null && root.val == root.left.val) {
            left += 1;
        } else {
            left = 0;
        }

        if (root.right != null && root.val == root.right.val) {
            right += 1;
        } else {
            right = 0;
        }

        res = Math.max(res, left + right);

        return Math.max(left, right);
    }
}