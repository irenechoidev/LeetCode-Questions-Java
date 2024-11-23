class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void backtrack(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        if (root == null)
            return;

        temp.add(root.val);
        if (isLeaf(root) && root.val == targetSum) {
            result.add(new ArrayList<>(temp));
        }

        backtrack(root.left, targetSum - root.val, result, temp);
        backtrack(root.right, targetSum - root.val, result, temp);

        temp.remove(temp.size() - 1);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
