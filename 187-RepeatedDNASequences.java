public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sequence = s.substring(i, i + 10);
            if (map.containsKey(sequence)) {
                map.put(sequence, 1);
            } else {
                map.put(sequence, 0);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
