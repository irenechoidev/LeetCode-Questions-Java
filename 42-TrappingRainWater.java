class Solution {
    public int trap(int[] height) {
        // if (height.length <= 2) return 0;

        int maxIdx = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxVal) {
                maxVal = height[i];
                maxIdx = i;
            }
        }

        int water = 0;

        int leftMax = height[0];
        for (int i = 1; i < maxIdx; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            } else {
                water += leftMax - height[i];

            }
        }

        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxIdx; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            } else {
                water += rightMax - height[i];
            }
        }

        return water;
    }
}
