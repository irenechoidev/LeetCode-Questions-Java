class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int prod = 1;

        while (n > 0) {
            prod *= n % 10;
            sum += n % 10;

            n = n / 10;
        }

        return prod - sum;
    }
}
