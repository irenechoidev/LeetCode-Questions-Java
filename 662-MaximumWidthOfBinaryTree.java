class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 0;

        int result = queue.peek().val;

        while (!queue.isEmpty()) {
            int first = -1;
            int last = -1;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                if (curr.left != null) {
                    curr.left.val = curr.val * 2 + 1;
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = curr.val * 2 + 2;
                    queue.add(curr.right);
                }

                if (i == 0)
                    first = curr.val;
                if (i == size - 1)
                    last = curr.val;
            }

            result = Math.max(result, last - first + 1);
        }
        return result;
    }
}
