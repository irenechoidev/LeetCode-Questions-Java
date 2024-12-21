class Solution {
    int tilt = 0;

    public int findTilt(TreeNode root) {
        postorderSubtreeSumAndTilt(root);
        return tilt;
    }

    private int postorderSubtreeSumAndTilt(TreeNode root) {
        if (root == null)
            return 0;

        int left = postorderSubtreeSumAndTilt(root.left);
        int right = postorderSubtreeSumAndTilt(root.right);

        tilt += Math.abs(left - right);

        return left + right + root.val;

    }
}