class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    private void backtrack(
            int n,
            int k,
            List<List<Integer>> res,
            List<Integer> temp,
            int idx) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i <= n; i++) {
            temp.add(i);
            backtrack(n, k, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
