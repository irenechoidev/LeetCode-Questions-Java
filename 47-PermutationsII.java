class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] visited) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));

        } else {

            for (int i = 0; i < nums.length; i++) {

                if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                    continue;

                temp.add(nums[i]);
                visited[i] = true;
                backtrack(nums, result, temp, visited);

                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}