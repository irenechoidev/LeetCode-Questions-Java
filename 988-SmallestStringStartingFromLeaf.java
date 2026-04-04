class Solution {
    String res = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null)
            return;

        path = (char) (root.val + 'a') + path;

        if (isLeaf(root) && (res.isEmpty() || res.compareTo(path) > 0)) {
            res = path;
        }

        dfs(root.left, path);
        dfs(root.right, path);

    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}