class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int time = 0;

        Map<Integer, List<Integer>> map = buildGraph(manager);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(headID, informTime[headID]));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                List<Integer> subs = map.getOrDefault(curr.val, new ArrayList<>());
                for (int sub : subs) {
                    queue.add(new Node(sub, curr.time + informTime[sub]));
                }

                time = Math.max(time, curr.time);
            }
        }

        return time;
    }

    private Map<Integer, List<Integer>> buildGraph(int[] manager) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return map;
    }

    class Node {
        int val;
        int time;

        public Node(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }
}