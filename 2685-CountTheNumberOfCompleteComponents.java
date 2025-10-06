class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int result = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.contains(i))
                continue;

            List<Integer> list = new ArrayList<>();
            dfs(i, map, visited, list);
            System.out.println(list);

            if (isComplete(map, list))
                result += 1;
        }

        return result;
    }

    private void dfs(
            int node,
            Map<Integer, List<Integer>> map,
            Set<Integer> visited,
            List<Integer> list) {
        if (visited.contains(node))
            return;

        list.add(node);
        visited.add(node);

        List<Integer> adjacents = map.getOrDefault(node, new ArrayList<>());
        for (int adj : adjacents) {
            dfs(adj, map, visited, list);
        }

    }

    private boolean isComplete(
            Map<Integer, List<Integer>> map,
            List<Integer> list) {
        for (int node : list) {
            int numNeighbours = map.getOrDefault(node, new ArrayList<>()).size();
            if (numNeighbours != list.size() - 1)
                return false;
        }
        return true;
    }
}
