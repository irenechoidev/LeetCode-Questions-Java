class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        boolean minIsLesser = min == null || (min != null && root.val > min);
        boolean maxIsGreater = max == null || (max != null && root.val < max);

        return minIsLesser
                && maxIsGreater
                && helper(root.left, min, root.val)
                && helper(root.right, root.val, max);
    }
}
