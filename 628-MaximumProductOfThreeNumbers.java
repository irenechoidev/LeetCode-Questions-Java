public class Solution {
    public int maximumProduct(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int i : nums) {
            if (smallest >= i) {
                secondSmallest = smallest;
                smallest = i;
            } else if (secondSmallest >= i) {
                secondSmallest = i;
            }

            if (largest <= i) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = i;
            } else if (secondLargest <= i) {
                thirdLargest = secondLargest;
                secondLargest = i;
            } else if (thirdLargest <= i) {
                thirdLargest = i;
            }
        }

        return Math.max(smallest * secondSmallest * largest,
                thirdLargest * secondLargest * largest);
    }
}
