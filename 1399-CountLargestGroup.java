class Solution {
    public int countLargestGroup(int n) {
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int key = 0;
            int num = i;
            while (num > 0) {
                key += num % 10;
                num /= 10;
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
            maxCount = Math.max(maxCount, map.get(key));
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                count += 1;
            }
        }
        return count;
    }
}