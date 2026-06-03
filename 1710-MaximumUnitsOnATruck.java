class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        for (int[] b : boxTypes) {
            int count = Math.min(b[0], truckSize);
            res += count * b[1];
            truckSize -= count;
            if (truckSize == 0)
                return res;
        }
        return res;
    }
}
