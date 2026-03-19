class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findHeight(root);
        return findResult(root);
    }

    private TreeNode findResult(TreeNode root) {
        if (root == null)
            return null;

        int left = root.left != null ? map.get(root.left) : 0;
        int right = root.right != null ? map.get(root.right) : 0;

        if (left == right)
            return root;
        else if (left > right)
            return findResult(root.left);
        else {
            return findResult(root.right);
        }
    }

    private int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        int height = Math.max(left, right) + 1;

        map.put(root, height);

        return height;
    }
}