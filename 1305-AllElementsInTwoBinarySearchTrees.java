class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> res = new ArrayList<>();

        List<Integer> left = new ArrayList<>();
        left = inorder(root1, left);

        List<Integer> right = new ArrayList<>();
        right = inorder(root2, right);

        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                res.add(left.get(i));
                i += 1;
            } else {
                res.add(right.get(j));
                j += 1;
            }
        }

        while (i < left.size()) {
            res.add(left.get(i));
            i += 1;
        }

        while (j < right.size()) {
            res.add(right.get(j));
            j += 1;
        }

        return res;
    }

    private List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return list;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

        return list;
    }
}
