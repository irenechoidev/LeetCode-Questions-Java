class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // The loop runs up to nums.length - 2
        // because we need at least two numbers after the current element to form a
        // triplet.
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip Duplicates for nums[i]:
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {

                int target = 0 - nums[i];
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                        // Skip Duplicates for nums[start] and nums[end]:
                        while (start < end && nums[start] == nums[start + 1])
                            start += 1;
                        while (start < end && nums[end] == nums[end - 1])
                            end -= 1;

                        start += 1;
                        end -= 1;

                    } else if (sum < target) {
                        start += 1;
                    } else {
                        end -= 1;
                    }
                }

            }
        }
        return result;
    }
}