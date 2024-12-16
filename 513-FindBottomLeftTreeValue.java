class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.right != null)
                    queue.add(root.right);
                if (root.left != null)
                    queue.add(root.left);
            }
        }
        return root.val;
    }
}