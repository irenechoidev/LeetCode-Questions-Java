class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int n = s.length();
        int start = 0;
        while (start < n) {
            int count = 0;
            int end = start;
            while (end < n && s.charAt(start) == s.charAt(end)) {
                count += 1;
                end += 1;
            }
            if (count >= 3) {
                res.add(Arrays.asList(start, end - 1));
            }
            start = end;
        }
        return res;
    }
}