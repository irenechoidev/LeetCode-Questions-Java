class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, colors, i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int[][] graph, int[] colors, int node) {
        if (colors[node] != 0) {
            return colors[node] == 1;
        }

        colors[node] = 2;

        for (int adj : graph[node]) {
            if (!dfs(graph, colors, adj))
                return false;
        }

        colors[node] = 1;

        return true;
    }
}