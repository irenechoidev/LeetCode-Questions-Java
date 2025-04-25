class Solution {
    int result = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return result;
    }

    private void dfs(TreeNode root, int minVal, int maxVal) {
        if (root == null)
            return;

        result = Math.max(result, Math.max(Math.abs(minVal - root.val), Math.abs(maxVal - root.val)));

        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);

        dfs(root.left, minVal, maxVal);
        dfs(root.right, minVal, maxVal);
    }
}