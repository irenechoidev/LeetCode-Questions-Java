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
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if (curr == null)
                    flag = 1;
                else {
                    if (flag == 1)
                        return false;
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        return true;
    }
}