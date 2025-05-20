/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, 0, inorder.length - 1, map);
    }

    private TreeNode helper(
            int[] preorder,
            int preStart,
            int inStart,
            int inEnd,
            Map<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = map.get(root.val);
        int leftSize = inIndex - inStart;

        root.left = helper(preorder, preStart + 1, inStart, inIndex - 1, map);
        root.right = helper(preorder, preStart + leftSize + 1, inIndex + 1, inEnd, map);

        return root;
    }
}
