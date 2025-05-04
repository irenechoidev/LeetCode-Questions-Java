class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Map<Integer, TreeNode> map = new HashMap<>();
        int n = traversal.length();
        int idx = 0;

        while (idx < n) {
            int level = 0;
            int val = 0;

            while (idx < n && traversal.charAt(idx) == '-') {
                level += 1;
                idx += 1;
            }

            while (idx < n && Character.isDigit(traversal.charAt(idx))) {
                val = val * 10 + (int) (traversal.charAt(idx) - '0');
                idx += 1;
            }

            TreeNode node = new TreeNode(val);
            map.put(level, node);

            if (level > 0) {
                TreeNode parent = map.get(level - 1);
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
        }
        return map.get(0);
    }
}