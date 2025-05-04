class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        // if (root == null) return root;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == right)
            return root;
        else if (left > right)
            return dfs(root.left);
        else {
            return dfs(root.right);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return Math.max(left, right) + 1;
    }
}
