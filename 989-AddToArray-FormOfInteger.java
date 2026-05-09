class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();

        int n = num.length;
        int curr = k;

        int idx = n - 1;
        while (idx >= 0 || curr > 0) {
            if (idx >= 0)
                curr += num[idx];
            idx -= 1;
            res.add(curr % 10);
            curr /= 10;
        }

        Collections.reverse(res);
        return res;
    }
}