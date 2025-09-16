class Solution {
    public int minReorder(int n, int[][] connections) {
        int result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] c : connections) {
            map.putIfAbsent(c[0], new ArrayList<>());
            map.putIfAbsent(c[1], new ArrayList<>());
            map.get(c[0]).add(c[1]);
            map.get(c[1]).add(-c[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                List<Integer> adjacents = map.getOrDefault(curr, new ArrayList<>());

                for (int adj : adjacents) {
                    int absVal = Math.abs(adj);

                    if (!visited.contains(absVal)) {
                        result += (adj > 0) ? 1 : 0;

                        visited.add(absVal);
                        queue.add(absVal);
                    }
                }
            }
        }
        return result;
    }
}
