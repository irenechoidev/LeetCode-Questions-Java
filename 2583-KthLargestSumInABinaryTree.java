class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            pq.add(sum);
        }

        if (pq.size() < k)
            return -1;

        while (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
