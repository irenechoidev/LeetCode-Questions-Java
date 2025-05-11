class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return construct(0, list.size() - 1, list);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private TreeNode construct(int start, int end, List<Integer> list) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = construct(start, mid - 1, list);
        root.right = construct(mid + 1, end, list);

        return root;
    }
}
