class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int min = log[1];
            map.putIfAbsent(id, new HashSet<>());
            map.get(id).add(min);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int activeMin = entry.getValue().size();
            res[activeMin - 1] += 1;
        }

        return res;
    }
}
