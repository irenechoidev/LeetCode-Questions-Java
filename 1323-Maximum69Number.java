class Solution {
    public int maximum69Number(int num) {
        num = reverse(num);

        boolean modified = false;
        int res = 0;
        while (num != 0) {
            int digit = num % 10;
            if (digit == 6 && !modified) {
                res = res * 10 + 9;
                modified = true;
            } else {
                res = res * 10 + digit;
            }
            num /= 10;
        }
        return res;
    }

    private int reverse(int num) {
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}