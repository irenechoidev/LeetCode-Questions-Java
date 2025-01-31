class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(result, temp, candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int remain, int idx) {

        if (remain < 0)
            return;
        else if (remain == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                temp.add(candidates[i]);
                // 문제에서 The same number may be chosen from candidates an unlimited number of
                // times.
                // 그래서 backtrack할때 i+1이 아니라 i
                backtrack(result, temp, candidates, remain - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

}