class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();

        Set<Integer> toDelete = new HashSet<>();
        for (int i : to_delete)
            toDelete.add(i);

        dfs(root, result, toDelete);

        if (!toDelete.contains(root.val))
            result.add(root);

        return result;
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> result, Set<Integer> toDelete) {
        if (root == null)
            return null;

        root.left = dfs(root.left, result, toDelete);
        root.right = dfs(root.right, result, toDelete);

        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            root = null;
        }

        return root;
    }
}
