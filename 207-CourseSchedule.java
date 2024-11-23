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
              // map.get(node): This would return null if the course (node) has no    
              // prerequisites. 

             // map.getOrDefault(node, new ArrayList<>()): This returns an empty list (new 
             // ArrayList<>()) if the course (node) is not present in the map. This way, 
             // when you iterate over adjacents, there are no issues because it’s safely 
             // handled as an empty list.
        
        for (int adj : adjacents) {
            if (!dfs(map, visited, adj))
                return false;
        }

        visited.put(node, 2);
        return true;
    }
}
