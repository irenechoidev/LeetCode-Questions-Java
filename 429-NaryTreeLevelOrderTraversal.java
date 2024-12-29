class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node curr = queue.poll();
                list.add(curr.val);

                for (Node child : curr.children) {
                    queue.add(child);
                }
            }
            result.add(list);
        }
        return result;
    }
}