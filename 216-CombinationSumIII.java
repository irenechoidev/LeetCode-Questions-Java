class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, res, new ArrayList<>(), 1);
        return res;
    }

    private void backtrack(
            int k,
            int remain,
            List<List<Integer>> res,
            List<Integer> temp,
            int idx) {
        if (remain < 0)
            return;
        else if (remain == 0 && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            temp.add(i);
            backtrack(k, remain - i, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
