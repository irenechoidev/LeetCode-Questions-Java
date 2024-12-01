class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        boolean balanced = Math.abs(left - right) <= 1;

        return balanced && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int height = Math.max(left, right) + 1;
        map.put(root, height);

        return height;
    }
}