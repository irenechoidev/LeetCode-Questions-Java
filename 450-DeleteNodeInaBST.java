class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null)
                return null;
            if (root.left != null && root.right == null)
                return root.left;
            if (root.left == null && root.right != null)
                return root.right;

            TreeNode maxOnRight = findMaxNode(root.left);
            root.val = maxOnRight.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }

    private TreeNode findMaxNode(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root;
    }
}