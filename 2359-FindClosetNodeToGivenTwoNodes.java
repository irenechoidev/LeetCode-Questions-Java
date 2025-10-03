class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        bfs(map1, edges, node1);
        bfs(map2, edges, node2);

        int result = -1;
        int maxDist = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            int dist1 = map1.getOrDefault(i, -1);
            int dist2 = map2.getOrDefault(i, -1);

            boolean isReachable = dist1 != -1 && dist2 != -1;

            int dist = Math.max(dist1, dist2);

            if (isReachable && dist < maxDist) {
                maxDist = dist;
                result = i;
            }
        }

        return result;
    }

    private void bfs(
            Map<Integer, Integer> map,
            int[] edges,
            int node) {

        Queue<Integer> queue = new LinkedList<>();
        int dist = 0;
        queue.add(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (map.containsKey(curr) || curr == -1)
                continue;

            map.put(curr, dist);
            queue.add(edges[curr]);
            dist += 1;
        }
    }
}