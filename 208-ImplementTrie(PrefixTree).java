class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

        for (char c : word.toCharArray()) {
            Map<Character, TrieNode> map = curr.children;
            if (!map.containsKey(c)) {
                return false;
            }
            curr = map.get(c);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            Map<Character, TrieNode> map = curr.children;
            if (!map.containsKey(c)) {
                return false;
            }
            curr = map.get(c);
        }
        return true;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
}
