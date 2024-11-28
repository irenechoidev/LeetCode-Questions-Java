class Solution {
    // to make Tree
    int index = -1;

    public boolean isValidSerialization(String preorder) {
        // process 'String preorder' to 'String[] nodes' for making Tree and
        // process 'nodes' to 'String preorderWithoutCommas' for comparison
        String[] nodes = preorder.split(",");
        String preorderWithoutCommas = String.join("", nodes);

        // make Tree from the 'String[] nodes' incrementing index of nodes
        TreeNode root = constructTree(nodes);

        // make String from the Tree iterating preorderDFS
        StringBuilder sb = new StringBuilder();
        String preorderString = preorderDFS(root, sb);

        return preorderString.equals(preorderWithoutCommas);

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

    private String preorderDFS(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            return sb.toString();
        }
        sb.append(root.val);

        preorderDFS(root.left, sb);
        preorderDFS(root.right, sb);

        return sb.toString();
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
