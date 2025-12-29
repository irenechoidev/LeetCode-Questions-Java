class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                boolean isSameLevel = (set.contains(x) && curr.val == y)
                        || (curr.val == x && set.contains(y));

                if (isSameLevel) {
                    return parents.get(x) != parents.get(y);
                }

                set.add(curr.val);

                if (curr.left != null) {
                    parents.put(curr.left.val, curr.val);
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    parents.put(curr.right.val, curr.val);
                    queue.add(curr.right);
                }
            }
        }
        return false;
    }
}