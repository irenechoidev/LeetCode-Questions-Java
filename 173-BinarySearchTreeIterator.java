class BSTIterator {

    List<TreeNode> list;
    int idx;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        idx = -1;

        inorder(root);
    }

    public int next() {
        idx += 1;
        TreeNode curr = list.get(idx);
        return curr.val;
    }

    public boolean hasNext() {
        return list.size() > idx + 1;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}