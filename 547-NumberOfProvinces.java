class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> set = new HashSet<>();
        
        int result = 0;
        int n = isConnected.length;

        for (int i=0;i<n;i++) {
            if (!set.contains(i)) {
                result += 1;
                dfs(isConnected, set, i);
            }
        }
        
        return result;
    }

    private void dfs(int[][] isConnected, Set<Integer> set, int node) {
        if (set.contains(node)) return;
        set.add(node);

        int[] row = isConnected[node];
        for (int i=0;i<row.length;i++) {
            if (row[i] == 1) dfs(isConnected, set, i);
        }
    }
}

// dfs(isConnected, set, 5) row=[0,0,0,1,1]
//                                     ^
// dfs(isConnected, set, 4) row=[0,0,1,1,1]
//                                       ^
// dfs(isConnected, set, 3) row=[0,1,1,1,0]
//                                     ^
// dfs(isConnected, set, 2) row=[1,1,1,0,0]
//                                   ^
// dfs(isConnected, set, 1) row=[1,1,0,0,0]
//                                 ^
// set = {1, 2, 3, 4, 5}
// result = 1