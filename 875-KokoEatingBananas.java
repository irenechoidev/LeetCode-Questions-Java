class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = getMax(piles);

        int start = 1;
        int end = max;

        while (start < end) {
            int rate = start + (end - start) / 2;

            int totalHours = 0;
            for (int p : piles) {
                totalHours += p / rate;
                if (p % rate != 0)
                    totalHours += 1;
            }

            if (totalHours > h) {
                start = rate + 1;
            } else {
                end = rate;
            }
        }
        return end;
    }

    private int getMax(int[] arr) {
        int result = -1;
        for (int i : arr) {
            result = Math.max(result, i);
        }
        return result;
    }
}
