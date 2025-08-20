class Solution {
    int res = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorderDFS(root, k);
        return res;
    }

    private void inorderDFS(TreeNode root, int k) {
        if (root == null)
            return;

        inorderDFS(root.left, k);

        count += 1;
        if (count == k) {
            res = root.val;
            return;
        }

        inorderDFS(root.right, k);

    }
}
