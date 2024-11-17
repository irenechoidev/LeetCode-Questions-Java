public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[0], new ArrayList<>());
            map.get(prerequisite[0]).add(prerequisite[1]);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        boolean reuslt = true;
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, visited, i))
                return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Map<Integer, Integer> visited, int node) {
        if (visited.getOrDefault(node, 0) == 2)
            return true;
        if (visited.getOrDefault(node, 0) == 1)
            return false;

        visited.put(node, 1);

        List<Integer> adjacents = map.getOrDefault(node, new ArrayList<>());
        for (int adj : adjacents) {
            if (!dfs(map, visited, adj))
                return false;
        }

        visited.put(node, 2);
        return true;
    }
}
