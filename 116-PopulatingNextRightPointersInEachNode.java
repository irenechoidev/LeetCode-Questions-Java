class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            int count = n;
            for (int i = 0; i < n; i++) {
                Node curr = queue.poll();
                count -= 1;

                if (count > 0) {
                    curr.next = queue.peek();
                }

                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
        }
        return root;
    }
}