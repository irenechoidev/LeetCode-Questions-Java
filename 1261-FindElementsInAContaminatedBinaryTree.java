class FindElements {
    Map<Integer, TreeNode> map = new HashMap<>();

    public FindElements(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        root.val = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();

                if (curr.left != null) {
                    curr.left.val = 2 * curr.val + 1;
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    curr.right.val = 2 * curr.val + 2;
                    queue.add(curr.right);
                }

                map.put(curr.val, curr);
            }
        }
    }

    public boolean find(int target) {
        return map.get(target) != null ? true : false;
    }
}