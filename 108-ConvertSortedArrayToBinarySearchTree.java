class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(0, nums.length - 1, nums);
    }

    private TreeNode construct(int start, int end, int[] nums) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(start, mid - 1, nums);
        root.right = construct(mid + 1, end, nums);

        return root;
    }
}