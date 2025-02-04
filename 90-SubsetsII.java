class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, temp, 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int node) {
        result.add(new ArrayList<>(temp));

        for (int i = node; i < nums.length; i++) {
            if (i > node && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            backtrack(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}