class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return root;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (isLeaf(root) && root.val == target) {
            root = null;
        }

        return root;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}