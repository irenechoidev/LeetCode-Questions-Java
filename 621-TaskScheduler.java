class Solution {
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }

            for (int count : list) {
                count -= 1;
                if (count > 0) {
                    pq.add(count);
                }
            }

            boolean canBeIdle = !pq.isEmpty();
            if (canBeIdle) {
                result += n + 1;
            } else {
                result += list.size();
            }
        }
        return result;
    }
}
