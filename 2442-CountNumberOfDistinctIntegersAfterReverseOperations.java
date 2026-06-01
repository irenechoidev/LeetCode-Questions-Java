class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
            set.add(reverse(n));
        }

        return set.size();
    }

    private int reverse(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }
}