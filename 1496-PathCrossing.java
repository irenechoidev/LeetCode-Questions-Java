class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add(x + "," + y);

        for (char c : path.toCharArray()) {
            if (c == 'N')
                y += 1;
            else if (c == 'S')
                y -= 1;
            else if (c == 'E')
                x += 1;
            else if (c == 'W')
                x -= 1;

            String curr = x + "," + y;
            if (set.contains(curr))
                return true;

            set.add(curr);

        }

        return false;
    }
}