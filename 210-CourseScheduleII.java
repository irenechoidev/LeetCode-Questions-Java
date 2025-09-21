class Solution {
    List<Integer> list = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            map.putIfAbsent(p[1], new ArrayList<>());
            map.get(p[1]).add(p[0]);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, visited, i)) {
                return new int[0];
            }
        }

        return listToArr(list);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Map<Integer, Integer> visited, int node) {
        if (visited.getOrDefault(node, 0) == 1)
            return false;
        if (visited.getOrDefault(node, 0) == 2)
            return true;

        visited.put(node, 1);

        List<Integer> adjacents = map.getOrDefault(node, new ArrayList<>());
        for (int adj : adjacents) {
            if (!dfs(map, visited, adj)) {
                return false;
            }
        }

        visited.put(node, 2);
        list.add(0, node);
        return true;
    }

    private int[] listToArr(List<Integer> list) {
        int[] result = new int[list.size()];
        int idx = 0;
        for (int n : list) {
            result[idx] = n;
            idx += 1;
        }
        return result;
    }
}
