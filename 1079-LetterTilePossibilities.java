class Solution {
    public int numTilePossibilities(String tiles) {

        Set<String> set = new HashSet<>();

        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);

        backtrack(set, arr, "", new boolean[arr.length]);

        return set.size();
    }

    private void backtrack(
            Set<String> set,
            char[] arr,
            String s,
            boolean[] used) {

        if (!s.isEmpty()) {
            set.add(s);
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            backtrack(set, arr, s + arr[i], used);
            used[i] = false;
        }
    }

}
