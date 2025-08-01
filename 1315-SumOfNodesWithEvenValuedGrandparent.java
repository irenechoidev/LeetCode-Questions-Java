/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        if (root.val % 2 == 0) {
            addGrandChildren(root.left);
            addGrandChildren(root.right);
        }

        dfs(root.left);
        dfs(root.right);
    }

    private void addGrandChildren(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null)
            res += root.left.val;
        if (root.right != null)
            res += root.right.val;

        return;
    }
}