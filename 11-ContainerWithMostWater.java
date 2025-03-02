class Solution {
    public int maxArea(int[] height) {
        int water = 0;
        int maxWater = Integer.MIN_VALUE;

        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int h = Math.min(height[start], height[end]);
            water = (end - start) * h;
            if (height[start] < height[end]) {
                start += 1;
            } else {
                end -= 1;
            }

            maxWater = Math.max(water, maxWater);
        }
        return maxWater;
    }
}