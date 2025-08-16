class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();

        backtrack(res, s.toCharArray(), 0);
        return res;
    }

    private void backtrack(List<String> res, char[] arr, int idx) {
        res.add(String.valueOf(arr));

        for (int i = idx; i < arr.length; i++) {
            if (!Character.isLetter(arr[i]))
                continue;

            char lower = Character.toUpperCase(arr[i]);
            char upper = Character.toLowerCase(arr[i]);

            arr[i] = Character.isLowerCase(arr[i]) ? lower : upper;
            backtrack(res, arr, i + 1);
            arr[i] = Character.isLowerCase(arr[i]) ? lower : upper;
        }
    }
}
