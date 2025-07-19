class Solution {
    public TreeNode increasingBST(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();

        dfs(root, list);

        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);

            node.left = null;

            if (i < list.size() - 1) {
                node.right = list.get(i + 1);
            }
        }

        return list.get(0);
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;

        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
