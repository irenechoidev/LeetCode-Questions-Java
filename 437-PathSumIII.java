class Solution {
    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, targetSum, 0, map);

        return result;
    }

    private void dfs(
            TreeNode root,
            long targetSum,
            int level,
            Map<Integer, Integer> map) {

        if (root == null)
            return;

        map.put(level, root.val);

        long currentSum = 0;
        for (int i = level; i >= 0; i--) {

            currentSum += map.get(i);
            if (currentSum == targetSum)
                result += 1;
        }

        dfs(root.left, targetSum, level + 1, map);
        dfs(root.right, targetSum, level + 1, map);
    }
}
