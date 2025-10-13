class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (curr.left != null && !set.contains(curr.left))
                stack.push(curr.left);
            else if (curr.right != null && !set.contains(curr.right))
                stack.push(curr.right);
            else {
                stack.pop();
                set.add(curr);
                result.add(curr.val);
            }
        }

        return result;
    }
}