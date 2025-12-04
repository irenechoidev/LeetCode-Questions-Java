class KthLargest {
    PriorityQueue<Integer> pq;
    int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;

        for (int num : nums) {
            pq.add(num);
        }

        while (pq.size() > size) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size() > size) {
            pq.poll();
        }

        return pq.peek();
    }
}