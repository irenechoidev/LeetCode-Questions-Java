class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return construct(0, nums.length - 1, nums);
    }

    private TreeNode construct(int start, int end, int[] nums) {
        if (start > end)
            return null;

        int maxIdx = findMaxIdx(start, end, nums);

        TreeNode root = new TreeNode(nums[maxIdx]);

        root.left = construct(start, maxIdx - 1, nums);
        root.right = construct(maxIdx + 1, end, nums);

        return root;
    }

    private int findMaxIdx(int start, int end, int[] nums) {
        int idx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
