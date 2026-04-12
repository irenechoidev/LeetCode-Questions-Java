class Solution {
    public int maxProduct(int[] nums) {
        int biggest = 0;
        int secondbiggest = 0;
        for (int num : nums) {
            if (num > biggest) {
                secondbiggest = biggest;
                biggest = num;
            } else if (num > secondbiggest) {
                secondbiggest = num;
            }
        }
        return (biggest - 1) * (secondbiggest - 1);
    }
}