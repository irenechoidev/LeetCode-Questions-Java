class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    res[i] += code[(i + j) % n];
                }

            } else {
                int absK = Math.abs(k);
                for (int j = i - absK; j < i; j++) {
                    res[i] += code[(j + n) % n];
                }
            }
        }

        return res;
    }
}