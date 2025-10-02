class Solution {
    public int minimumOperations(TreeNode root) {
        int result = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int[] row = new int[size];
            int idx = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                row[idx] = curr.val;
                idx += 1;

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < row.length; i++) {
                map.put(row[i], i);
            }

            int[] sorted = row.clone();
            Arrays.sort(sorted);

            for (int i = 0; i < row.length; i++) {
                if (sorted[i] != row[i]) {

                    int actualIdx = map.get(sorted[i]);

                    int temp = row[i];
                    row[i] = sorted[i];
                    row[actualIdx] = temp;

                    map.put(row[i], i);
                    map.put(row[actualIdx], actualIdx);

                    result += 1;
                }
            }

        }

        return result;
    }
}