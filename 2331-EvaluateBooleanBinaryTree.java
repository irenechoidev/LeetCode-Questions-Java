class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null)
            return false;

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2)
            return left == true || right == true;
        else if (root.val == 3)
            return left == true && right == true;
        return root.val == 1;
    }
}