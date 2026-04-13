class Solution {
    public long maxProduct(int[] nums) {
        long largest = Integer.MIN_VALUE;
        long secondLargest = Integer.MIN_VALUE;

        for (int n : nums) {
            long absN = Math.abs(n);
            if (largest <= absN) {
                secondLargest = largest;
                largest = absN;
            } else if (secondLargest <= absN) {
                secondLargest = absN;
            }
        }

        return largest * secondLargest * 100000;
    }
}