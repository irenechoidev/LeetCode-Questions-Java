class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i : nums) {

            // Calculate Index:
            int idx = Math.abs(i) - 1;

            // Check if the Index is Marked:
            if (nums[idx] < 0) {
                result.add(idx + 1);
            }

            // Mark the Index as Visited:
            nums[idx] *= -1;
        }

        return result;
    }
}