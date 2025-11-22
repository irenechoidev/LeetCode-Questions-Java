class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childIdx = 0;
        int cookieIdx = 0;
        int res = 0;
        while (childIdx < g.length && cookieIdx < s.length) {
            if (g[childIdx] <= s[cookieIdx]) {
                res += 1;
                childIdx += 1;
                cookieIdx += 1;
            } else {
                cookieIdx += 1;
            }
        }
        return res;
    }
}
