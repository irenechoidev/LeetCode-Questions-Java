class NumArray {
    int[] rangeSum;

    public NumArray(int[] nums) {
        rangeSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rangeSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return rangeSum[right];
        } else {
            return rangeSum[right] - rangeSum[left - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */