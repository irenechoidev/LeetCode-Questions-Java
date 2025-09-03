class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (isLeaf(root) && targetSum - root.val == 0)
            return true;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
