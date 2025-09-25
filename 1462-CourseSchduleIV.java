class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            map.putIfAbsent(p[0], new ArrayList<>());
            map.get(p[0]).add(p[1]);
        }

        Map<Integer, Set<Integer>> isReachable = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            isReachable.putIfAbsent(i, new HashSet<>());
            dfs(i, i, map, isReachable);
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            result.add(isReachable.get(q[0]).contains(q[1]));
        }

        return result;

    }

    private void dfs(
            int startNode,
            int node,
            Map<Integer, List<Integer>> map,
            Map<Integer, Set<Integer>> isReachable) {

        if (isReachable.get(startNode).contains(node))
            return;

        isReachable.get(startNode).add(node);

        List<Integer> adjacents = map.getOrDefault(startNode, new ArrayList<>());
        for (int adj : adjacents) {
            dfs(startNode, adj, map, isReachable);
        }
    }

}