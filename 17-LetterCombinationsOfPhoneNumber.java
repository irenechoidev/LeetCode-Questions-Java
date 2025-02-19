class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;

        String[] map = { "0", "1", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz" };

        backtrack(result, map, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(
            List<String> result,
            String[] map,
            String digits,
            StringBuilder sb,
            int idx) {

        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);

            backtrack(result, map, digits, sb, idx + 1);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
