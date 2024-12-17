class Solution {
    public String[] findWords(String[] words) {

        List<String> rows = new ArrayList<>();
        rows.add("qwertyuiop");
        rows.add("asdfghjkl");
        rows.add("zxcvbnm");

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i);
            for (char c : row.toCharArray()) {
                map.put(c, i);
                map.put(Character.toUpperCase(c), i);
            }
        }

        List<String> list = new ArrayList<>();
        for (String word : words) {
            int defaultNum = map.get(word.charAt(0));
            boolean isComplete = true;
            for (int i = 1; i < word.length(); i++) {
                int rowNum = map.get(word.charAt(i));
                if (defaultNum != rowNum) {
                    isComplete = false;
                    break;
                }
            }
            if (isComplete) {
                list.add(word);
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
