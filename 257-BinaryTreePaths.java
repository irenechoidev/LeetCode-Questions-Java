class Solution {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String path) {
        if (root == null)
            return;

        path += root.val;

        if (isLeaf(root)) {
            res.add(path);
            return;
        }

        dfs(root.left, path + "->");
        dfs(root.right, path + "->");

    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}