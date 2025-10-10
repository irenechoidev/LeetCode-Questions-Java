class Solution {
    public int maxDifference(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int curr = entry.getValue();
            if (curr % 2 != 0)
                maxOdd = Math.max(maxOdd, curr);
            else if (curr % 2 == 0)
                minEven = Math.min(minEven, curr);
        }

        return maxOdd - minEven;
    }
}