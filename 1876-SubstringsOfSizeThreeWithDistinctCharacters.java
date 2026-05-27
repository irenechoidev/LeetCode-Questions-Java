class Solution {
    public int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            String temp = s.substring(i, i + 3);
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < temp.length(); j++) {
                set.add(temp.charAt(j));
            }
            if (set.size() == 3)
                res += 1;
        }
        return res;
    }
}