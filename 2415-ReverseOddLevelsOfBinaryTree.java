class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                list.add(curr);

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

            if (level % 2 != 0) {
                int start = 0;
                int end = list.size() - 1;
                while (start < end) {
                    int temp = list.get(start).val;
                    list.get(start).val = list.get(end).val;
                    list.get(end).val = temp;

                    start += 1;
                    end -= 1;
                }
            }

            level += 1;
        }
        return root;
    }
}
