class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        return listToArr(list);
    }

    private int[] listToArr(List<Integer> list) {
        int[] res = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            res[idx] = i;
            idx += 1;
        }
        return res;
    }
}