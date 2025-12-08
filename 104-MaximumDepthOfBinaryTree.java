class Solution {
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        result = Math.max(left, right) + 1;
        return result;
    }
}
