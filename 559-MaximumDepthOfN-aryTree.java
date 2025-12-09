class Solution {
    int maxDepth = 0;

    public int maxDepth(Node root) {
        getMaxDepth(root, 1);
        return maxDepth;
    }

    private void getMaxDepth(Node root, int depth) {
        if (root == null)
            return;

        maxDepth = Math.max(maxDepth, depth);

        for (Node child : root.children) {
            getMaxDepth(child, depth + 1);
        }
    }
}