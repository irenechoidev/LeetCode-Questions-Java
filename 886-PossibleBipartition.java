class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            int g1 = dislike[0];
            int g2 = dislike[1];
            map.putIfAbsent(g1, new ArrayList<>());
            map.putIfAbsent(g2, new ArrayList<>());
            map.get(g1).add(g2);
            map.get(g2).add(g1);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!visited.containsKey(i) && !dfs(map, visited, i, 1)) {
                return false;
            }
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
        List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());
        for (int adj : neighbors) {
            if (!dfs(map, visited, adj, -color)) {
                return false;
            }
        }

        return true;
    }
}