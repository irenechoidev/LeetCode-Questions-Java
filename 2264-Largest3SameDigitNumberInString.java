class Solution {
    public String largestGoodInteger(String num) {
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < num.length() - 1; i++) {

            if (num.charAt(i - 1) == num.charAt(i) &&
                    num.charAt(i) == num.charAt(i + 1)) {

                res = Math.max(res, num.charAt(i) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(res);
        }

        return res == Integer.MIN_VALUE ? "" : sb.toString();
    }
}