class WordDictionary {
    TrieNode root;
    String letters = "abcdefghijklmnopqrstuvwxyz";

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            Map<Character, TrieNode> map = curr.children;
            if (!map.containsKey(c)) {
                map.put(c, new TrieNode());
            }
            curr = map.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return searchWithIndex(curr, word.toCharArray(), 0);

    }

    private boolean searchWithIndex(
            TrieNode curr,
            char[] word,
            int idx) {
        if (curr == null)
            return false;

        for (int i = idx; i < word.length; i++) {
            char c = word[i];
            Map<Character, TrieNode> map = curr.children;
            if (c == '.') {
                for (char letter : letters.toCharArray()) {
                    if (searchWithIndex(map.get(letter), word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!map.containsKey(c)) {
                    return false;
                }
            }
            curr = map.get(c);
        }
        return curr.isWord;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }
}