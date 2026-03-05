class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            map.put(i, countOnes(mat[i]));
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return a.getValue() - b.getValue();
                    } else {
                        return a.getKey() - b.getKey();
                    }
                });
        pq.addAll(map.entrySet());

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            result[i] = entry.getKey();
        }

        return result;
    }

    private int countOnes(int[] row) {
        int start = 0;
        int end = row.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (row[mid] == 1) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return start;
    }
}