class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int numRepeats = n / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < numRepeats; j++) {
                    sb.append(s.substring(0, i));
                }
                if (sb.toString().contains(s))
                    return true;
            }
        }
        return false;
    }
}