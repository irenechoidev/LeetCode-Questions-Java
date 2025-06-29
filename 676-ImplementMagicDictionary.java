class MagicDictionary {
    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            insert(s);
        }
    }

    private void insert(String s) {
        TrieNode curr = root;

        for (char c : s.toCharArray()) {
            Map<Character, TrieNode> map = curr.children;
            if (!map.containsKey(c)) {
                map.put(c, new TrieNode());
            }
            curr = map.get(c);
        }

        curr.isWord = true;
    }

    public boolean search(String searchWord) {
        return dfs(root, searchWord, 0, true);
    }

    private boolean dfs(TrieNode root, String word, int idx, boolean canModify) {
        TrieNode curr = root;

        if (idx == word.length()) {
            return curr.isWord && !canModify;
        }

        char c = word.charAt(idx);

        for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
            char key = entry.getKey();
            TrieNode next = entry.getValue();

            if (key == c && dfs(next, word, idx + 1, canModify)) {
                return true;
            }

            if (key != c && canModify && dfs(next, word, idx + 1, false)) {
                return true;
            }
        }

        return false;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
