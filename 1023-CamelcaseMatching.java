class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            res.add(isMatch(query.toCharArray(), pattern.toCharArray()));
        }
        return res;
    }

    private boolean isMatch(char[] query, char[] pattern) {
        int qPointer = 0;
        int pPointer = 0;
        while (qPointer < query.length) {
            if (pPointer < pattern.length && query[qPointer] == pattern[pPointer]) {
                pPointer += 1;
            } else if (Character.isUpperCase(query[qPointer])) {
                return false;
            }
            qPointer += 1;
        }

        return pPointer == pattern.length;
    }
}