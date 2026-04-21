class FreqStack {
    Map<Integer, Integer> countMap;
    Map<Integer, Stack<Integer>> stackMap;
    int max;

    public FreqStack() {
        countMap = new HashMap<>();
        stackMap = new HashMap<>();
        max = 0;
    }

    public void push(int val) {
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        int freq = countMap.get(val);
        max = Math.max(max, countMap.get(val));

        stackMap.putIfAbsent(freq, new Stack<>());
        stackMap.get(freq).add(val);
    }

    public int pop() {
        int res = stackMap.get(max).pop();

        countMap.put(res, countMap.get(res) - 1);
        if (stackMap.get(max).isEmpty()) {
            max -= 1;
        }
        return res;
    }
}