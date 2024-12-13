class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> list = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int indexSum = map.get(list2[j]) + j;

                if (indexSum < minSum) {
                    list.clear();
                    list.add(list2[j]);
                    minSum = indexSum;
                } else if (minSum == indexSum) {
                    list.add(list2[j]);
                }
            }
        }

        String[] result = new String[list.size()];
        int index = 0;
        for (String s : list) {
            result[index] = s;
            index += 1;
        }
        return result;
    }
}