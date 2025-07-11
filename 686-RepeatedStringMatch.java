class Solution {
    public int repeatedStringMatch(String a, String b) {
        int res = 0;
        StringBuilder sb = new StringBuilder();

        while (sb.length() < b.length()) {
            sb.append(a);
            res += 1;
        }

        if (sb.toString().contains(b))
            return res;
        else {
            sb.append(a);
            res += 1;
        }

        return sb.toString().contains(b) ? res : -1;
    }
}