public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {

                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(nums.get(i).get(j));

                count += 1;
            }
        }

        int[] result = new int[count];

        int idx = 0;
        int currLevel = 0;

        while (map.containsKey(currLevel)) {
            for (int num : map.get(currLevel)) {
                result[idx] = num;
                idx += 1;
            }
            currLevel += 1;

        }
        return result;
    }
}
