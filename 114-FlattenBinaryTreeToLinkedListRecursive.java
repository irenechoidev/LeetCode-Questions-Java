class Solution {
    public void flatten(TreeNode root) {
        dfs(root, null);
    }

    private TreeNode dfs(TreeNode root, TreeNode prev) {
        if (root == null)
            return prev;

        TreeNode right = dfs(root.right, prev);
        TreeNode left = dfs(root.left, right);

        root.right = left;
        root.left = null;

        return root;
    }
}
