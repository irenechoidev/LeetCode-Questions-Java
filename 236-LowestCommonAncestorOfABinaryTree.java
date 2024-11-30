class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case 1: If the root is null, there's no tree to process
        if (root == null)
            return null;

        // Base case 2: If the current root matches p or q,
        // return it because any ancestor of p or q is itself an ancestor
        if (root.val == p.val || root.val == q.val)
            return root;

        // Recur on both left and right subtrees to find p and q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If only one side returns non-null,
        // propagate that result up as the ancestor.
        if (left == null)
            return right;
        if (right == null)
            return left;

        // If both left and right are non-null,
        // it means p and q are found in different subtrees,
        // and the current root is their LCA.
        return root;
    }
}
