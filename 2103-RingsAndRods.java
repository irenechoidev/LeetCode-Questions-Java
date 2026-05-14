class Solution {
    public int countPoints(String rings) {
        int res = 0;

        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            int idx = (int) (rings.charAt(i + 1) - '0');
            map.putIfAbsent(idx, new HashSet<>());
            map.get(idx).add(rings.charAt(i));
        }

        for (Map.Entry<Integer, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().size() == 3)
                res += 1;
        }

        return res;
    }
}