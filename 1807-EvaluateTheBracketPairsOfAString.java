class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {

            StringBuilder temp = new StringBuilder();
            if (s.charAt(idx) == '(') {
                idx += 1;
                while (s.charAt(idx) != ')') {
                    temp.append(s.charAt(idx));
                    idx += 1;
                }
                idx += 1;
                sb.append(map.getOrDefault(temp.toString(), "?"));
            } else {
                sb.append(s.charAt(idx));
                idx += 1;
            }
        }

        return sb.toString();
    }
}