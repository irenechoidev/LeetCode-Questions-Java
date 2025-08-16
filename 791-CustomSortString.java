class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : order.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                sb.append(c);
                map.put(c, map.get(c) - 1);
            }
        }

        for (char c : map.keySet()) {
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count -= 1;
            }
        }

        return sb.toString();
    }
}