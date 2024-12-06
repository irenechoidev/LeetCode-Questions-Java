class Solution {
    public int findJudge(int n, int[][] trust) {
        // Degree-Based HashMap(Not adjacency map)

        // net trust score
        // To identify the town judge, a person must:
        // trusted by everyone else
        // trust no one

        // (map.get(i) == n-1)
        // 그러니까 trust score 이 인구 수보다 하나 작은 사람이 town judge:

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : trust) {
            // t[0]: who give trust (trust score will be decreased);
            // t[1]: who take trust (trust score will be increased);
            map.put(t[1], map.getOrDefault(t[1], 0) + 1);
            map.put(t[0], map.getOrDefault(t[0], 0) - 1);
        }

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i) && map.get(i) == n - 1) {
                return i;
            }
        }
        return -1;

    }
}
