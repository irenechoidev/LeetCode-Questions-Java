class Solution {
    public int balancedStringSplit(String s) {
        int res = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R')
                count -= 1;
            else {
                count += 1;
            }
            if (count == 0)
                res += 1;
        }
        return res;
    }
}