class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = charToInt(s.charAt(i));
            int next = charToInt(s.charAt(i + 1));
            if (curr < next) {
                res -= curr;
            } else {
                res += curr;
            }
        }
        res += charToInt(s.charAt(s.length() - 1));
        return res;
    }

    private int charToInt(char c) {
        int res = 0;
        if (c == 'I')
            res = 1;
        else if (c == 'V')
            res = 5;
        else if (c == 'X')
            res = 10;
        else if (c == 'L')
            res = 50;
        else if (c == 'C')
            res = 100;
        else if (c == 'D')
            res = 500;
        else {
            res = 1000;
        }
        return res;
    }
}
