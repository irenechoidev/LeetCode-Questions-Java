class Solution {
    // to make Tree
    int index = -1;

    public boolean isValidSerialization(String preorder) {
        // process 'String preorder' to 'String[] nodes' for making Tree and
        // process 'nodes' to 'String originalPreorder' for comparison
        String[] nodes = preorder.split(",");
        String originalPreorder = String.join("", nodes);

        // make Tree from the 'String[] nodes' incrementing index of nodes
        TreeNode root = constructTree(nodes);

        // make String from the Tree iterating preorderDFS
        StringBuilder sb = new StringBuilder();
        preorderDFS(root, sb);

        return sb.toString().equals(originalPreorder);

    }

    private TreeNode constructTree(String[] nodes) {
        index += 1;

        if (index >= nodes.length || nodes[index].equals("#")) {
            return null;
        }

        // preorder traversal (value-left-right)
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index]));

        root.left = constructTree(nodes);
        root.right = constructTree(nodes);

        return root;
    }

    private void preorderDFS(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return;
        }
        sb.append(root.val);

        preorderDFS(root.left, sb);
        preorderDFS(root.right, sb);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
