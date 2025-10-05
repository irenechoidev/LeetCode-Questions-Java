class Solution {
    public int minimumRecolors(String blocks, int k) {

        int count = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W')
                count += 1;
        }

        int min = count;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W')
                count += 1;
            if (blocks.charAt(i - k) == 'W')
                count -= 1;
            min = Math.min(min, count);
        }

        return min;
    }
}
