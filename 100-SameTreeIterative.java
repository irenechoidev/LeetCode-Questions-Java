class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode qNode = qStack.pop();
            TreeNode pNode = pStack.pop();

            if (pNode.val != qNode.val)
                return false;
            else if (pNode.left == null && qNode.left != null)
                return false;
            else if (pNode.left != null && qNode.left == null)
                return false;
            else if (pNode.right == null && qNode.right != null)
                return false;
            else if (pNode.right != null && qNode.right == null)
                return false;

            if (pNode.left != null)
                pStack.push(pNode.left);
            if (qNode.left != null)
                qStack.push(qNode.left);

            if (pNode.right != null)
                pStack.push(pNode.right);
            if (qNode.right != null)
                qStack.push(qNode.right);
        }
        return true;
    }
}
