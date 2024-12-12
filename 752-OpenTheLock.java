class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String s : deadends) {
            set.add(s);
        }

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.remove();
                if (curr.equals(target))
                    return level;
                if (set.contains(curr))
                    continue;

                char[] currArr = curr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char temp = currArr[j];

                    currArr[j] = (char) (((temp - '0' + 1) % 10) + '0');
                    String s1 = String.valueOf(currArr);
                    if (!set.contains(s1) && !visited.contains(s1)) {
                        visited.add(s1);
                        queue.add(s1);
                    }

                    currArr[j] = (char) (((temp - '0' + 9) % 10) + '0');
                    String s2 = String.valueOf(currArr);
                    if (!set.contains(s2) && !visited.contains(s2)) {
                        visited.add(s2);
                        queue.add(s2);
                    }

                    currArr[j] = temp;
                }
            }
            level += 1;
        }
        return -1;
    }
}
