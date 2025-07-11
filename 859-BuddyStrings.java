class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        Set<Character> set = new HashSet<>();
        if (s.equals(goal)) {
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            return set.size() < goal.length();
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i))
                list.add(i);
        }

        if (list.size() == 2 &&
                s.charAt(list.get(0)) == goal.charAt(list.get(1)) &&
                s.charAt(list.get(1)) == goal.charAt(list.get(0))) {
            return true;
        }

        return false;
    }
}
