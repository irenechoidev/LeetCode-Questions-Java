class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                sum += curr.val;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            list.add(sum);
        }

        queue.add(root);
        int level = 1;
        root.val = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                int siblingSum = (curr.left != null ? curr.left.val : 0) +
                        (curr.right != null ? curr.right.val : 0);

                if (curr.left != null) {
                    curr.left.val = list.get(level) - siblingSum;
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = list.get(level) - siblingSum;
                    queue.add(curr.right);
                }
            }
            level += 1;
        }
        return root;
    }
}
