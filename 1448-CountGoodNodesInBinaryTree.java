class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int bound) {
        if (root == null)
            return 0;

        int res = root.val >= bound ? 1 : 0;

        res += dfs(root.left, Math.max(root.val, bound));
        res += dfs(root.right, Math.max(root.val, bound));

        return res;
    }
}