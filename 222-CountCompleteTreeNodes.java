class Solution {
    int result = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        result += 1;

        dfs(root.left);
        dfs(root.right);

    }
}
