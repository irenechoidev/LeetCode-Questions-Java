class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }

            while (!stack.isEmpty()) {
                char top = stack.peek();
                if (top > c && map.get(top) > 1) {
                    map.put(top, map.get(top) - 1);
                    seen.remove(top);
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(c);
            seen.add(c);
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}