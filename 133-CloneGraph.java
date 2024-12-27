class Solution {
    public Node cloneGraph(Node node) {
        // base case
        if (node == null) return node;
        
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        
        return map.get(node);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node))
            return map.get(node);

        // clone the current node with value and add it to the map
        Node clone = new Node(node.val);
        map.put(node, clone);

        // clone neighbors of Node n to neighbors of Node clone
        for (Node adj : node.neighbors) {
            Node cloneAdj = dfs(adj, map);
            clone.neighbors.add(cloneAdj);
        }

        return clone;
    }
}
