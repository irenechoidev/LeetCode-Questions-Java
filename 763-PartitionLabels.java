class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int lastIdx = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            lastIdx = Math.max(lastIdx, map.get(s.charAt(i)));

            if (lastIdx == i) {
                result.add(lastIdx - start + 1);
                start = lastIdx + 1;
            }
        }
        return result;
    }
}