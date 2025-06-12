class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        dfs(root, result, map);
        return result;
    }

    private String dfs(TreeNode root, List<TreeNode> result, Map<String, Integer> map) {
        if (root == null)
            return "#";

        String left = dfs(root.left, result, map);
        String right = dfs(root.right, result, map);

        String serialized = root.val + "," + left + "," + right;

        map.put(serialized, map.getOrDefault(serialized, 0) + 1);
        if (map.get(serialized) == 2)
            result.add(root);

        return serialized;
    }
}
