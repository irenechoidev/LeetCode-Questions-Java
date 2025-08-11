class Solution {
    public String thousandSeparator(int n) {

        StringBuilder sb = new StringBuilder();
        int idx = 0;

        while (n > 0) {
            sb.append(n % 10);
            idx += 1;

            if (idx % 3 == 0 && n / 10 != 0) {
                sb.append(".");
            }

            n /= 10;
        }

        return sb.reverse().toString();
    }
}