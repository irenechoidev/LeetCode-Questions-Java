class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;

        for (int col = 0; col < strs[0].length(); col++) {
            for (int row = 1; row < strs.length; row++) {

                if (strs[row - 1].charAt(col) > strs[row].charAt(col)) {
                    res += 1;
                    break;
                }
            }
        }
        return res;
    }
}
