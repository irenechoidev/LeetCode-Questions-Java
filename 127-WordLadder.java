class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        char[] alphabets = getAlphabet();
        Set<String> set = toSet(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // beginWord = "hit",
        // "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
        // 그래서 level 1에서 시작.
        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                char[] currWord = queue.poll().toCharArray();
                for (int j = 0; j < currWord.length; j++) {
                    char temp = currWord[j];
                    for (char c : alphabets) {
                        currWord[j] = c;
                        String newWord = String.valueOf(currWord);
                        if (endWord.equals(newWord))
                            return level + 1;

                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            queue.add(newWord);
                        }
                    }
                    currWord[j] = temp;
                }
            }
            level += 1;
        }

        // 못 찾았으니까 원래는 처음에 initialize 했었던 transformation 값을 return 해야 하지만,
        // 문제에서 그럴 경우 0을 return 하라고 했으니까.
        return 0;
    }

    private Set<String> toSet(List<String> strs) {
        Set<String> set = new HashSet<>();
        for (String s : strs) {
            set.add(s);
        }
        return set;
    }

    private char[] getAlphabet() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.toCharArray();
    }
}
