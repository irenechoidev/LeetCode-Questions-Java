class Solution {
    public int countSeniors(String[] details) {
        int result = 0;
        for (String detail : details) {
            int tens = detail.charAt(11) - '0';
            int ones = detail.charAt(12) - '0';
            if (tenth * 10 + oneth > 60)
                result += 1;
        }
        return result;
    }
}
