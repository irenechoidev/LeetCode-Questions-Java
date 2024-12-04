class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        backtrack(result, temp, graph, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[][] graph, int node) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(temp));
        }

        for (int adj : graph[node]) {
            temp.add(adj);
            backtrack(result, temp, graph, adj);
            temp.remove(temp.size() - 1);
        }
    }
}