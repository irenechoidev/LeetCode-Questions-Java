class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);

            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        result.addAll(map.values());
        return result;
    }
}