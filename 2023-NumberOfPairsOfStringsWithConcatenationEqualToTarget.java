class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int count = 0;
        for (int i = 1; i < target.length(); i++) {
            String prefix = target.substring(0, i);
            String suffix = target.substring(i);
            if (map.containsKey(prefix) && map.containsKey(suffix)) {
                if (prefix.equals(suffix)) {
                    int n = map.get(prefix);
                    count += n * (n - 1);
                } else {
                    count += map.get(prefix) * map.get(suffix);
                }

            }
        }
        return count;
    }
}