class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : nums) {
            if (map.get(n) == 1
                    && !map.containsKey(n - 1)
                    && !map.containsKey(n + 1)) {

                res.add(n);
            }
        }

        return res;
    }
}