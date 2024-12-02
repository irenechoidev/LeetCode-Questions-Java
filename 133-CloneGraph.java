class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Node clone = dfs(node, map);
        return clone;
    }

    private Node dfs(Node node, Map<Node, Node> map) {

        // base cases
        if (node == null)
            return node;
        if (map.containsKey(node))
            return map.get(node);

        // clone the current node with value and add it to the map
        Node clone = new Node(node.val);
        map.put(node, clone);

        // clone neighbors of Node n to neighbors of Node clone
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, map));
        }

        return clone;
    }
}