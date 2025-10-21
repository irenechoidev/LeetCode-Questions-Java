class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                int size = map.get(arr2[i]);
                for (int j = 0; j < size; j++) {
                    list.add(arr2[i]);
                }
                map.remove(arr2[i]);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getKey() - b.getKey());
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