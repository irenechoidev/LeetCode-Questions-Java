class Solution {
    Integer firstVal = null;
    Integer secondVal = null;
    Integer result = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (firstVal == null) {
            firstVal = root.val;
        } else {
            secondVal = root.val;
            result = Math.min(result, Math.abs(secondVal - firstVal));

            firstVal = secondVal;
        }

        inorder(root.right);
    }
}
