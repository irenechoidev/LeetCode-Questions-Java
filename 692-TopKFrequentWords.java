class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey())
                        : b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        while (k > 0) {
            Map.Entry<String, Integer> entry = pq.poll();
            res.add(entry.getKey());
            k -= 1;
        }

        return res;
    }
}