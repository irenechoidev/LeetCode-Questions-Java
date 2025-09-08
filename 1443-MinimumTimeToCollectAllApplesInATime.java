class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        Map<Integer, List<Integer>> map = createMap(edges);
        Set<Integer> visited = new HashSet<>();

        return dfs(map, visited, 0, hasApple);
    }

    private int dfs(
            Map<Integer, List<Integer>> map,
            Set<Integer> visited,
            int node,
            List<Boolean> hasApple) {

        visited.add(node);
        int childrenCost = 0;

        List<Integer> adjacents = map.getOrDefault(node, new ArrayList<>());

        for (int adj : adjacents) {
            if (visited.contains(adj))
                continue;
            childrenCost += dfs(map, visited, adj, hasApple);
        }

        if (childrenCost == 0 && !hasApple.get(node))
            return 0;

        return node == 0 ? childrenCost : childrenCost + 2;
    }

    private Map<Integer, List<Integer>> createMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[1]).add(e[0]);

        }
        return map;
    }
}
