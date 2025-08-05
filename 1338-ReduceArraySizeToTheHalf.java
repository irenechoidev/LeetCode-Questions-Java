class Solution {
    public int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int freq : map.values()) {
            maxHeap.add(freq);
        }

        int remaining = arr.length;
        int res = 0;

        while (remaining > arr.length / 2) {
            remaining -= maxHeap.poll();
            res += 1;
        }

        return res;
    }
}