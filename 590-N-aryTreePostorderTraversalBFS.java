class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(0, curr.val);

            for (Node n : curr.children) {
                stack.push(n);
            }
        }
        return result;
    }
}
