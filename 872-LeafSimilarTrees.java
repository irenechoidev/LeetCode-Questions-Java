class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1 = collectLeafValues(root1, list1);
        list2 = collectLeafValues(root2, list2);

        return list1.equals(list2);

    }

    private List<Integer> collectLeafValues(TreeNode root, List<Integer> list) {
        if (root == null)
            return list;

        if (isLeaf(root)) {
            list.add(root.val);
        }
        collectLeafValues(root.left, list);
        collectLeafValues(root.right, list);

        return list;
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}