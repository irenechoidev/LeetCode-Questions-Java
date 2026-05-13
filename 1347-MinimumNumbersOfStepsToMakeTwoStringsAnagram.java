public class 1347-MinimumNumbersOfStepsToMakeTwoStringsAnagram{class Solution {
        public int minSteps(String s, String t) {
            int res = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (char c: s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0)+1);
            }
    
            for (char c: t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0)-1);
            }
    
            for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                res += Math.max(0, entry.getValue());
            }
    
            return res;
        }
    }