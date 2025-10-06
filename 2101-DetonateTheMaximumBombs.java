class Solution {
    public int maximumDetonation(int[][] bombs) {
        int result = 0;

        for (int i = 0; i < bombs.length; i++) {
            Set<Integer> visited = new HashSet<>();
            result = Math.max(result, dfs(i, visited, bombs));
        }

        return result;
    }

    private int dfs(
            int node,
            Set<Integer> visited,
            int[][] bombs) {

        int count = 1;
        visited.add(node);

        for (int i = 0; i < bombs.length; i++) {
            if (!visited.contains(i) && isRange(bombs[node], bombs[i])) {
                count += dfs(i, visited, bombs);
            }
        }

        return count;
    }

    private boolean isRange(int[] a, int[] b) {
        long x = a[0] - b[0];
        long y = a[1] - b[1];
        long r = a[2];
        return x * x + y * y <= r * r;
    }
}