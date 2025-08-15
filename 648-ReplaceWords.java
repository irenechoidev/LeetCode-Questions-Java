class Solution {
    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();

        for (String s : dictionary) {
            insert(s);
        }

        String[] arr = sentence.split(" ");
        for (String s : arr) {
            sb.append(search(s) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

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

    private String search(String s) {
        TrieNode curr = root;

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            Map<Character, TrieNode> map = curr.children;
            if (!map.containsKey(c) || curr.isWord) {
                break;
            }
            curr = map.get(c);
            sb.append(c);
        }

        return curr.isWord ? sb.toString() : s;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }
}
