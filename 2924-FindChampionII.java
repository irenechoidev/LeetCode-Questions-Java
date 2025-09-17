class Solution {
    public int findChampion(int n, int[][] edges) {
        int champ = -1;

        int[] indegree = new int[n];

        for (int[] e : edges) {
            indegree[e[1]]++;
        }

        int champCount = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champ = i;
                champCount += 1;
            }
        }
        return (champCount > 1) ? -1 : champ;
    }
}