class Solution {
    public int[] frequencySort(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue()));
        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            int size = pq.peek().getValue();
            int n = pq.poll().getKey();
            for (int i = 0; i < size; i++) {
                list.add(n);
            }
        }

        return listToArr(list);
    }

    private int[] listToArr(List<Integer> list) {
        int[] result = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            result[idx] = i;
            idx += 1;
        }
        return result;
    }
}