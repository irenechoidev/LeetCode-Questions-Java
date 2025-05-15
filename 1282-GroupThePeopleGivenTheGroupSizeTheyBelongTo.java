class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            map.putIfAbsent(size, new ArrayList<>());
            List<Integer> group = map.get(size);

            group.add(i);

            if (group.size() == size) {
                result.add(group);
                map.put(size, new ArrayList<>());
            }
        }
        return result;
    }
}
