class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {

            // If the count of a number num in the map is 0,
            // it means all instances of this number have already been used in previous
            // groups
            if (map.get(num) == 0) {
                continue;
            }

            // The condition ensures that
            // each consecutive number required for the group exists in the map
            for (int i = 0; i < groupSize; i++) {
                if (map.getOrDefault(num + i, 0) == 0)
                    return false;
                map.put(num + i, map.getOrDefault(num + i, 0) - 1);
            }
        }
        return true;
    }
}
