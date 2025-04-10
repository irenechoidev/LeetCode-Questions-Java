class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();

        if (k == 0) {
            result.add(target.val);
            return result;
        }

        dfs(root, null, map);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while (k > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                for (TreeNode adj : map.get(curr)) {
                    if (!visited.contains(adj)) {
                        queue.add(adj);
                        visited.add(adj);
                    }
                }
            }

            k -= 1;
        }

        while (!queue.isEmpty()) {
            result.add(queue.remove().val);
        }
        return result;
    }

    private void dfs(TreeNode curr, TreeNode prev, Map<TreeNode, List<TreeNode>> map) {
        if (curr == null)
            return;

        map.putIfAbsent(curr, new ArrayList<>());

        if (prev != null) {
            map.get(curr).add(prev);
            map.get(prev).add(curr);
        }

        dfs(curr.left, curr, map);
        dfs(curr.right, curr, map);
    }
}
