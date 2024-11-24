class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {

            // new TreeNode 를 만든다
            TreeNode newRoot = new TreeNode(val);

            // 꼭 newRoot.left에 넣어야 함(not newRoot.right)
            newRoot.left = root;

            return newRoot;
        }

        dfs(root, val, depth, 1);

        return root;
    }

    private void dfs(TreeNode root, int val, int depth, int level) {
        if (root == null)
            return;

        // 계속 level을 하나씩 올려가면서(level+1) dfs 를 하다가
        // depth하나 위에있는 level(depth-1: 여기에 one row를 넣어야 함)보다 하나 작은 level까지
        // 거기서 stop하고 else block로 간다
        if (level < depth - 1) {
            dfs(root.left, val, depth, level + 1);
            dfs(root.right, val, depth, level + 1);

        } else {
            // 기존의 root.left 는 TreeNode left에 넣어놓고,
            // root.right 는 Treenode right에 넣어놓고
            TreeNode left = root.left;
            TreeNode right = root.right;

            // new TreeNode를 만들어서 val을 넣어서 root.left에,
            // 또 하나 만들어서 val넣어서 root,right에 두고
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            // 아까 TreeNode left 에 보관해 놓았던 거를 root.left.left에
            // TreeNode right 에는 root.right
            root.left.left = left;
            root.right.right = right;
        }
    }
}