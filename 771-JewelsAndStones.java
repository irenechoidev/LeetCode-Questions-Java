class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }
        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                res += 1;
            }
        }
        return res;
    }
}