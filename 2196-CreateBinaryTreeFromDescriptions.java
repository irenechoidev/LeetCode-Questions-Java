class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int[] d : descriptions) {
            int val = d[0];
            int childVal = d[1];
            boolean isLeft = d[2] == 1;

            TreeNode node = map.getOrDefault(val, new TreeNode(val));
            TreeNode childNode = map.getOrDefault(childVal, new TreeNode(childVal));

            if (isLeft) {
                node.left = childNode;
            } else {
                node.right = childNode;
            }

            map.put(val, node);
            map.put(childVal, childNode);
            set.add(childVal);
        }

        for (int[] d : descriptions) {
            if (!set.contains(d[0])) {
                return map.get(d[0]);
            }
        }

        return null;
    }
}
