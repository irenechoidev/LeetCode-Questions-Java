class Solution {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int count) {
        if (root == null)
            return;

        count = count * 2 + root.val;
        if (isLeaf(root)) {
            sum += count;
        }

        dfs(root.left, count);
        dfs(root.right, count);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
