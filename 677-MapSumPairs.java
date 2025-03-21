class MapSum {
    Map<String, Integer> map = new HashMap<>();
    TrieNode root;

    public MapSum() {
        map = new HashMap<>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);

        map.put(key, val);

        TrieNode curr = root;
        curr.score += delta;

        for (char c : key.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
            curr.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            curr = curr.children.get(c);
            if (curr == null)
                return 0;
        }
        return curr.score;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */