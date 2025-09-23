class Solution {
    public boolean isBipartite(int[][] graph) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            for (int n : graph[i]) {
                map.get(i).add(n);
            }
        }

        for (int i = 0; i < graph.length; i++) {
            if (!visited.containsKey(i) && !dfs(map, visited, i, 1))
                return false;
        }

        return true;
    }

    private boolean dfs(
            Map<Integer, List<Integer>> map,
            Map<Integer, Integer> visited,
            int node,
            int color) {
        if (visited.containsKey(node)) {
            return visited.get(node) == color;
        }

        visited.put(node, color);

        List<Integer> adjacents = map.getOrDefault(node, new ArrayList<>());
        for (int adj : adjacents) {
            if (!dfs(map, visited, adj, -color))
                return false;
        }

        return true;

    }
}
